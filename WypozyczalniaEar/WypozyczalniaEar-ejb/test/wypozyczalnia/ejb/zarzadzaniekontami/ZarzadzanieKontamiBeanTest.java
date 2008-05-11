/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.ejb.zarzadzaniekontami;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiBeanTest {

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of modyfikujDaneAdresu method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void modyfikujDaneAdresu() {
        System.out.println("modyfikujDaneAdresu");
        AdresTO adres = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.modyfikujDaneAdresu(adres);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modyfikujDaneKlienta method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void modyfikujDaneKlienta() {
        System.out.println("modyfikujDaneKlienta");
        KlientTO klient = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.modyfikujDaneKlienta(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modyfikujDaneKonta method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void modyfikujDaneKonta() {
        System.out.println("modyfikujDaneKonta");
        KontoTO konto = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.modyfikujDaneKonta(konto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zwrocDaneAdresu method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zwrocDaneAdresu() {
        System.out.println("zwrocDaneAdresu");
        String nrPesel = "";
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        AdresTO expResult = null;
        AdresTO result = instance.zwrocDaneAdresu(nrPesel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zwrocDaneKonta method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zwrocDaneKonta() {
        System.out.println("zwrocDaneKonta");
        String nrpesel = "";
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        KontoTO expResult = null;
        KontoTO result = instance.zwrocDaneKonta(nrpesel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zwrocDaneKlienta method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zwrocDaneKlienta() {
        System.out.println("zwrocDaneKlienta");
        String nrpesel = "";
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        KlientTO expResult = null;
        KlientTO result = instance.zwrocDaneKlienta(nrpesel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zablokujKonto method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zablokujKonto() {
        System.out.println("zablokujKonto");
        KlientTO klient = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.zablokujKonto(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of odblokujKonto method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void odblokujKonto() {
        System.out.println("odblokujKonto");
        KlientTO klient = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.odblokujKonto(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zmienHaslo method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zmienHaslo() {
        System.out.println("zmienHaslo");
        String nowySkrotHasla = "";
        Integer nrKonta = null;
        String starySkrotHasla = "";
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.zmienHaslo(nowySkrotHasla, nrKonta, starySkrotHasla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zaloguj method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zaloguj() {
        System.out.println("zaloguj");
        String skrotHasla = "";
        Integer nrKonta = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        KontoTO expResult = null;
        KontoTO result = instance.zaloguj(skrotHasla, nrKonta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of czyKlientZarejestrowany method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void czyKlientZarejestrowany() {
        System.out.println("czyKlientZarejestrowany");
        String nrPesel = "";
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        boolean expResult = false;
        boolean result = instance.czyKlientZarejestrowany(nrPesel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zarejestrujKlienta method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zarejestrujKlienta() {
        System.out.println("zarejestrujKlienta");
        KlientTO klient = null;
        AdresTO adres = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        KontoTO expResult = null;
        KontoTO result = instance.zarejestrujKlienta(klient, adres);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wyloguj method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void wyloguj() {
        System.out.println("wyloguj");
        Integer nrKonta = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.wyloguj(nrKonta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usunWszystkieKonta method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void usunWszystkieKonta() {
        System.out.println("usunWszystkieKonta");
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.usunWszystkieKonta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zwrocListeWszystkichKont method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void zwrocListeWszystkichKont() {
        System.out.println("zwrocListeWszystkichKont");
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        Collection<KontoTO> expResult = null;
        Collection<KontoTO> result = instance.zwrocListeWszystkichKont();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usunKonto method, of class ZarzadzanieKontamiBean.
     */
    @Test
    public void usunKonto() {
        System.out.println("usunKonto");
        KontoTO konto = null;
        ZarzadzanieKontamiBean instance = new ZarzadzanieKontamiBean();
        instance.usunKonto(konto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}