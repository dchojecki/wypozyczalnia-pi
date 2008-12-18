package wypozyczalnia.dao;

public class PlytaDAO {
	FilmDAO film;
	String nr;
	
	KontoDAO pozyczona, zamowiona;
	StanPlyty stan;
	
	public FilmDAO getFilm() {
		return film;
	}
	
	
	public PlytaDAO() {
		setStan(new PlytaWolna());
	}

	public void setStan (StanPlyty s) {
		stan = s;
		stan.setPlyta(this);
	}
	
	public void zamow(KontoDAO konto) {
		stan.zamow(konto);
	}

}
