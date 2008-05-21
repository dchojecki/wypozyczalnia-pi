/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalniaear;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Binding;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiOracleDAO;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.DerbyPUBeanBean;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.DerbyPUBeanRemote;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;

/**
 *
 * @author marcin
 */
public class Main {

    @EJB(mappedName = "ZarzadzanieKontamiBean")
    private static ZarzadzanieKontami zarzadzaniekontami;
    @EJB
    private static ZarzadzanieWypozyczeniami wypozyczenia;
    @PersistenceContext(unitName = "WypozyczalniaEar-ejbPU")
    private EntityManager em;

    void test() {
        try {
            boolean glassfish;
            AdresDAO adres = new AdresDAO();
            adres.setMiasto("wroclaiaw");
            InitialContext ic = new InitialContext();
            try {
                NamingEnumeration<Binding> ne = ic.listBindings("");
                while (ne.hasMore()) {
                    Binding b = (Binding) ne.next();
                    // HACK: RozrĂłĹĽnij Geronimo vs GlassFish
                    String name = b.getName();
                    if (!name.startsWith("java:comp/env")) {
                        // Pracujemy z Geronimo
                        name = "java:comp/env" + "/" + name;
                        glassfish = false;
                    } else {
                        glassfish = true;
                    }
                    System.out.println(String.format("%s -> %s", name, b.getClassName()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            em = (EntityManager) ic.lookup("java:comp/env/persistence/DerbyPU");
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Hashtable env = new Hashtable();
        InitialContext ic;
        EntityManager em;
        try {
            ic = new InitialContext();
            DerbyPUBeanRemote pu = (DerbyPUBeanRemote) ic.lookup("DerbyPUBeanBean");
            em = pu.getEntityManager();
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Main().test();



        zarzadzaniekontami.czyKlientZarejestrowany("85110916799");
        wypozyczenia.pobierzWszystkieZamowienia();
        ZarzadzanieKontamiOracleDAO wwyp = new ZarzadzanieKontamiOracleDAO();
        KlientDAO klient = wwyp.utworzNoweKonto();

        wypozyczenia.pobierzWszystkieZamowienia();
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("WypozyczalniaDAODerbyPU");
    //EntityManager em = emf.createEntityManager();

    //  ZarzadzanieKontamiDelegacja.setZarzadzanieKontami(new ZarzadzanieKontamiDummy());

//        ZarzadzanieWypozyczeniamiDelegacja.getInstance().setRealSubject(new ZarzadzanieWypozyczeniamiDummy());



    //  GlowneOkno okienko = new GlowneOkno();
    //    okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //      okienko.show();

    }
}
