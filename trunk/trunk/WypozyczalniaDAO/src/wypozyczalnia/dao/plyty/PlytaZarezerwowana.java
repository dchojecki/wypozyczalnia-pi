package wypozyczalnia.dao.plyty;

import java.util.Collection;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;

@Entity
@DiscriminatorValue("PlytaZarezerwowana")
public class PlytaZarezerwowana extends StanPlyty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3024462573213510207L;

	/**
	 * 
	 */

	public PlytaZarezerwowana() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void anuluj(PlytaDAO plyta, KontoDAO konto) {
		plyta.setZamowiona(null);
		FilmDAO film = plyta.getFilm();
		film.anulujPlyte(plyta);
		plyta.setStan(new PlytaWolna());

		Collection<ZamowienieDAO> zamowienia = konto.getZamowienia();
		ZamowienieDAO found = null;
		for (ZamowienieDAO z : zamowienia) {
			Set<PozycjaZamowieniaDAO> pozycje = z.getPozycje();
			for (PozycjaZamowieniaDAO pozycjaZamowieniaDAO : pozycje) {
				if (pozycjaZamowieniaDAO.getPlyta().equals(plyta))
					found = z;
			}
		}
		film.getWolne().add(plyta);
		plyta.setFilmWolne(film);
		if (found != null) {
			zamowienia.remove(found);
		}
	}

	@Override
	public void wydaj(PlytaDAO plyta) {
		plyta.setPozyczona(plyta.getZamowiona());
		plyta.setZamowiona(null);
		plyta.setStan(new PlytaPozyczona());
	}

	@Override
	public void zamow(PlytaDAO plyta, KontoDAO komu) {

	}

	@Override
	public void zwroc(PlytaDAO plyta) {

	}

}
