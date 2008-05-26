/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testy.fixtures;

import java.util.Date;

import fit.ColumnFixture;
import java.text.SimpleDateFormat;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.*;

/**
 *
 * @author sirtopp
 */
public class ZmienStanPrepare extends ColumnFixture {
    public String data;
    public String stan;
    public int id;
    public String pesel;
    
    public static ZarzadzanieWypozyczeniami delegat;
    
    public ZmienStanPrepare(){
        delegat = new ZarzadzanieWypozyczeniamiDummy();
        System.out.println("Przygotowania...");
    }

    @Override
    public void execute() throws Exception{
        ZamowienieTO z = new ZamowienieTO();
        KlientTO k = new KlientTO();
        StanZamowienia s;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(data);
        s = StanZamowienia.valueOf(stan);
        k.setNrPeselKlienta(pesel);
        z.setDataPrzyjecia(d);
        z.setId(id);
        z.setKlient(k);
        z.setStanzamowienia(s);
        delegat.noweZamowienie(z);
        if (delegat.pobierzZamowienie(id) == null){
            System.out.println("Nie dodano!");
        }
    }
}
