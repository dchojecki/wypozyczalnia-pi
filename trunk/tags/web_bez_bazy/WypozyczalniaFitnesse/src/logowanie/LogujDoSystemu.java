package logowanie;

import wypozyczalnia.ejb.zarzadzaniekontami.LogowanieWyjatek;
import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
import fit.ColumnFixture;

public class LogujDoSystemu extends ColumnFixture {

	public String login;
	public String haslo;
	public int wyloguj;

	private String zalogowany;
	private String komunikat;
	private String stan;

	public void reset() {
		login = null;
		haslo = null;
		zalogowany = null;
		komunikat = null;
		stan = null;
	}

	public void execute() {
		zalogowany = "tak";
		KontoPracownikaTO konto = null;
		try {
			konto = SetUp.konta.zaloguj(login, haslo);
			stan = konto.getStan().toString();

		} catch (LogowanieWyjatek e) {
			komunikat = e.getMessage();
			zalogowany = "nie";

			if (e.getStan() != null)
				stan = e.getStan().toString();
			else
				stan = "N/D";
		}

		if ("tak".equals(zalogowany) && wyloguj == 1) {
			try {
				SetUp.konta.wyloguj(login);
			} catch (LogowanieWyjatek e) {
				e.printStackTrace();
			}
		}

	}

	public String zalogowany() {
		return zalogowany;
	}

	public String stan() {
		return stan;
	}

	public String komunikat() {
		if (komunikat == null)
			return "N/D";
		else
			return komunikat;
	}
}
