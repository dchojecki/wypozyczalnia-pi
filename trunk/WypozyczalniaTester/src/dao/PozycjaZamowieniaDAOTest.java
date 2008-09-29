/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class PozycjaZamowieniaDAOTest {

    private static ZamowienieDAO zamowienie = new ZamowienieDAO();
    private static PlytaDAO plyta = new PlytaDAO();
    private static PozycjaZamowieniaDAO pozycja = new PozycjaZamowieniaDAO();

    public PozycjaZamowieniaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        pozycja = new PozycjaZamowieniaDAO();
        plyta = new PlytaDAO();
        zamowienie = new ZamowienieDAO();
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
     * Test of getPlyta method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testGetPlyta() {
        pozycja.setPlyta(null);
        assertNull(pozycja.getPlyta());
    }

    /**
     * Test of setPlyta method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testSetPlyta() {
        pozycja.setPlyta(plyta);
        assertEquals(pozycja.getPlyta(), plyta);
    }

    /**
     * Test of getCenaJednostkowa method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testGetCenaJednostkowa() {
        System.out.println("getCenaJednostkowa");
        pozycja.setCenaJednostkowa(12);        
        assertTrue(pozycja.getCenaJednostkowa() > 11.999);
        assertTrue(pozycja.getCenaJednostkowa() < 12.001);
        
    }

    /**
     * Test of setCenaJednostkowa method, of class PozycjaZamowieniaDAO.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetCenaJednostkowa() {
        pozycja.setCenaJednostkowa(-12);
    }

    /**
     * Test of getId method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testGetId() {
        Integer id = pozycja.getId();
        pozycja.setId(2);
        assertEquals(pozycja.getId(), 2);

        pozycja.setId(id);
    }

    /**
     * Test of setId method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testSetId() {
        Integer id = pozycja.getId();
        pozycja.setId(2);
        assertEquals(pozycja.getId(), 2);

        pozycja.setId(id);

    }

    /**
     * Test of getZamowienie method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testGetZamowienie() {
        pozycja.setZamowienie(zamowienie);
        assertEquals(pozycja.getZamowienie(), zamowienie);
    }

    /**
     * Test of setZamowienie method, of class PozycjaZamowieniaDAO.
     */
    @Test
    public void testSetZamowienie() {
        pozycja.setZamowienie(null);
        assertNull(pozycja.getZamowienie());
    }
}