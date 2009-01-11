/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.StanZamowienia;
import static org.junit.Assert.*;
import static wypozyczalnia.dao.StanZamowienia.*;

/**
 *
 * @author marcin
 */
public class ZamowienieDAOTest {

    private static ZamowienieDAO zamowienie = new ZamowienieDAO();
    private static KlientDAO klient = new KlientDAO();
    private static PlytaDAO plyta1 = new PlytaDAO();
    private static PlytaDAO plyta2 = new PlytaDAO();
    private static PlytaDAO plyta3 = new PlytaDAO();
    private static PozycjaZamowieniaDAO pozycja1 = new PozycjaZamowieniaDAO();
    private static PozycjaZamowieniaDAO pozycja2 = new PozycjaZamowieniaDAO();
    private static PozycjaZamowieniaDAO pozycja3 = new PozycjaZamowieniaDAO();

    public ZamowienieDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        plyta1.gotowa();
        plyta2.gotowa();
        plyta3.gotowa();

        zamowienie.getPozycje().add(pozycja1);
        pozycja1.setCenaJednostkowa(10);
        pozycja1.setId(1);
        pozycja1.setPlyta(plyta1);

        pozycja2.setCenaJednostkowa(20);
        pozycja2.setId(2);
        pozycja2.setPlyta(plyta2);
        zamowienie.getPozycje().add(pozycja2);

        pozycja3.setCenaJednostkowa(20);
        pozycja3.setId(3);
        pozycja3.setPlyta(plyta3);
        zamowienie.getPozycje().add(pozycja3);
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
     * Test of getPozycje method, of class ZamowienieDAO.
     */
    @Test
    public void testGetPozycje() {
        System.out.println("getPozycje");
        Set<PozycjaZamowieniaDAO> expResult = new HashSet<PozycjaZamowieniaDAO>();
        expResult.add(pozycja1);
        expResult.add(pozycja2);
        expResult.add(pozycja3);
        Set<PozycjaZamowieniaDAO> result = zamowienie.getPozycje();

        assertEquals(result.size(), 3);
        assertTrue(result.containsAll(expResult) && expResult.containsAll(result));
    }

    /**
     * Test of setPozycje method, of class ZamowienieDAO.
     */
    @Test
    public void testSetPozycje() {
        System.out.println("setPozycje");
        Set<PozycjaZamowieniaDAO> s = new HashSet<PozycjaZamowieniaDAO>();
        s.add(pozycja1);
        s.add(pozycja2);
        s.add(pozycja3);
        zamowienie.setPozycje(s);
        assertEquals(zamowienie.getPozycje(), s);
    }

