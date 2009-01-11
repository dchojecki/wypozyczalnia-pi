/**
 * 
 */
package wypozyczalnia.ejb.zarzadzaniekontami;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import javax.ejb.Stateless;

import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PracownikDAO;
import wypozyczalnia.dao.StanKonta;
import wypozyczalnia.dao.fabryki.TransferObjectFactory;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiGlownaFabrykaDanych;
import wypozyczalnia.dao.kontopracownika.NieobsluzoneZdarzenie;
import wypozyczalnia.dao.kontopracownika.StanKontaPracownika;
import wypozyczalnia.dao.kontopracownika.StanNieaktywne;
import wypozyczalnia.dao.kontopracownika.StanZablokowane;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTOZbior;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless(mappedName = "ZarzadzanieKontamiBean")
public class ZarzadzanieKontamiBean implements ZarzadzanieKontami,
		ZarzadzanieKontamiLocal {

	private ZarzadzanieKontamiFabrykaDanych fabrykaDAO = new ZarzadzanieKontamiGlownaFabrykaDanych();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#modyfikujDaneAdresu(AdresTO adres)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void modyfikujDaneAdresu(AdresTO adres) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO k = dao.zwrocDaneKlienta(adres.getNrPeselKlienta());
		if (k == null)
			return;
		AdresDAO a = k.getAdres();

		a.setMiasto(adres.getMiast());
		a.setNrDomu(adres.getNrDomu());
		a.setNrMieszkania(adres.getNrMieszkania());
		a.setUlica(adres.getUlica());

		dao.scalDaneKlienta(k);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#modyfikujDaneKlienta(KlientTO klient)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void modyfikujDaneKlienta(KlientTO klient) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO k = dao.zwrocDaneKlienta(klient.getNrPeselKlienta());

		k.setAdresMailowy(klient.getAdresMailowy());
		k.setDataUrodzenia(klient.getDataUrodzenia());
		k.setImie(klient.getImie());
		k.setNazwisko(klient.getNazwisko());

		dao.scalDaneKlienta(k);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#modyfikujDaneKonta(KontoTO konto)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void modyfikujDaneKonta(KontoTO konto) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO k = dao.zwrocDaneKlienta(konto.getNrPeselKlienta());
		KontoDAO kk = k.zwrocPierwszeKonto();

		kk.setStankonta(konto.getStanKonta());
		dao.scalDaneKlienta(k);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#zwrocDaneAdresu(String nrPesel)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public AdresTO zwrocDaneAdresu(String nrPesel) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO klient = dao.zwrocDaneKlienta(nrPesel);
		return TransferObjectFactory.stworzAdresTO(klient);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#zwrocDaneKonta(Integer nrKonta)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public KontoTO zwrocDaneKonta(String nrpesel) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO klient = dao.zwrocDaneKlienta(nrpesel);
		return TransferObjectFactory.stworzKontoTO(klient);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#zwrocDaneKlienta(String nrpesel)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public KlientTO zwrocDaneKlienta(String nrpesel) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO klient = dao.zwrocDaneKlienta(nrpesel);
		return TransferObjectFactory.stworzKlientTO(klient);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#zablokujKonto(Integer nrKonta)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void zablokujKonto(KlientTO klient) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO k = dao.zwrocDaneKlienta(klient.getNrPeselKlienta());
		KontoDAO konto = k.zwrocPierwszeKonto();

		StanKonta stan = konto.getStankonta();

		if (stan == StanKonta.AKTYWNE || stan == StanKonta.WYGASLO_HASLO) {
			// nic
		} else {
			konto.setStankonta(StanKonta.ZABLOKOWANE);
			dao.scalDaneKlienta(k);
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#odblokujKonto(Integer nrKonta)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void odblokujKonto(KlientTO klient) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#zmienHaslo(String nowySkrotHasla, Integer
	 *      nrKonta, String starySkrotHasla)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void zmienHaslo(String nowySkrotHasla, Integer nrKonta,
			String starySkrotHasla) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	final String msg1 = "Nieprawid³owy login lub has³o";
	final String msg2 = "B³¹d logowania";
	final String msg3 = "Skontaktuj siê z administratorem";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @throws LogowanieWyjatek
	 * 
	 * @see ZarzadzanieKontami#zaloguj(String skrotHasla, Integer nrKonta)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public KontoPracownikaTO zaloguj(String login, String haslo)
			throws LogowanieWyjatek {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		PracownikDAO pracownik = dao.zwrocDanePracownika(login);

		if (pracownik == null) // login
			throw new LogowanieWyjatek(msg1);

		try {
			pracownik.getKonto().loguj(haslo);
			dao.scalDanePracownika(pracownik);
		} catch (NieobsluzoneZdarzenie e) {
			if (pracownik.czyJestAdministratorem()) {
				throw new LogowanieWyjatek(msg2, TransferObjectFactory
						.stworzStanKontaPracownika(pracownik.getKonto()
								.getStan()));
			} else
				throw new LogowanieWyjatek(msg3, TransferObjectFactory
						.stworzStanKontaPracownika(pracownik.getKonto()
								.getStan()));
		}

		StanKontaPracownika stan = pracownik.getKonto().getStan();

		if (stan.getClass().equals(StanNieaktywne.class)) // haslo
			throw new LogowanieWyjatek(msg1, KontoPracownikaTO.Stan.nieaktywne);

		if (stan.getClass().equals(StanZablokowane.class))
			throw new LogowanieWyjatek(msg3, KontoPracownikaTO.Stan.zablokowane);

		return TransferObjectFactory.stworzKontoPracownikaTO(pracownik
				.getKonto());

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#czyKlientZarejestrowany(Integer nrPesel)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public boolean czyKlientZarejestrowany(String nrPesel) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO k = dao.zwrocDaneKlienta(nrPesel);
		if (k == null) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> (non-Javadoc)
	 * 
	 * @see ZarzadzanieKontami#zarejestrujKlienta(String nrPesel)
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public KontoTO zarejestrujKlienta(KlientTO klient, AdresTO adres) {

		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO nowyKlient = dao.utworzNoweKonto();

		nowyKlient.setImie(klient.getImie());
		nowyKlient.setNazwisko(klient.getNazwisko());
		nowyKlient.setAdresMailowy(klient.getAdresMailowy());
		nowyKlient.setDataUrodzenia(klient.getDataUrodzenia());
		nowyKlient.setNrpesel(klient.getNrPeselKlienta());

		KontoDAO konto = nowyKlient.zwrocPierwszeKonto();
		konto.setDataOstatniejZmianyHasla(new Date());
		konto.setDataUstatniegoLogowania(new Date());
		konto.setStankonta(StanKonta.NIEAKTYWNE);

		AdresDAO nowyAdres = nowyKlient.getAdres();
		nowyAdres.setMiasto(adres.getMiast());
		nowyAdres.setNrDomu(adres.getNrDomu());
		nowyAdres.setNrMieszkania(adres.getNrMieszkania());
		nowyAdres.setUlica(adres.getUlica());

		nowyKlient = dao.scalDaneKlienta(nowyKlient);

		KontoTO retKonto = TransferObjectFactory.stworzKontoTO(nowyKlient);
		return retKonto;

	}

	public void usunWszystkieKonta() {
		try {
			ZarzadzanieKontamiDAO dao = getFabrykaDAO()
					.pobierzWypozyczalniaDAO();
			Collection<KlientDAO> klienci = dao.zwrocListeWszystkichKlientow();

			for (KlientDAO k : klienci) {
				dao.usunKonto(k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public KontoTOZbior zwrocListeWszystkichKont() {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		Collection<KlientDAO> klienci = dao.zwrocListeWszystkichKlientow();
		Collection<KontoTO> ret = new LinkedList<KontoTO>();

		for (KlientDAO k : klienci) {
			ret.add(TransferObjectFactory.stworzKontoTO(k));
		}

		return new KontoTOZbior(ret);

	}

	public void usunKonto(KontoTO konto) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		KlientDAO klient = dao.zwrocDaneKlienta(konto.getNrPeselKlienta());
		dao.usunKonto(klient);
	}

	public void dodajPracownika(String imie, String nazwisko, String login,
			String haslo, boolean administrator) {
		PracownikDAO pracownik = new PracownikDAO(administrator, imie,
				nazwisko, login, haslo);
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		dao.scalDanePracownika(pracownik);
	}

	public ZarzadzanieKontamiFabrykaDanych getFabrykaDAO() {
		return fabrykaDAO;
	}

	public KontoPracownikaTO wyloguj(String login) throws LogowanieWyjatek {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		PracownikDAO pracownik = dao.zwrocDanePracownika(login);

		if (pracownik == null)
			throw new LogowanieWyjatek("Niepoprawny login");
		try {
			pracownik.getKonto().wyloguj();
		} catch (NieobsluzoneZdarzenie e) {
			throw new LogowanieWyjatek(pracownik.getKonto().toString());
		}

		return TransferObjectFactory.stworzKontoPracownikaTO(pracownik
				.getKonto());

	}

	@Override
	public KontoPracownikaTO zwrocDanePracownika(String login) {
		ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
		PracownikDAO pracownik = dao.zwrocDanePracownika(login);

		if (pracownik == null)
			return null;
		return TransferObjectFactory.stworzKontoPracownikaTO(pracownik
				.getKonto());
	}

}
