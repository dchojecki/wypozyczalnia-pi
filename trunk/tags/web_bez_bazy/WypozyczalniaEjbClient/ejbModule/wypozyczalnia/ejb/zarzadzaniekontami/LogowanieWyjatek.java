package wypozyczalnia.ejb.zarzadzaniekontami;

import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;

public class LogowanieWyjatek extends Exception {

	public LogowanieWyjatek(String string, KontoPracownikaTO.Stan stan) {
		super(string);
		this.setStan(stan);
	}
	
	public LogowanieWyjatek(String string) {
		this(string, null);
	}

	/**
	 * @param stan the stan to set
	 */
	public void setStan(KontoPracownikaTO.Stan stan) {
		this.stan = stan;
	}

	/**
	 * @return the stan
	 */
	public KontoPracownikaTO.Stan getStan() {
		return stan;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private KontoPracownikaTO.Stan stan;

}
