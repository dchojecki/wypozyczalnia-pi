/**
 * 
 */
package wypozyczalniaklient.delegacje.konta;

import java.util.Date;

import javax.ejb.EJB;

import wypozyczalnia.ejb.zarzadzaniekontami.LogowanieWyjatek;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTOZbior;
import wypozyczalniaklient.delegacje.konta.walidacja.IWalidatorDanychKonta;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKonta;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKontaWyjatek;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieKontamiDelegacja {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@EJB
	private static ZarzadzanieKontami zarzadzaniekontami;

	public static void setZarzadzanieKontami(ZarzadzanieKontami zarza) {
		zarzadzaniekontami = zarza;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static final ZarzadzanieKontamiDelegacja instance = new ZarzadzanieKontamiDelegacja();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontamiDelegacja() {
		// begin-user-code
		// TODO: Implement constructor logic
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ZarzadzanieKontamiDelegacja getInstance() {
		// begin-user-code

		return instance;
		// end-user-code
	}

	public KontoTO utworzNoweKonto(String nazwisko, String imie,
			Date dataUrodzenia, String nrPesel, String mail)
			throws ZarzadzanieKontamiWyjatek, WalidatorDanychKontaWyjatek {

		IWalidatorDanychKonta walidator = WalidatorDanychKonta
				.pobierzWalidator(false);
		// walidator.zwalidujDateUrodzenia(dataUrodzeniaString);
		walidator.zwalidujImie(imie);
		walidator.zwalidujNazwisko(nazwisko);
		walidator.zwalidujMail(mail);
		walidator.zwalidujPESEL(nrPesel);

		try {
			KlientTO klient = new KlientTO();
			klient.setImie(imie);
			klient.setNazwisko(nazwisko);
			klient.setAdresMailowy(mail);
			klient.setNrPeselKlienta(nrPesel);
			klient.setDataUrodzenia(dataUrodzenia);

			AdresTO adres = new AdresTO();

			if (zarzadzaniekontami == null) {
				throw new ZarzadzanieKontamiWyjatek("delegacja pusta");
			}
			return zarzadzaniekontami.zarejestrujKlienta(klient, adres);
		} catch (Exception e) {
			throw new ZarzadzanieKontamiWyjatek(e.getMessage());
		}

	}

	public boolean czyPolaczenieNawiazane() {
		return zarzadzaniekontami != null;
	}

	public boolean czyUzytkownikZarejestrowany(String pesel)
			throws WalidatorDanychKontaWyjatek, ZarzadzanieKontamiWyjatek {
		IWalidatorDanychKonta walidator = WalidatorDanychKonta
				.pobierzWalidator(false);
		walidator.zwalidujPESEL(pesel);
		return zarzadzaniekontami.czyKlientZarejestrowany(pesel);

	}

	public void zablokujKonto(KlientTO klient) throws ZarzadzanieKontamiWyjatek {
		try {
			zarzadzaniekontami.zablokujKonto(klient);
		} catch (Exception e) {
			throw new ZarzadzanieKontamiWyjatek(e.getMessage());
		}
	}

	public KlientTO zwrocDaneKlienta(String nrPesel)
			throws ZarzadzanieKontamiWyjatek {
		try {
			return zarzadzaniekontami.zwrocDaneKlienta(nrPesel);
		} catch (Exception e) {
			throw new ZarzadzanieKontamiWyjatek(e.getMessage());
		}
	}

	public AdresTO zwrocDaneAdresu(String nrPesel)
			throws ZarzadzanieKontamiWyjatek {
		try {
			return zarzadzaniekontami.zwrocDaneAdresu(nrPesel);
		} catch (Exception e) {
			throw new ZarzadzanieKontamiWyjatek(e.getMessage());
		}
	}

	public KontoTO zwrocDaneKonta(String nrPesel)
			throws ZarzadzanieKontamiWyjatek {
		try {
			return zarzadzaniekontami.zwrocDaneKonta(nrPesel);
		} catch (Exception e) {
			throw new ZarzadzanieKontamiWyjatek(e.getMessage());
		}
	}

	public KontoTOZbior pobierzWszystkieKonta() {
		return zarzadzaniekontami.zwrocListeWszystkichKont();
	}

	public void uaktualnijDaneKonta(KontoTO konto) {
		zarzadzaniekontami.modyfikujDaneKonta(konto);

	}

	public void uaktualnijDaneKlienta(KlientTO klient) {
		zarzadzaniekontami.modyfikujDaneKlienta(klient);

	}

	public void uaktualnijDaneAdresu(AdresTO adres) {
		zarzadzaniekontami.modyfikujDaneAdresu(adres);

	}

	public void dodajPracownika(String imie, String nazwisko,
			String login, String haslo, boolean administrator) {
		zarzadzaniekontami.dodajPracownika(imie, nazwisko, login, haslo,
				administrator);

	}

	public KontoPracownikaTO loguj(String login, String haslo)
			throws ZarzadzanieKontamiWyjatek {
		try {
			return zarzadzaniekontami.zaloguj(login, haslo);
		} catch (LogowanieWyjatek e) {
			throw new ZarzadzanieKontamiWyjatek(e.getMessage());
		}
	}
	
	public KontoPracownikaTO wyloguj(String login) {
		try {
			return zarzadzaniekontami.wyloguj(login);
		} catch (LogowanieWyjatek e) {
			// ciche
		}
		return null;
	}
	
	
	public KontoPracownikaTO zwrocDanePracownika(String login) {
		return zarzadzaniekontami.zwrocDanePracownika(login);
	}
}
