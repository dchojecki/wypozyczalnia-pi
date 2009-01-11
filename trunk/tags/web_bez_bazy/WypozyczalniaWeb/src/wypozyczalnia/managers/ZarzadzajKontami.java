package wypozyczalnia.managers;

import wypozyczalnia.dao.KontaFactory;
import wypozyczalnia.dao.KontoDAO;

public class ZarzadzajKontami {

	public KontoDAO zaloguj(String login, String haslo) {
		KontoDAO k = KontaFactory.getKonto(login);
		if (k != null) {
			if (k.getHaslo().equals(haslo)) {
				return k;
			}
		}
		return null;
	}
}