    /**
     * Test of getDataPrzyjecia method, of class ZamowienieDAO.
     */
    @Test
    public void testGetDataPrzyjecia() {
        Date przed = new Date();
        zamowienie.setStanzamowienia(PRZYJETE);
        Date po = new Date();
        Date kiedy = zamowienie.getDataPrzyjecia();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());

    }

    @Test
    public void testGetDataRealizacji() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        zamowienie.odebrane();
        Date przed = new Date();
        zamowienie.oddane();
        Date po = new Date();
        Date kiedy = zamowienie.getDataRealizacji();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());
    }

    @Test
    public void testGetDataDoOdbioru() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        Date przed = new Date();
        zamowienie.gotowe();
        Date po = new Date();
        zamowienie.anuluj();
        Date kiedy = zamowienie.getDataDoOdbioru();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());
    }

    /**
     * Test of getId method, of class ZamowienieDAO.
     */
    @Test
    public void testGetId() {
        Integer id = zamowienie.getId();
        zamowienie.setId(2);
        assertEquals(zamowienie.getId(), 2);
        
        zamowienie.setId(id);
        
    }

    /**
     * Test of getStanzamowienia method, of class ZamowienieDAO.
     */
    @Test
    public void testGetStanzamowienia() {
        System.out.println("getStanzamowienia");
        zamowienie.setStanzamowienia(StanZamowienia.ANULOWANE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ANULOWANE);
        zamowienie.setStanzamowienia(StanZamowienia.DOODIORU);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.DOODIORU);
        zamowienie.setStanzamowienia(StanZamowienia.POZYCZONE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.POZYCZONE);
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.PRZYJETE);
        zamowienie.setStanzamowienia(StanZamowienia.ZALEGLE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZALEGLE);
        zamowienie.setStanzamowienia(StanZamowienia.ZREALIZOWANE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZREALIZOWANE);
    }

    /**
     * Test of setId method, of class ZamowienieDAO.
     */
    @Test
    public void testSetId() {
        Integer id = zamowienie.getId();        
        zamowienie.setId(null);
        zamowienie.setId(id);
        
        assertEquals(zamowienie.getId(), id);
        
        
    }

    /**
     * Test of getDataPozyczenia method, of class ZamowienieDAO.
     */
    @Test
    public void testGetDataPozyczenia() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        Date przed = new Date();
        zamowienie.odebrane();
        Date po = new Date();
        zamowienie.oddane();
        Date kiedy = zamowienie.getDataPozyczenia();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());
    }

    /**
     * Test of getDataPozyczenia method, of class ZamowienieDAO.
     */
    @Test
    public void testGetDataZalegle() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        zamowienie.odebrane();
        Date przed = new Date();
        zamowienie.sprawdzCzyZalegle();
        Date po = new Date();
        zamowienie.uregulowano();
        Date kiedy = zamowienie.getDataZalegle();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());
    }

    /**
     * Test of getDataPozyczenia method, of class ZamowienieDAO.
     */
    @Test
    public void testGetDataAnulowania() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        Date przed = new Date();
        zamowienie.anuluj();
        Date po = new Date();
        Date kiedy = zamowienie.getDataAnulowania();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());


        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        przed = new Date();
        zamowienie.anuluj();
        po = new Date();
        kiedy = zamowienie.getDataAnulowania();

        assertTrue(przed.getTime() <= kiedy.getTime());
        assertTrue(po.getTime() >= kiedy.getTime());
    }

    /**
     * Test of setDataPozyczenia method, of class ZamowienieDAO.
     */
    @Test
    public void testSetDataAnulowania() {
    }

    /**
     * Test of setStanzamowienia method, of class ZamowienieDAO.
     */
    @Test
    public void testSetStanzamowienia() {
        zamowienie.setStanzamowienia(StanZamowienia.ANULOWANE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ANULOWANE);
        zamowienie.setStanzamowienia(StanZamowienia.DOODIORU);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.DOODIORU);
        zamowienie.setStanzamowienia(StanZamowienia.POZYCZONE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.POZYCZONE);
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.PRZYJETE);
        zamowienie.setStanzamowienia(StanZamowienia.ZALEGLE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZALEGLE);
        zamowienie.setStanzamowienia(StanZamowienia.ZREALIZOWANE);
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZREALIZOWANE);
    }

    /**
     * Test of getKlient method, of class ZamowienieDAO.
     */
    @Test
    public void testGetKlient() {
/*        zamowienie.setKlient(klient);
        assertEquals(zamowienie.getKlient(), klient);
*/    }

    /**
     * Test of setKlient method, of class ZamowienieDAO.
     */
    @Test
    public void testSetKlient() {
/*        zamowienie.setKlient(null);
        assertNull(zamowienie.getKlient());
*/
    }

    /**
     * Test of gotowe method, of class ZamowienieDAO.
     */
    @Test
    public void testGotowe() {
        System.out.println("gotowe");
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.DOODIORU);
        zamowienie.anuluj();
    }

    /**
     * Test of odebrane method, of class ZamowienieDAO.
     */
    @Test
    public void testOdebrane() {
        System.out.println("odebrane");
        zamowienie.setStanzamowienia(StanZamowienia.DOODIORU);
        zamowienie.odebrane();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.POZYCZONE);
        zamowienie.oddane();
    }

    /**
     * Test of anuluj method, of class ZamowienieDAO.
     */
    @Test
    public void testAnuluj() {
        System.out.println("anuluj");
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.anuluj();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ANULOWANE);


        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        zamowienie.anuluj();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ANULOWANE);
    }

    /**
     * Test of oddane method, of class ZamowienieDAO.
     */
    @Test
    public void testOddane() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        zamowienie.odebrane();
        zamowienie.oddane();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZREALIZOWANE);
    }

    /**
     * Test of uregulowano method, of class ZamowienieDAO.
     */
    @Test
    public void testUregulowano() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        zamowienie.odebrane();
        zamowienie.setStanzamowienia(StanZamowienia.ZALEGLE);
        zamowienie.uregulowano();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZREALIZOWANE);

    }

    /**
     * Test of sprawdzCzyZalegle method, of class ZamowienieDAO.
     */
    @Test
    public void testSprawdzCzyZalegle() {
        zamowienie.setStanzamowienia(StanZamowienia.PRZYJETE);
        zamowienie.gotowe();
        zamowienie.odebrane();
        zamowienie.sprawdzCzyZalegle();
        assertEquals(zamowienie.getStanzamowienia(), StanZamowienia.ZALEGLE);
        zamowienie.uregulowano();
    }
}