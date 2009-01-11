package wypozyczalnia.daots;

import java.util.HashMap;

import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;

public class KontaFactory {
	private static HashMap<String, KontoDAO> _konta = new HashMap<String, KontoDAO>();

	public static KontoDAO getKonto(String login) {
		if (_konta.containsKey(login)) {
			return _konta.get(login);
		} else {
			return null;
		}
	}

	public KontaFactory() {
		KontoDAO kk;
		KlientDAO k = new KlientDAO();
		k.setImie("jasiu");

		kk = new KontoDAO();
		kk.setKlient(k);
		kk.setLogin("jasiu");
		kk.setSkrotHasla("jasiu");

		_konta.put(kk.getLogin(), kk);
	}
}
