package wypozyczalnia.dao;

public class PlytaWolna extends StanPlyty {

	@Override
	public void anuluj() {
	}

	@Override
	public void wydaj() {
	}

	@Override
	public void zamow(KontoDAO komu) {
		plyta.zamowiona = komu;
		komu.zamowione.add(plyta);
		plyta.film.wolne.remove(plyta);
		plyta.setStan(new PlytaZarezerwowana());
	}

	@Override
	public void zwroc() {
		// TODO Auto-generated method stub
		
	}

}
