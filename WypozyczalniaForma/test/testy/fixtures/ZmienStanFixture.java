/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testy.fixtures;

import fit.ColumnFixture;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.*;

/**
 *
 * @author sirtopp
 */
public class ZmienStanFixture extends ColumnFixture{
    public int id;
    public String nowyStan;
    
    private static ZarzadzanieWypozyczeniami delegat;
    
    public ZmienStanFixture(){
        delegat = ZmienStanPrepare.delegat;
        System.out.println("Testowanie...");
    }
    
    private ZamowienieTO z;
    
    private void _zmienStan(){
        if (nowyStan != null && nowyStan.compareTo("") != 0){
            delegat.setStan(id, StanZamowienia.valueOf(nowyStan));
        }
    }
    
    public String stan(){
        _zmienStan();
        ZamowienieTO z = delegat.pobierzZamowienie(id);
        if (z == null)
            return "Brak zamowienia!";
        else 
            return z.getStanzamowienia().toString();
    }
}
