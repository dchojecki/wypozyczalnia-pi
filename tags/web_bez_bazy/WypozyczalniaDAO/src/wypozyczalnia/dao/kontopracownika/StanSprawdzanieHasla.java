package wypozyczalnia.dao.kontopracownika;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("StanSprawdzanieHasla")
public class StanSprawdzanieHasla extends StanAutoryzacja {

	/**
	 * 
	 */
	private static final long serialVersionUID = -786628512847274867L;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "kontoId")
	private KontoPracownikaDAO konto;
	private String i_haslo;

	public StanSprawdzanieHasla() {
		// TODO Auto-generated constructor stub
	}

	public StanSprawdzanieHasla(KontoPracownikaDAO konto, String i_haslo) {
		this.konto = konto;
		this.i_haslo = i_haslo;
	}

	@Override
	public void doo() {
		konto.getStan().exit();
		if (konto.hasloJestPoprawne(i_haslo))
			konto.setStan(new StanDostep(konto));
		else
			konto.setStan(new StanBrakDostepu(konto));

		konto.getStan().entry();
		konto.getStan().doo();
	}

}
