package wypozyczalnia.managers;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.FilmyFactory;
import wypozyczalnia.dao.KontaFactory;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;

public class ZarzadzajZamowieniami {

	public void zamow(String login, Integer id) {
		KontoDAO konto = KontaFactory.getKonto(login);
		FilmDAO film = FilmyFactory.getFilm(id);
		
		if (konto != null && film != null) {
			PlytaDAO plyta = film.wolnyEgzemplarz();
			if (plyta != null) {
				plyta.zamow(konto);
				//konto.zamowione.add(plyta);
			}
		}
	}
}
