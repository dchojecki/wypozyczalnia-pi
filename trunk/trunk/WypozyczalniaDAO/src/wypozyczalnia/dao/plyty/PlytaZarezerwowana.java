package wypozyczalnia.dao.plyty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
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
		FilmDAO film = plyta.getFilm();
		film.anulujPlyte(plyta);

		ZamowienieDAO found = konto.zwrocZamowieniePlyty(plyta);
		konto.usunZamowienie(found);

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
