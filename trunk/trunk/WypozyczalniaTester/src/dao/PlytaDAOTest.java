/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.StanPlyty;
import static org.junit.Assert.*;
import static wypozyczalnia.dao.StanPlyty.*;

/**
 *
 * @author marcin
 */
public class PlytaDAOTest {

    private static PlytaDAO plyta;
    private static FilmDAO film;

    public PlytaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        plyta = new PlytaDAO();
        plyta.gotowa();
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
     * Test of getFilm method, of class PlytaDAO.
     */
    @Test
    public void testGetFilm() {
        plyta.setFilm(null);
        assertNull(plyta.getFilm());
    }

    /**
     * Test of setFilm method, of class PlytaDAO.
     */
    @Test
    public void testSetFilm() {
        plyta.setFilm(film);
        assertEquals(plyta.getFilm(), film);
    }

    /**
     * Test of getUwagiDoEgzemplarza method, of class PlytaDAO.
     */
    @Test
    public void testGetUwagiDoEgzemplarza() {
        plyta.setUwagiDoEgzemplarza("uwagi");
        assertEquals(plyta.getUwagiDoEgzemplarza(), "uwagi");
    }

    /**
     * Test of setUwagiDoEgzemplarza method, of class PlytaDAO.
     */
    @Test
    public void testSetUwagiDoEgzemplarza() {
        plyta.setUwagiDoEgzemplarza(null);
        assertNull(plyta.getUwagiDoEgzemplarza());
    }

    /**
     * Test of getDataNabycia method, of class PlytaDAO.
     */
    @Test
    public void testGetDataNabycia() {
        Date przed = new Date();
        plyta.setStanplyty(StanPlyty.WDRODZE);
        plyta.gotowa();
        Date po = new Date();
        Date kiedy = plyta.getDataNabycia();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());
    }

    /**
     * Test of getStanplyty method, of class PlytaDAO.
     */
    @Test
    public void testGetStanplyty() {
        System.out.println("getStanzamowienia");
        plyta.setStanplyty(StanPlyty.WDRODZE);
        assertEquals(plyta.getStanplyty(), StanPlyty.WDRODZE);
        plyta.setStanplyty(StanPlyty.WYPOZYCZONA);
        assertEquals(plyta.getStanplyty(), StanPlyty.WYPOZYCZONA);
        plyta.setStanplyty(StanPlyty.ZAREZERWOWANA);
        assertEquals(plyta.getStanplyty(), StanPlyty.ZAREZERWOWANA);
        plyta.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
        assertEquals(plyta.getStanplyty(), StanPlyty.NIEWYPOZYCZONA);
    }

    /**
     * Test of setStanplyty method, of class PlytaDAO.
     */
    @Test
    public void testSetStanplyty() {
        System.out.println("getStanzamowienia");
        plyta.setStanplyty(StanPlyty.WDRODZE);
        assertEquals(plyta.getStanplyty(), StanPlyty.WDRODZE);
        plyta.setStanplyty(StanPlyty.WYPOZYCZONA);
        assertEquals(plyta.getStanplyty(), StanPlyty.WYPOZYCZONA);
        plyta.setStanplyty(StanPlyty.ZAREZERWOWANA);
        assertEquals(plyta.getStanplyty(), StanPlyty.ZAREZERWOWANA);
        plyta.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
        assertEquals(plyta.getStanplyty(), StanPlyty.NIEWYPOZYCZONA);
    }

    /**
     * Test of getId method, of class PlytaDAO.
     */
    @Test
    public void testGetId() {
        Integer id = plyta.getId();
        plyta.setId(2);
        assertEquals(plyta.getId(), 2);
        plyta.setId(id);
    }

    /**
     * Test of setId method, of class PlytaDAO.
     */
    @Test
    public void testSetId() {
        Integer id = plyta.getId();
        plyta.setId(null);
        plyta.setId(id);

        assertEquals(plyta.getId(), id);
    }

    /**
     * Test of gotowa method, of class PlytaDAO.
     */
    @Test
    public void testGotowa() {
        plyta.setStanplyty(StanPlyty.WDRODZE);
        assertEquals(plyta.getStanplyty(), StanPlyty.WDRODZE);
        plyta.gotowa();
        assertEquals(plyta.getStanplyty(), StanPlyty.NIEWYPOZYCZONA);

    }

    /**
     * Test of rezerwuj method, of class PlytaDAO.
     */
    @Test
    public void testRezerwuj() {
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
        plyta.rezerwuj();
        assertEquals(plyta.getStanplyty(), ZAREZERWOWANA);
        plyta.anulujRezerwacje();
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
    }

    /**
     * Test of wypozycz method, of class PlytaDAO.
     */
    @Test
    public void testWypozycz() {
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
        plyta.rezerwuj();
        assertEquals(plyta.getStanplyty(), ZAREZERWOWANA);
        plyta.wypozycz();
        assertEquals(plyta.getStanplyty(), WYPOZYCZONA);
        plyta.zwroc();
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
    }

    /**
     * Test of zwroc method, of class PlytaDAO.
     */
    @Test
    public void testZwroc() {
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
        plyta.rezerwuj();
        assertEquals(plyta.getStanplyty(), ZAREZERWOWANA);
        plyta.wypozycz();
        assertEquals(plyta.getStanplyty(), WYPOZYCZONA);
        plyta.zwroc();
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
    }

    /**
     * Test of anulujRezerwacje method, of class PlytaDAO.
     */
    @Test
    public void testAnulujRezerwacje() {
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
        plyta.rezerwuj();
        assertEquals(plyta.getStanplyty(), ZAREZERWOWANA);
        plyta.anulujRezerwacje();
        assertEquals(plyta.getStanplyty(), NIEWYPOZYCZONA);
    }
    
      public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(PlytaDAOTest.class);
    }
}