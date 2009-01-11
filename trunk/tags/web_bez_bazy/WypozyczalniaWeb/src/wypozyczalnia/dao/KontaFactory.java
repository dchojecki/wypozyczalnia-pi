package wypozyczalnia.dao;

import java.util.HashMap;

public class KontaFactory {
	private static HashMap<String, KontoDAO>_konta = new HashMap<String, KontoDAO>();

	public static KontoDAO getKonto(String login) {
		if (_konta.containsKey(login)) {
			return _konta.get(login);
		} else {
			return null;
		}
	}
	
	public KontaFactory() {
		KontoDAO k;
		
		k = new KontoDAO();
		k.login = "jasiu";
		k.haslo = "jasiu";
		k.imie = "Jaroslaw";
		k.nazwisko = "Jasinski";
		
		_konta.put(k.login, k);
	}
}
