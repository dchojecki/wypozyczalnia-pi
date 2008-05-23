/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalniaear;

import javax.ejb.EJB;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.logika.zarzadzanieKontami.ZarzadzanieKontamiDelegacja;
import wypozyczalnia.logika.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiDelegacja;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/**
 *
 * @author marcin
 */
public class Main {

    @EJB(mappedName = "ZarzadzanieKontamiBean")
    private static ZarzadzanieKontami zarzadzaniekontami;
    @EJB
    private static ZarzadzanieWypozyczeniami zarzadzanieWypozyczeniami;


    public static void main(String[] args) {
        ZarzadzanieWypozyczeniamiDelegacja.getInstance().setRealSubject(zarzadzanieWypozyczeniami);
        ZarzadzanieKontamiDelegacja.setZarzadzanieKontami(zarzadzaniekontami);
        
                
        ZamowienieTO z1 = zarzadzanieWypozyczeniami.utworzNoweZamowienie();
        ZamowienieTO z2 = zarzadzanieWypozyczeniami.utworzNoweZamowienie();
        
        z1.setStanzamowienia(StanZamowienia.DOODIORU);
        z2.setStanzamowienia(StanZamowienia.ANULOWANE);
        
        zarzadzanieWypozyczeniami.scalDaneZamowienia(z1);
        zarzadzanieWypozyczeniami.scalDaneZamowienia(z2);
        

    }
}
