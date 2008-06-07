/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

/**
 * 
 * @author marcin
 */
public class TransferObjectFactory {

	private TransferObjectFactory() {
	}

	public static AdresTO stworzAdresTO(KlientDAO klient) {
		AdresTO ret = new AdresTO();

		ret.setMiast(klient.getAdres().getMiasto());
		ret.setNrDomu(klient.getAdres().getNrDomu());
		ret.setNrMieszkania(klient.getAdres().getNrMieszkania());
		ret.setUlica(klient.getAdres().getUlica());
		ret.setNrPeselKlienta(klient.getNrpesel());
		return ret;
	}

	public static KontoTO stworzKontoTO(KlientDAO klient) {
		return stworzKontoTO(klient.zwrocPierwszeKonto());
	}

	public static KontoTO stworzKontoTO(KontoDAO konto) {
		KontoTO ret = new KontoTO();

		ret.setNrKonta(konto.getNrKonta());
		ret.setNrPeselKlienta(konto.getKlient().getNrpesel());
		ret.setDataOstatniegoLogowania(konto.getDataUstatniegoLogowania());
		ret.setDataOstatniejZmianyHasla(konto.getDataOstatniejZmianyHasla());
		ret.setStanKonta(konto.getStankonta());
		ret.setWygasloHaslo(konto.getWygasloHaslo());
		return ret;
	}

	public static KlientTO stworzKlientTO(KlientDAO klient) {
		KlientTO ret = new KlientTO();
		ret.setAdresMailowy(klient.getAdresMailowy());
		ret.setDataUrodzenia(klient.getDataUrodzenia());
		ret.setImie(klient.getImie());
		ret.setNazwisko(klient.getNazwisko());
		ret.setNrKonta(klient.zwrocPierwszeKonto().getNrKonta());
		ret.setNrPeselKlienta(klient.getNrpesel());
		return ret;
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

		for (PozycjaZamowieniaDAO pz : zam.getPozycje()) {
			ret.getPozycjezamowienia().add(stworzPozycjeZamowienia(pz));
		}

		return ret;
	}

	public static PozycjaZamowieniaTO stworzPozycjeZamowienia(
			PozycjaZamowieniaDAO pzD) {
		PozycjaZamowieniaTO ret = new PozycjaZamowieniaTO();
		ret.setCenaJednostkowa(pzD.getCenaJednostkowa());
		ret.setPlyta(stworzPlytaTO(pzD.getPlyta()));
		return ret;
	}

	public static Collection<ZamowienieTO> kopiujKolekcje(
			Collection<? extends ZamowienieDAO> zamowienia) {
		List<ZamowienieTO> zamowieniaTO = new LinkedList<ZamowienieTO>();
		Map<Integer, KontoTO> bufor = new HashMap<Integer, KontoTO>();

		for (ZamowienieDAO zamD : zamowienia) {
			ZamowienieTO zamT = TransferObjectFactory.stworzZamowienieTO(zamD);
			zamowieniaTO.add(zamT);

			KontoTO kontoTO = bufor.get(zamD.getKonto().getNrKonta());

			if (kontoTO == null) {
				kontoTO = stworzKontoTO(zamD.getKonto());
				bufor.put(kontoTO.getNrKonta(), kontoTO);
			}
			zamT.setKonto(kontoTO);
			}
		return zamowieniaTO;
	}

	public static FilmTO stworzFilmTO(FilmDAO film) {
		FilmTO ret = new FilmTO();
		ret.setId(film.getId());
		ret.setOpisFabuly(film.getOpisFabuly());
		ret.setRokPremiery(film.getRokPremiery());
		ret.setTytul(film.getTytul());
		return ret;

	}

	public static PlytaTO stworzPlytaTO(PlytaDAO plyta) {
		PlytaTO ret = new PlytaTO();
		ret.setDataNabycia(plyta.getDataNabycia());
		ret.setIdFilmu(plyta.getFilm().getId());
		ret.setStan(plyta.getStanplyty());
		ret.setTytul(plyta.getFilm().getTytul());
		ret.setIdPlyty(plyta.getId());
		ret.setUwagiDoEgzemplarza(plyta.getUwagiDoEgzemplarza());
		return ret;
	}

	public static FilmTOZbior stworzFilmyTO(Collection<FilmDAO> filmy) {
		LinkedList<FilmTO> ret = new LinkedList<FilmTO>();
		for (FilmDAO f : filmy) {
			ret.add(stworzFilmTO(f));
		}
		return new FilmTOZbior(ret);
	}

	public static PlytaTOZbior stworzPlytyTO(Collection<PlytaDAO> plyty) {
		LinkedList<PlytaTO> ret = new LinkedList<PlytaTO>();

		for (PlytaDAO p : plyty) {
			ret.add(stworzPlytaTO(p));
		}
		return new PlytaTOZbior(ret);

	}
}
