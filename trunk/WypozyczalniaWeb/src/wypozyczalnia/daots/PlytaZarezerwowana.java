package wypozyczalnia.daots;

public class PlytaZarezerwowana extends StanPlyty {

	@Override
	public void anuluj() {
		plyta.zamowiona = null;
		plyta.setStan(new PlytaWolna());
	}

	@Override
	public void wydaj() {
		plyta.pozyczona = plyta.zamowiona;
		plyta.zamowiona = null;
		plyta.setStan(new PlytaPozyczona());
	}

	@Override
	public void zamow(KontoDAO komu) {

	}

	@Override
	public void zwroc() {

	}

}
