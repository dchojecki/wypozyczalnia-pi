package wypozyczalnia.to.zarzadzaniekontami;

import java.io.Serializable;

public class KontoPracownikaTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Stan {
		aktywne, nieaktywne, zablokowane, brakdostepu, dostep
	};

	private Stan stan;
	private String login;
	private String imie;
	private String nazwisko;
	/**
	 * @param stan the stan to set
	 */
	public void setStan(Stan stan) {
		this.stan = stan;
	}
	/**
	 * @return the stan
	 */
	public Stan getStan() {
		return stan;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param imie the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}
	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}
	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}

}
