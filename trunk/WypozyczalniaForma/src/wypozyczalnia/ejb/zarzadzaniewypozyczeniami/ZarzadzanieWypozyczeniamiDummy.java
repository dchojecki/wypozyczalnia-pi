/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieWypozyczeniamiDummy implements ZarzadzanieWypozyczeniami {

    private ArrayList<KlientTO> klienci = new ArrayList<KlientTO>(3);
    private Random r = new Random();
    private List<ZamowienieTO> zamowienia;

    public void initialize(){
        inicjujKlientow();
        zamowienia = new LinkedList<ZamowienieTO>();
        Calendar odd = Calendar.getInstance();
        Calendar doo = Calendar.getInstance();
        odd.set(2008, 5,1);
        doo.set(2008, 12,1);
        
        for (int i = 0; i < 14; ++i) {
            odd.set(2008, 4, 1 + r.nextInt(29));
            ZamowienieTO z = generujZamowienie(odd.getTime(), doo.getTime());
            z.setStanzamowienia(StanZamowienia.PRZYJETE);
            zamowienia.add(z);
        }


        for (int i = 0; i < 15; ++i) {
            odd.set(2008, 4, 1 + r.nextInt(29));
            ZamowienieTO z = generujZamowienie(odd.getTime(), doo.getTime());
            z.setStanzamowienia(StanZamowienia.DOODBIORU);
            zamowienia.add(z);
        }

        for (int i = 0; i < 11; ++i) {
            odd.set(2008, 4, 1 + r.nextInt(29));
            ZamowienieTO z = generujZamowienie(odd.getTime(), doo.getTime());
            z.setStanzamowienia(StanZamowienia.POZYCZONE);
            zamowienia.add(z);
        }

        for (int i = 0; i < 13; ++i) {
            odd.set(2008, 4, 1 + r.nextInt(29));
            ZamowienieTO z = generujZamowienie(odd.getTime(), doo.getTime());
            z.setStanzamowienia(StanZamowienia.ZREALIZOWANE);
            zamowienia.add(z);
        }
    }
    
    private ZamowienieTO generujZamowienie(Date odd, Date doo) {
        ZamowienieTO ret = new ZamowienieTO();
        ret.setCenaSumaryczna((float) 12.14);
        //ret.setDataOdbioru(odd);
        //ret.setDataOddania(odd);
        ret.setDataPrzyjecia(odd);
        ret.setDataRealizacji(odd);
        ret.setKlient(klienci.get(r.nextInt(3)));
        ret.setId(r.nextInt(1000));
        return ret;
    }

    private void inicjujKlientow() {
        KlientTO k1 = new KlientTO();
        k1.setNrPeselKlienta("85110916799");
        k1.setAdresMailowy("a@b.com");
        k1.setImie("aaa");
        k1.setNazwisko("bbb");
        klienci.add(k1);

        KlientTO k2 = new KlientTO();
        k1.setNrPeselKlienta("85110916700");
        k1.setAdresMailowy("abbb@b.com");
        k1.setImie("aasdfasdfaa");
        k1.setNazwisko("asdfsadfasdf");
        klienci.add(k2);

        KlientTO k3 = new KlientTO();
        k1.setNrPeselKlienta("85110916755");
        k1.setAdresMailowy("aa@bb.com");
        k1.setImie("abc");
        k1.setNazwisko("abc");
        klienci.add(k3);

    }

    public Collection<ZamowienieTO> pobierzZamowieniaWgCzasu(Date odd, Date doo) {

        Collection<ZamowienieTO> ret = new LinkedList<ZamowienieTO>();
        for(ZamowienieTO zamowienie : zamowienia){ 
            if(zamowienie.getDataPrzyjecia().before(doo) && zamowienie.getDataPrzyjecia().after(odd)) ret.add(zamowienie);
        }
        return ret;

    }
    
    public void setStan(int nr, StanZamowienia theStanZamowienia ){
        for(ZamowienieTO zamowienie : zamowienia){ 
            if(zamowienie.getId()==nr) zamowienie.setStanzamowienia(theStanZamowienia);
        }
    }
    
    public Collection<ZamowienieTO> pobierzZamowieniaWgStanu(Date odd, Date doo, String stan) {
        Collection<ZamowienieTO> ret = new LinkedList<ZamowienieTO>();
        for(ZamowienieTO zamowienie : zamowienia){
            if(zamowienie.getStanzamowienia().toString().compareTo(stan)==0 && zamowienie.getDataPrzyjecia().before(doo) && zamowienie.getDataPrzyjecia().after(odd)) ret.add(zamowienie);
        }
        return ret;
    }
    
    public Collection<ZamowienieTO> pobierzWszystkieZamowienia() {
        return pobierzZamowieniaWgCzasu(new Date(), new Date());
    }
}
