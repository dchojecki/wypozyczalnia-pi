package wypozyczalnia.dao.kontopracownika;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("StanNieAktywne")
public class StanNieaktywne extends StanKontaPracownika {

	/**
	 * 
	 */

	public StanNieaktywne() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 61958249898716058L;

	@Override
	public void loguj(KontoPracownikaDAO konto, String i_haslo) {
		konto.getStan().exit();
		konto.setStan(new StanSprawdzanieHasla(konto, i_haslo));
		konto.getStan().entry();
		konto.getStan().doo();
	}

	@Override
	public void zablokuj(KontoPracownikaDAO konto) {
		konto.getStan().exit();
		konto.setStan(new StanZablokowane(konto));
		konto.getStan().entry();
		konto.getStan().doo();
	}

}
