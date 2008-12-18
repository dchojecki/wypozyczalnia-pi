package wypozyczalnia.dao;

public abstract class StanPlyty {
	protected PlytaDAO plyta;
	
	public void setPlyta(PlytaDAO p) {
		plyta = p;
	}
	public PlytaDAO getPlyta() {
		return plyta;
	}
	
	public abstract void zamow(KontoDAO komu);
	public abstract void anuluj();
	public abstract void wydaj();
	public abstract void zwroc();

}
