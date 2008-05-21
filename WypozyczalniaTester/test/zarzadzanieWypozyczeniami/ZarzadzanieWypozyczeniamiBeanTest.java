/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieWypozyczeniami;

import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiBean;
import static org.junit.Assert.*;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieWypozyczeniamiBeanTest {

    public ZarzadzanieWypozyczeniamiBeanTest() {
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
     * Test of pobierzZamowieniaWgCzasu method, of class ZarzadzanieWypozyczeniamiBean.
     */
    @Test
    public void testPobierzZamowieniaWgCzasu() {
        System.out.println("pobierzZamowieniaWgCzasu");
        Date odd = null;
        Date doo = null;
        ZarzadzanieWypozyczeniamiBean instance = new ZarzadzanieWypozyczeniamiBean();
        Collection<ZamowienieTO> expResult = null;
        Collection<ZamowienieTO> result = instance.pobierzZamowieniaWgCzasu(odd, doo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pobierzWszystkieZamowienia method, of class ZarzadzanieWypozyczeniamiBean.
     */
    @Test
    public void testPobierzWszystkieZamowienia() {
        System.out.println("pobierzWszystkieZamowienia");
        ZarzadzanieWypozyczeniamiBean instance = new ZarzadzanieWypozyczeniamiBean();
        Collection<ZamowienieTO> expResult = null;
        Collection<ZamowienieTO> result = instance.pobierzWszystkieZamowienia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}