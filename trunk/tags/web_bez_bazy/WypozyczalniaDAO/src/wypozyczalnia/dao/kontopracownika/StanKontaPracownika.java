package wypozyczalnia.dao.kontopracownika;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class StanKontaPracownika implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public StanKontaPracownika() {
		// TODO Auto-generated constructor stub
	}
	
	public void loguj(KontoPracownikaDAO konto, String i_haslo) {
		throw new NieobsluzoneZdarzenie();
	}

	public void wyloguj(KontoPracownikaDAO konto) {
		throw new NieobsluzoneZdarzenie();
		
	}

	public void zablokuj(KontoPracownikaDAO konto) {
		throw new NieobsluzoneZdarzenie();
		
	}

	public void odblokuj(KontoPracownikaDAO konto) {
		throw new NieobsluzoneZdarzenie();
	}
	
	public void entry() {}
	public void exit() {}
	public void doo() {}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
}
