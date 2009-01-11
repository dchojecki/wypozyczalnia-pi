package zarzadzanieKontami;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wypozyczalnia.dao.StanKonta;
import wypozyczalnia.ejb.zarzadzaniekontami.LogowanieWyjatek;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontamiBean;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTOZbior;

/**
 * 
 * @author marcin
 */
public class ZarzadzanieKontamiBeanTest {

	private ZarzadzanieKontami ziarenko = new ZarzadzanieKontamiBean();

	public ZarzadzanieKontamiBeanTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		ziarenko = new ZarzadzanieKontamiBean();
		ziarenko.usunWszystkieKonta();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void zaloguj() {
		ziarenko.dodajPracownika("marcin", "kowalski", "root", "1234", true);
		ziarenko.dodajPracownika("marcin", "kowalski", "mkowalski", "1234",
				false);

		try {
			ziarenko.zaloguj("mkowalskiiiiiii", "12345");
			fail();
		} catch (LogowanieWyjatek e2) {
		}
		try {
			ziarenko.zaloguj("mkowalski", "12345");
			fail();
		} catch (LogowanieWyjatek e2) {
		}

		try {
			KontoPracownikaTO konto = ziarenko.zaloguj("mkowalski", "1234");
			assertEquals(konto.getImie(), "marcin");
			assertEquals(konto.getNazwisko(), "kowalski");
			assertEquals(konto.getStan(), KontoPracownikaTO.Stan.aktywne);
			assertEquals(konto.getLogin(), "mkowalski");
		} catch (LogowanieWyjatek e2) {
			fail();
		}
		
		try {
			ziarenko.zaloguj("root", "1234");
		} catch (LogowanieWyjatek e) {
			fail();
		}

		try {
			ziarenko.zaloguj("root", "1234");
			fail();
		} catch (LogowanieWyjatek e) {
		}

		try {
			ziarenko.wyloguj("root");
		} catch (LogowanieWyjatek e1) {
		}

		try {
			ziarenko.zaloguj("root", "1234");
		} catch (LogowanieWyjatek e) {
			fail();
		}

	}
	
	@Test
	public void testujKonta() {
		KlientTO klient = new KlientTO();
		String nrpesel = "85110916799";
		klient.setNrPeselKlienta(nrpesel);
		klient.setImie("Marcin");
		AdresTO adres = new AdresTO();
		
		KontoTO konto = ziarenko.zarejestrujKlienta(klient, adres);
		assertTrue(ziarenko.czyKlientZarejestrowany(nrpesel));
		assertEquals(konto.getNrPeselKlienta(), nrpesel);
		
		KontoTOZbior zbior = ziarenko.zwrocListeWszystkichKont();
		
		ziarenko.usunKonto(konto);

		
		zbior = ziarenko.zwrocListeWszystkichKont();
		assertEquals(zbior.getKonta().size(), 0);
	}
	
	@Test
	public void testujModyfikacje1() {		
		AdresTO adres = new AdresTO();
		ziarenko.modyfikujDaneAdresu(adres);
	}
	@Test
	public void testujModyfikacje() {
		KlientTO klient = new KlientTO();
		String nrpesel = "85110916799";
		klient.setNrPeselKlienta(nrpesel);
		klient.setImie("Marcin");
		AdresTO adres = new AdresTO();

		KlientTO klient1 = new KlientTO();
		String nrpesel1 = "85110916800";
		klient1.setNrPeselKlienta(nrpesel1);
		klient1.setImie("Marcin");
		AdresTO adres1 = new AdresTO();
		
		KontoTO konto = ziarenko.zarejestrujKlienta(klient, adres);
		KontoTO konto1 = ziarenko.zarejestrujKlienta(klient1, adres1);
		
		adres.setMiast("aaaaa");
		adres.setNrPeselKlienta(konto.getNrPeselKlienta());
		ziarenko.modyfikujDaneAdresu(adres);
		adres = ziarenko.zwrocDaneAdresu(nrpesel);
		assertEquals(adres.getMiast(), "aaaaa");
		
		
		klient = ziarenko.zwrocDaneKlienta(nrpesel);
		assertEquals(klient.getImie(), "Marcin");
		klient.setImie("Tomek");
		ziarenko.modyfikujDaneKlienta(klient);
		klient = ziarenko.zwrocDaneKlienta(nrpesel);
		assertEquals(klient.getImie(), "Tomek");
		
		
		ziarenko.usunWszystkieKonta();
		KontoTOZbior zbior = ziarenko.zwrocListeWszystkichKont();
		assertEquals(zbior.getKonta().size(), 0);
		
		
	
		
	}
	
	
	@Test
	public void testZablokuj() {
		KlientTO klient = new KlientTO();
		String nrpesel = "85110916799";
		klient.setNrPeselKlienta(nrpesel);
		klient.setImie("Marcin");
		AdresTO adres = new AdresTO();
		
		KontoTO konto = ziarenko.zarejestrujKlienta(klient, adres);
		
		konto.setStanKonta(StanKonta.ZABLOKOWANE);
		ziarenko.modyfikujDaneKonta(konto);
		konto = ziarenko.zwrocDaneKonta(nrpesel);
		assertEquals(konto.getStanKonta(), StanKonta.ZABLOKOWANE);
		
		ziarenko.usunWszystkieKonta();
	}
	@Test
	public void testZablokuj2() {
		KlientTO klient = new KlientTO();
		String nrpesel = "85110916799";
		klient.setNrPeselKlienta(nrpesel);
		klient.setImie("Marcin");
		AdresTO adres = new AdresTO();
		
		KontoTO konto = ziarenko.zarejestrujKlienta(klient, adres);
		ziarenko.zablokujKonto(klient);
		konto = ziarenko.zwrocDaneKonta(nrpesel);
		assertEquals(konto.getStanKonta(), StanKonta.ZABLOKOWANE);
		
		ziarenko.usunWszystkieKonta();
	}

}