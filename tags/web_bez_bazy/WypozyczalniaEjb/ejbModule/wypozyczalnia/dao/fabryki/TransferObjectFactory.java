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
import wypozyczalnia.dao.kontopracownika.KontoPracownikaDAO;
import wypozyczalnia.dao.kontopracownika.StanAktywne;
import wypozyczalnia.dao.kontopracownika.StanBrakDostepu;
import wypozyczalnia.dao.kontopracownika.StanDostep;
import wypozyczalnia.dao.kontopracownika.StanKontaPracownika;
import wypozyczalnia.dao.kontopracownika.StanNieaktywne;
import wypozyczalnia.dao.kontopracownika.StanZablokowane;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
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
		if (konto == null)
			return null;
		KontoTO ret = new KontoTO();

		ret.setNrKonta(konto.getNrKonta());
		ret.setNrPeselKlienta(konto.getKlient().getNrpesel());
		ret.setDataOstatniegoLogowania(konto.getDataUstatniegoLogowania());
		ret.setDataOstatniejZmianyHasla(konto.getDataOstatniejZmianyHasla());
		ret.setStanKonta(konto.getStankonta());
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
		ret.setKonto(stworzKontoTO(zam.getKonto()));
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

	public static KontoPracownikaTO stworzKontoPracownikaTO(
			KontoPracownikaDAO konto) {
		KontoPracownikaTO ret = new KontoPracownikaTO();
		ret.setImie(konto.getPracownik().getImie());
		ret.setNazwisko(konto.getPracownik().getNazwisko());
		ret.setLogin(konto.getLogin());

		StanKontaPracownika stan = konto.getStan();
		ret.setStan(stworzStanKontaPracownika(stan));

		return ret;
	}

	public static KontoPracownikaTO.Stan stworzStanKontaPracownika(
			StanKontaPracownika stan) {
		if (stan.getClass().equals(StanNieaktywne.class))
			return KontoPracownikaTO.Stan.nieaktywne;
		if (stan.getClass().equals(StanAktywne.class))
			return KontoPracownikaTO.Stan.aktywne;
		if (stan.getClass().equals(StanZablokowane.class))
			return KontoPracownikaTO.Stan.zablokowane;

		if (stan.getClass().equals(StanBrakDostepu.class))
			return KontoPracownikaTO.Stan.brakdostepu;
		if (stan.getClass().equals(StanDostep.class))
			return KontoPracownikaTO.Stan.dostep;

		return null;
	}
}
