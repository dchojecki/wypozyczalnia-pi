package wypozyczalnia.dao.kontopracownika;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("StanAktywne")
public class StanAktywne extends StanKontaPracownika {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StanAktywne(KontoPracownikaDAO konto) {
		konto.resetujLicznikBlednychProb();
	}

	public StanAktywne() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void wyloguj(KontoPracownikaDAO konto) {
		konto.getStan().exit();
		konto.setStan(new StanNieaktywne());
		konto.getStan().entry();
		konto.getStan().doo();
	}

}
