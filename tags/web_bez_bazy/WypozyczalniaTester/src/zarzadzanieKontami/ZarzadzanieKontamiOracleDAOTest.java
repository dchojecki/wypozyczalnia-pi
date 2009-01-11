package zarzadzanieKontami;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PracownikDAO;
import wypozyczalnia.dao.fabryki.FactoryType;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiGlownaFabrykaDanych;

/**
 * 
 * @author marcin
 */
public class ZarzadzanieKontamiOracleDAOTest {

	public ZarzadzanieKontamiOracleDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	private ZarzadzanieKontamiDAO instance;

	@Before
	public void setUp() {
		ZarzadzanieKontamiFabrykaDanych fabrykaDAO = new ZarzadzanieKontamiGlownaFabrykaDanych();
		fabrykaDAO.setFactoryType(FactoryType.OracleDAO);
		instance = fabrykaDAO.pobierzWypozyczalniaDAO();		
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testDodajPracownika() {
		PracownikDAO pracownik1 = new PracownikDAO(false, "tomasz",
				"stadnicki", "tstadnicki", "1234");
		PracownikDAO pracownik2 = new PracownikDAO(false, "jacek", "nowak",
				"jnowak", "1234");
		PracownikDAO pracownik3 = new PracownikDAO(false, "lukasz", "prasol",
				"lprasol", "1234");
		PracownikDAO pracownik4 = new PracownikDAO(true, "marcin", "kowalski",
				"mkowalski", "1234");
		
		instance.scalDanePracownika(pracownik1);
		instance.scalDanePracownika(pracownik2);
		instance.scalDanePracownika(pracownik3);
		instance.scalDanePracownika(pracownik4);

		PracownikDAO p1 = instance.zwrocDanePracownika("tstadnicki");
		PracownikDAO p2 = instance.zwrocDanePracownika("jnowak");
		PracownikDAO p3 = instance.zwrocDanePracownika("lprasol");
		PracownikDAO p4 = instance.zwrocDanePracownika("mkowalski");
		PracownikDAO p5 = instance.zwrocDanePracownika("mkowalski11");

		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertNotNull(p4);
		assertNull(p5);

		assertEquals(pracownik1.getNazwisko(), p1.getNazwisko());
		assertEquals(pracownik1.getImie(), p1.getImie());
		assertEquals(pracownik1.getKonto().getLogin(), p1.getKonto().getLogin());
		
		instance.usunDanePracownika(pracownik1);
		instance.usunDanePracownika(pracownik2);
		instance.usunDanePracownika(pracownik3);
		instance.usunDanePracownika(pracownik4);
		
	}

	@Test
	public void testDodajKontoKlienta() {
		final String imie1 = "kubus";
		final String nazwisko1 = "puchatek";
		final String mail1 = "kubus@las.com";
		KlientDAO k1 = instance.utworzNoweKonto();
		AdresDAO adres1 = new AdresDAO();
		k1.setAdres(adres1);
		k1.setNrpesel("11");
		k1.setImie(imie1);
		k1.setNazwisko(nazwisko1);
		k1.setAdresMailowy(mail1);

		final String imie2 = "kubus2";
		final String nazwisko2 = "puchatek2";
		final String mail2 = "kubus@las.com.pl";
		KlientDAO k2 = instance.utworzNoweKonto();
		AdresDAO adres2 = new AdresDAO();
		k2.setAdres(adres2);
		k2.setImie(imie2);
		k2.setNrpesel("22");
		k2.setNazwisko(nazwisko2);
		k2.setAdresMailowy(mail2);

		k1 = instance.scalDaneKlienta(k1);
		k2 = instance.scalDaneKlienta(k2);

		Collection<KlientDAO> klienci = instance.zwrocListeWszystkichKlientow();
		assertTrue(klienci.size() == 2);

		KlientDAO k3 = instance.zwrocDaneKlienta("11");
		KlientDAO k4 = instance.zwrocDaneKlienta("33");

		assertNull(k4);
		assertEquals(k3.getImie(), imie1);

		instance.usunKonto(k2);
		klienci = instance.zwrocListeWszystkichKlientow();
		assertTrue(klienci.size() == 1);
		assertTrue(klienci.iterator().next().getNrpesel().equals("11"));

		instance.usunKonto(k1);
		klienci = instance.zwrocListeWszystkichKlientow();
		assertTrue(klienci.size() == 0);

		/*EntityManager em = instance.getEm();
		instance.setEm(em);
		assertSame(instance.getEm(), em);*/
	}

}