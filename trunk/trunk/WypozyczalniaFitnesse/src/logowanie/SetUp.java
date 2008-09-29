package logowanie;

import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontamiBean;
import fit.Fixture;

public class SetUp extends Fixture {
	static ZarzadzanieKontamiBean konta;

	public SetUp() {
		konta = new ZarzadzanieKontamiBean();
		konta.dodajPracownika("marcin", "kowalski", "root", "1234", true);
		konta.dodajPracownika("marcin", "kowalski", "mkowalski", "kubuspuchatek", false);

	}
	
	
	public static void main(String args[]) {
		SetUp s = new SetUp();
		LogujDoSystemu l = new LogujDoSystemu();
		l.login = "mkowalski";
		l.haslo = "kubuspuchatek";
		l.wyloguj= 1;
		l.execute();
		System.out.println(l.komunikat() + '|' + l.stan());
		l.login = "mkowalski";
		l.haslo = "osiolek";
		l.wyloguj= 1;
		l.execute();
		System.out.println(l.komunikat() + '|' + l.stan());
	}
}
