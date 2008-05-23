package to;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.TransferObjectFactory;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

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
        KlientDAO klient = null;
        AdresTO expResult = null;
        AdresTO result = TransferObjectFactory.stworzAdresTO(klient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stworzKlientTO method, of class TransferObjectFactory.
     */
    @Test
    public void testStworzKlientTO() {
        System.out.println("stworzKlientTO");
        AdresDAO adres = null;
        AdresTO expResult = null;        
    }

    /**
     * Test of stworzZamowienieTO method, of class TransferObjectFactory.
     */
    @Test
    public void testStworzZamowienieTO() {
        System.out.println("stworzZamowienieTO");
        ZamowienieDAO zam = null;
        ZamowienieTO expResult = null;
        ZamowienieTO result = TransferObjectFactory.stworzZamowienieTO(zam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stworzPozycjeZamowienia method, of class TransferObjectFactory.
     */
    @Test
    public void testStworzPozycjeZamowienia() {
        System.out.println("stworzPozycjeZamowienia");
        PozycjaZamowieniaDAO pzD = null;
        PozycjaZamowieniaTO expResult = null;
        PozycjaZamowieniaTO result = TransferObjectFactory.stworzPozycjeZamowienia(pzD);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}