/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalniaear;

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
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypOracleDAO;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;

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
        KlientTO kl = new KlientTO();
        AdresTO ad = new AdresTO();
        ZarzWypOracleDAO z = new ZarzWypOracleDAO();
        ZamowienieDAO zz = z.utworzNoweZamowienie();
        
    //  GlowneOkno okienko = new GlowneOkno();
    //    okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //      okienko.show();

    }
}
