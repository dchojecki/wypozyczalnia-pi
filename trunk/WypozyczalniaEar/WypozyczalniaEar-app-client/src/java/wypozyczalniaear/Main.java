/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalniaear;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.JFrame;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiOracleDAO;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.gui.GlowneOkno;
import wypozyczalnia.logika.zarzadzanieKontami.ZarzadzanieKontamiDelegacja;
import wypozyczalnia.logika.zarzadzanieKontami.ZarzadzanieKontamiDummy;
import wypozyczalnia.logika.zarzadzanieWypozyczeniami.ZarzadzanieWypozyczeniamiDummy;
import wypozyczalnia.logika.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiDelegacja;

/**
 *
 * @author marcin
 */
public class Main {

  //  @EJB
    private static ZarzadzanieKontami zarzadzaniekontami;
    //@EJB(name="ZarzadzanieWypozyczeniamiBean")
    private static ZarzadzanieWypozyczeniami wypozyczenia;



    public static void main(String[] args) {

        ZarzadzanieKontamiDelegacja.setZarzadzanieKontami(new ZarzadzanieKontamiDummy());
        //ZarzadzanieWypozyczeniamiDelegacja.getInstance().setRealSubject(new ZarzadzanieWypozyczeniamiDummy());



        GlowneOkno okienko = new GlowneOkno();
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.show();

    }
}
