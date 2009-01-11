package wypozyczalnia.dao.plyty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;

@Entity
@DiscriminatorValue("PlytaWolna")
public class PlytaWolna extends StanPlyty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3454900551748351586L;

	public PlytaWolna() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void anuluj(PlytaDAO p) {
	}

	@Override
	public void wydaj(PlytaDAO p) {
	}

	@Override
	public void zamow(PlytaDAO plyta, KontoDAO komu) {
		plyta.setZamowiona(komu);
		ZamowienieDAO z = new ZamowienieDAO();
		PozycjaZamowieniaDAO pz = new PozycjaZamowieniaDAO();
		pz.setPlyta(plyta);
		z.getPozycje().add(pz);
		komu.getZamowienia().add(z);
		plyta.getFilm().getWolne().remove(plyta);
		plyta.setFilmWolne(null);
		plyta.setStan(new PlytaZarezerwowana());
	}

	@Override
	public void zwroc(PlytaDAO p) {
		// TODO Auto-generated method stub

	}

}
