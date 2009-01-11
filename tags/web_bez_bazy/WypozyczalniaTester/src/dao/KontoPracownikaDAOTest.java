package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import wypozyczalnia.dao.PracownikDAO;
import wypozyczalnia.dao.kontopracownika.KontoPracownikaDAO;
import wypozyczalnia.dao.kontopracownika.NieobsluzoneZdarzenie;
import wypozyczalnia.dao.kontopracownika.StanAktywne;
import wypozyczalnia.dao.kontopracownika.StanNieaktywne;
import wypozyczalnia.dao.kontopracownika.StanZablokowane;

public class KontoPracownikaDAOTest {

	
	@Test
	public void genericTest() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		PracownikDAO pracownikDAO = new PracownikDAO();
		konto.setPracownik(pracownikDAO);
		
		assertSame(konto.getPracownik(), pracownikDAO);
		konto.setLogin("misiek");
		assertEquals(konto.getLogin(), "misiek");
		
		Date date = new Date();
		konto.setCzasLogowania(date);
		assertSame(konto.getCzasLogowania(), date);
		
		String haslo = "supertajneHaslo";
		konto.setHaslo(haslo);
		assertEquals(konto.getHaslo(), haslo);
		
		KontoPracownikaDAO k = new KontoPracownikaDAO("a", haslo, date, pracownikDAO);
		assertEquals(k.getLogin(), "a");
		assertEquals(k.getHaslo(), haslo);
		assertSame(k.getCzasLogowania(), date);
		
		
	}
	@Test
	public void testLoguj_ok() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		konto.setHaslo("bbb");
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		konto.loguj("bbb");
		assertTrue(konto.getStan().getClass().equals(StanAktywne.class));
	}

	@Test
	public void testLoguj_zleHasloNieAdmin() {
		PracownikDAO pracownik = new PracownikDAO();
		KontoPracownikaDAO konto = pracownik.getKonto();
		konto.setHaslo("bbb");
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));

		konto.loguj("aaa");
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		assertEquals(konto.getLicznikNieudanychProb(), 1);

		konto.loguj("ccc");
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		assertEquals(konto.getLicznikNieudanychProb(), 2);

		konto.loguj("ddd");
		assertTrue(konto.getStan().getClass().equals(StanZablokowane.class));
		assertEquals(konto.getLicznikNieudanychProb(), 3);
	}

	@Test
	public void testWyloguj() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		konto.setHaslo("aaa");

		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		konto.loguj("aaa");

		assertTrue(konto.getStan().getClass().equals(StanAktywne.class));

		konto.wyloguj();
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
	}

	@Test
	public void testZablokuj() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		konto.zablokuj();
		assertTrue(konto.getStan().getClass().equals(StanZablokowane.class));
	}

	@Test
	public void testOdblokuj() {
		PracownikDAO pracownik = new PracownikDAO();
		KontoPracownikaDAO konto = pracownik.getKonto();
		konto.setHaslo("bbb");
		konto.loguj("aaa");
		konto.loguj("ccc");
		konto.loguj("ddd");

		assertTrue(konto.getStan().getClass().equals(StanZablokowane.class));
		assertEquals(konto.getLicznikNieudanychProb(), 3);

		konto.odblokuj();
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		assertEquals(konto.getLicznikNieudanychProb(), 0);
	}

	@Test(expected = NieobsluzoneZdarzenie.class)
	public void testBlednePrzejscia1_stanNiekatywne() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		assertTrue(konto.getStan().getClass().equals(StanNieaktywne.class));
		konto.wyloguj();
	}

	@Test(expected = NieobsluzoneZdarzenie.class)
	public void testBlednePrzejscia2_stanNiekatywne() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		konto.odblokuj();
	}

	@Test(expected = NieobsluzoneZdarzenie.class)
	public void testBlednePrzejscia1_stanZablokowane() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		konto.zablokuj();
		konto.wyloguj();
	}

	@Test
	public void testBlednePrzejscia2_stanZablokowane() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		konto.zablokuj();
		konto.loguj("");
	}

	@Test(expected = NieobsluzoneZdarzenie.class)
	public void testBlednePrzejscia3_stanZablokowane() {
		KontoPracownikaDAO konto = new KontoPracownikaDAO();
		konto.zablokuj();
		konto.zablokuj();
	}

}
