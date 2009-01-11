package wypozyczalnia.managers;

import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.daots.KontaFactory;

public class ZarzadzajKontami {

	public KontoDAO zaloguj(String login, String haslo) {
		KontoDAO k = KontaFactory.getKonto(login);
		if (k != null) {
			if (k.getSkrotHasla().equals(haslo)) {
				return k;
			}
		}
		return null;
	}
}
