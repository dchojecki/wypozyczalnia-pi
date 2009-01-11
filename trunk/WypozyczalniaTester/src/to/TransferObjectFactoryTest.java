package to;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.TransferObjectFactory;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTOZbior;

/**
 * 
 * @author marcin
 */
public class TransferObjectFactoryTest {

	public TransferObjectFactoryTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of stworzAdresTO method, of class TransferObjectFactory.
	 */
	@Test
	public void testStworzAdresTO() {
		System.out.println("stworzAdresTO");
		KlientDAO klient = new KlientDAO();
		AdresDAO adres = new AdresDAO();
		klient.setAdres(adres);
		adres.setMiasto("wroclaw");
		adres.setNrDomu(1);
		adres.setNrMieszkania(2);
		adres.setUlica("pilczycka");

		AdresTO result = TransferObjectFactory.stworzAdresTO(klient);

		assertEquals(result.getMiast(), adres.getMiasto());
		assertEquals(result.getNrDomu(), 1);
		assertEquals(result.getNrMieszkania(), 2);
		assertEquals(result.getUlica(), "pilczycka");
	}

	/**
	 * Test of stworzKlientTO method, of class TransferObjectFactory.
	 */
	@Test
	public void testStworzKlientTO() {
		System.out.println("stworzKlientTO");
		KlientDAO klient = new KlientDAO();
		KontoDAO konto = new KontoDAO();
		konto.setNrKonta(1);
		klient.getKonta().add(konto);
		klient.setImie("marcin");
		klient.setNazwisko("kowalski");
		klient.setDataUrodzenia(new Date());
		klient.setNrpesel("85110916799");
		klient.setAdresMailowy("scinek@gmail.com");

		KlientTO k = TransferObjectFactory.stworzKlientTO(klient);

		assertEquals(k.getImie(), klient.getImie());
		assertEquals(k.getNazwisko(), klient.getNazwisko());
		assertEquals(k.getAdresMailowy(), klient.getAdresMailowy());
		assertEquals(k.getNrPeselKlienta(), klient.getNrpesel());
		assertEquals(k.getNrKonta(), konto.getNrKonta());
	}

	/**
	 * Test of stworzZamowienieTO method, of class TransferObjectFactory.
	 */
	@Test
	public void testStworzZamowienieTO() {
		KlientDAO klient = new KlientDAO();
		KontoDAO konto = new KontoDAO();

		konto.setKlient(klient);
		PlytaDAO pp1 = new PlytaDAO();
		pp1.setId("1");
		// pp1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
		FilmDAO f1 = new FilmDAO();
		f1.setTytul("aaa");
		f1.setId(1);
		pp1.setFilm(f1);

		PlytaDAO pp2 = new PlytaDAO();
		pp2.setId("1");
		// pp1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
		FilmDAO f2 = new FilmDAO();
		f2.setId(2);
		f2.setTytul("aaa");
		pp2.setFilm(f2);

		konto.setNrKonta(1);
		klient.getKonta().add(konto);
		klient.setImie("marcin");
		klient.setNazwisko("kowalski");
		klient.setDataUrodzenia(new Date());
		klient.setNrpesel("85110916799");
		klient.setAdresMailowy("scinek@gmail.com");

		ZamowienieDAO zam = new ZamowienieDAO();
		zam.setKonto(konto);
		zam.setId(1);
		zam.setStanzamowienia(StanZamowienia.ANULOWANE);
		PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
		p1.setCenaJednostkowa(12);
		p1.setPlyta(pp1);
		p1.setZamowienie(zam);
		PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();
		p2.setCenaJednostkowa(12);
		p2.setPlyta(pp2);
		p2.setZamowienie(zam);

		zam.getPozycje().add(p1);
		zam.getPozycje().add(p2);

		ZamowienieTO result = TransferObjectFactory.stworzZamowienieTO(zam);

		assertEquals(result.getId(), zam.getId());
		assertEquals(result.getKonto().getNrKonta(), 1);
		assertEquals(result.getPozycjezamowienia().size(), 2);

	}

	@Test
	public void kopiujKolekcjeFilmow() {
		LinkedList<FilmDAO> filmy = new LinkedList<FilmDAO>();
		PlytaDAO pp1 = new PlytaDAO();
		pp1.setId("1");
		// pp1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
		FilmDAO f1 = new FilmDAO();
		f1.setTytul("aaa");
		f1.setId(1);
		pp1.setFilm(f1);

		PlytaDAO pp2 = new PlytaDAO();
		pp2.setId("1");
		// pp1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
		FilmDAO f2 = new FilmDAO();
		f2.setId(2);
		f2.setTytul("aaa");
		pp2.setFilm(f2);
		filmy.add(f1);
		filmy.add(f2);
		FilmTOZbior zbior = TransferObjectFactory.stworzFilmyTO(filmy);
		assertEquals(zbior.zwrocWszystkieFilmy().size(), 2);
	}

	@Test
	public void kopiujKolekcjePlyt() {
		LinkedList<PlytaDAO> plyty = new LinkedList<PlytaDAO>();
		PlytaDAO pp1 = new PlytaDAO();
		pp1.setId("1");
		// pp1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
		FilmDAO f1 = new FilmDAO();
		f1.setTytul("aaa");
		f1.setId(1);
		pp1.setFilm(f1);

		PlytaDAO pp2 = new PlytaDAO();
		pp2.setId("1");
		// pp1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
		FilmDAO f2 = new FilmDAO();
		f2.setId(2);
		f2.setTytul("aaa");
		pp2.setFilm(f2);
		plyty.add(pp1);
		plyty.add(pp2);
		PlytaTOZbior zbior = TransferObjectFactory.stworzPlytyTO(plyty);
		assertEquals(zbior.zwrocWszystkiePlyty().size(), 2);
	}

}