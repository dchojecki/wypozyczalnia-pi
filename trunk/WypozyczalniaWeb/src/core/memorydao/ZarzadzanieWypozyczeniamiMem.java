package core.memorydao;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.plyty.StanPlyty;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniamiLocal;

public class ZarzadzanieWypozyczeniamiMem implements
		ZarzadzanieWypozyczeniamiLocal {

	@Override
	public void zamow(KontoDAO konto, FilmDAO film) {
		if (konto != null && film != null) {
			PlytaDAO plyta = film.wolnyEgzemplarz();
			if (plyta != null) {
				StanPlyty s = plyta.getStan();
				s.zamow(plyta, konto);

				Storage.filmyBufor.put(film.getId(), film);
				Storage.plytyBufor.put(plyta.getId(), plyta);
			}
		}

	}

	@Override
	public void anuluj(KontoDAO konto, PlytaDAO plyta) {
		if (konto != null && plyta != null) {
			StanPlyty s = plyta.getStan();
			s.anuluj(plyta, konto);

			Storage.plytyBufor.put(plyta.getId(), plyta);
		}
	}

}
