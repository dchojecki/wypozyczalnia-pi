package wypozyczalnia.dao;

import java.util.Collection;
import java.util.HashSet;

public class KontoDAO {

	String login, haslo, imie, nazwisko;
	public Collection<PlytaDAO> zamowione;
	Collection<PlytaDAO> pozyczone;
	
	public KontoDAO() {
		zamowione = new HashSet<PlytaDAO>();
		pozyczone = new HashSet<PlytaDAO>();
	}
	
	public Collection<PlytaDAO> getZamowione() {
		return zamowione;
	}
	
	public String getImie() {
		return imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}

	public String getLogin() {
		return login;
	}

	public String getHaslo() {
		return haslo;
	}
}
