/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.logika.zarzadzanieWypozyczeniami;

import java.util.ArrayList;
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

    private ZamowienieTO generujZamowienie(Date odd, Date doo) {
        ZamowienieTO ret = new ZamowienieTO();
        ret.setCenaSumaryczna((float) 12.14);
        ret.setDataDoOdbioru(odd);
        ret.setDataRealizacji(odd);
        ret.setDataPrzyjecia(odd);
        ret.setDataRealizacji(odd);
        ret.setKlient(klienci.get(r.nextInt(3)));
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

        inicjujKlientow();
        List<ZamowienieTO> zamowienia = new LinkedList<ZamowienieTO>();


        for (int i = 0; i < 4; ++i) {
            ZamowienieTO z = generujZamowienie(odd, doo);
            z.setStanzamowienia(StanZamowienia.PRZYJETE);
            zamowienia.add(z);
        }


        for (int i = 0; i < 5; ++i) {
            ZamowienieTO z = generujZamowienie(odd, doo);
            z.setStanzamowienia(StanZamowienia.DOODIORU);
            zamowienia.add(z);
        }

        for (int i = 0; i < 1; ++i) {
            ZamowienieTO z = generujZamowienie(odd, doo);
            z.setStanzamowienia(StanZamowienia.POZYCZONE);
            zamowienia.add(z);
        }

        for (int i = 0; i < 3; ++i) {
            ZamowienieTO z = generujZamowienie(odd, doo);
            z.setStanzamowienia(StanZamowienia.ZREALIZOWANE);
            zamowienia.add(z);
        }
        return zamowienia;

    }

    public Collection<ZamowienieTO> pobierzWszystkieZamowienia() {
        return pobierzZamowieniaWgCzasu(new Date(), new Date());
    }

    public void scalDaneZamowienia(ZamowienieTO zam) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
