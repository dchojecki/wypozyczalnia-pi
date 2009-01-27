package wypozyczalnia.dao.plyty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;

@Entity
@DiscriminatorValue("PlytaPozyczona")
public class PlytaPozyczona extends StanPlyty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3928239284235190660L;

	public PlytaPozyczona() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void wydaj(PlytaDAO plyta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void zamow(PlytaDAO plyta, KontoDAO komu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void zwroc(PlytaDAO plyta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void anuluj(PlytaDAO p, KontoDAO komu) {
		// TODO Auto-generated method stub

	}

}
