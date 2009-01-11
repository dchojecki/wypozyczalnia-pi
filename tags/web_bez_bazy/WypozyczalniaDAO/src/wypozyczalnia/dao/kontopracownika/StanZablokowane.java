package wypozyczalnia.dao.kontopracownika;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("StanZablokowane")
public class StanZablokowane extends StanKontaPracownika {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339818926853487503L;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "kontoId")
	private KontoPracownikaDAO konto;

	public StanZablokowane() {
		// TODO Auto-generated constructor stub
	}

	public StanZablokowane(KontoPracownikaDAO konto) {
		this.konto = konto;
	}

	@Override
	public void exit() {
		konto.resetujLicznikBlednychProb();
	}

	@Override
	public void odblokuj(KontoPracownikaDAO konto) {
		konto.getStan().exit();
		konto.setStan(new StanNieaktywne());

		konto.getStan().entry();
		konto.getStan().doo();

	}

	@Override
	public void loguj(KontoPracownikaDAO konto, String i_haslo) {
	}

}
