package wypozyczalnia.dao.kontopracownika;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("StanBrakDostepu")
public class StanBrakDostepu extends StanAutoryzacja {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "kontoId")
	private KontoPracownikaDAO konto;

	public StanBrakDostepu(KontoPracownikaDAO konto) {
		this.konto = konto;
	}

	public StanBrakDostepu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doo() {
		konto.inkrementujLiczbeNieudanychProb();

		konto.getStan().exit();

		if (konto.getLicznikNieudanychProb() < 3
				|| konto.getPracownik().czyJestAdministratorem())
			konto.setStan(new StanNieaktywne());
		else
			konto.setStan(new StanZablokowane(konto));

		konto.getStan().entry();
		konto.getStan().doo();

	}

}
