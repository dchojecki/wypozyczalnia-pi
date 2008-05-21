/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki;

import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/**
 *
 * @author marcin
 */
public class TransferObjectFactory {

    private TransferObjectFactory() {
    }

    public static AdresTO stworzAdresTO(KlientDAO klient) {
        return null;
    }

    public static AdresTO stworzKlientTO(AdresDAO adres) {
        return null;
    }

    public static ZamowienieTO stworzZamowienieTO(ZamowienieDAO zam) {
        ZamowienieTO ret = new ZamowienieTO();
        ret.setDataPrzyjecia(zam.getDataPrzyjecia());
        ret.setDataRealizacji(zam.getDataRealizacji());
        ret.setDataZalegle(zam.getDataZalegle());
        ret.setDataAnulowane(zam.getDataAnulowania());
        ret.setDataPrzyjecia(zam.getDataPrzyjecia());
        ret.setDataDoOdbioru(zam.getDataDoOdbioru());
        return ret;
    }

    public static PozycjaZamowieniaTO stworzPozycjeZamowienia(PozycjaZamowieniaDAO pzD) {
        PozycjaZamowieniaTO ret = new PozycjaZamowieniaTO();
        ret.setCenaJednostkowa(pzD.getCenaJednostkowa());
        ret.setTytulFilmu(pzD.getPlyta().getFilm().getTytul());
        return ret;
    }
}
