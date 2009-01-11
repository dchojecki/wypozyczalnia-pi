package wypozyczalnia.dao.kontopracownika;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("StanDostep")
public class StanDostep extends StanAutoryzacja {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4611210205374138782L;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "kontoId")
	private KontoPracownikaDAO konto;

	public StanDostep(KontoPracownikaDAO konto) {
		this.konto = konto;
	}

	public StanDostep() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doo() {
		konto.rejestrujCzasLogowania();
		konto.setStan(new StanAktywne(konto));
	}

}
