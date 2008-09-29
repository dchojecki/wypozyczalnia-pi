package wypozyczalniaklient.walidacja;

public class KreatorNowegoKontaWalidacja {

	public static String zwalidujPESEL(String input) {
		if ("85110916799".equals(input)) return null;
		return new String("ale przeciez pesel Waszego PM'a to 85110916799");
	}
}
