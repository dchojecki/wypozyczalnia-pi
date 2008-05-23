/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki;

import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
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
    
    public static KontoTO stworzKontoTO(KlientDAO klient) {
        KontoTO konto = new KontoTO();
        KontoDAO d = klient.zwrocPierwszeKonto();
        
        konto.setNrKonta(d.getNrKonta());
        konto.setNrPeselKlienta(klient.getNrpesel());
        // TODO wypelnic obiekt konto
        return konto;
    }

    public static KlientTO stworzKlientTO(AdresDAO adres) {
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
        ret.setStanzamowienia(zam.getStanzamowienia());
        ret.setId(zam.getId());
        
        for (PozycjaZamowieniaDAO pz: zam.getPozycje()) {
            ret.getPozycjezamowienia().add(stworzPozycjeZamowienia(pz));
        }
        
        return ret;
    }

    public static PozycjaZamowieniaTO stworzPozycjeZamowienia(PozycjaZamowieniaDAO pzD) {
        PozycjaZamowieniaTO ret = new PozycjaZamowieniaTO();
        ret.setCenaJednostkowa(pzD.getCenaJednostkowa());
        ret.setTytulFilmu(pzD.getPlyta().getFilm().getTytul());
        return ret;
    }
}
