package wypozyczalnia.dao.kontopracownika;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("StanAutoryzacja")
public class StanAutoryzacja extends StanKontaPracownika {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StanAutoryzacja() {
		// TODO Auto-generated constructor stub
	}
}
