/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieWypozyczeniamiTest {

    public ZarzadzanieWypozyczeniamiTest() {
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
     * Test of pobierzZamowieniaWgCzasu method, of class ZarzadzanieWypozyczeniami.
     */
    @Test
    public void pobierzZamowieniaWgCzasu() {
        System.out.println("pobierzZamowieniaWgCzasu");
        Date odd = null;
        Date doo = null;
        ZarzadzanieWypozyczeniami instance = new ZarzadzanieWypozyczeniamiBean();
        Collection<ZamowienieTO> expResult = null;
        Collection<ZamowienieTO> result = instance.pobierzZamowieniaWgCzasu(odd, doo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
@Test
    public void pobierzZamowieniaWgCzasu1() {
        System.out.println("pobierzZamowieniaWgCzasu");
        Date odd = null;
        Date doo = null;
        ZarzadzanieWypozyczeniami instance = new ZarzadzanieWypozyczeniamiBean();
        Collection<ZamowienieTO> expResult = null;
        Collection<ZamowienieTO> result = instance.pobierzZamowieniaWgCzasu(odd, doo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    

    /**
     * Test of pobierzWszystkieZamowienia method, of class ZarzadzanieWypozyczeniami.
     */
    @Test
    public void pobierzWszystkieZamowienia1() {
        System.out.println("pobierzWszystkieZamowienia");
        ZarzadzanieWypozyczeniami instance = new ZarzadzanieWypozyczeniamiBean();
        Collection<ZamowienieTO> expResult = null;
        Collection<ZamowienieTO> result = instance.pobierzWszystkieZamowienia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void pobierzWszystkieZamowienia() {
        System.out.println("pobierzWszystkieZamowienia");
        ZarzadzanieWypozyczeniami instance = new ZarzadzanieWypozyczeniamiBean();
        Collection<ZamowienieTO> expResult = null;
        Collection<ZamowienieTO> result = instance.pobierzWszystkieZamowienia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}