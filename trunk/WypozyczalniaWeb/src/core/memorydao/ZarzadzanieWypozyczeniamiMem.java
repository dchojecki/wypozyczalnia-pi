package core.memorydao;

import java.util.HashMap;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.plyty.StanPlyty;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniamiLocal;

public class ZarzadzanieWypozyczeniamiMem implements
		ZarzadzanieWypozyczeniamiLocal {
	private HashMap<String, PlytaDAO> plytyBufor = new HashMap<String, PlytaDAO>();
	private HashMap<String, FilmDAO> filmyBufor = new HashMap<String, FilmDAO>();

	@Override
	public void zamow(KontoDAO konto, FilmDAO film) {
		if (konto != null && film != null) {
			PlytaDAO plyta = film.wolnyEgzemplarz();
			if (plyta != null) {
				// plyta.zamow(konto);
				StanPlyty s = plyta.getStan();
				s.zamow(plyta, konto);
				filmyBufor.put(plyta.getId(), film);
				plytyBufor.put(plyta.getId(), plyta);
				// konto.zamowione.add(plyta);
			}
		}

	}

	@Override
	public void anuluj(KontoDAO konto, PlytaDAO plyta) {
		if (konto != null && plyta != null) {
			// konto.anuluj(plyta);
			StanPlyty s = plyta.getStan();
			s.anuluj(plyta, konto);
			plytyBufor.put(plyta.getId(), plyta);
		}
	}

}
