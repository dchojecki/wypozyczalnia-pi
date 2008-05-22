/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieKontami;

import java.util.Collection;
import javax.persistence.EntityManager;
import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiOracleDAO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiOracleDAOTest {

    public ZarzadzanieKontamiOracleDAOTest() {
    }
    private static ZarzadzanieKontamiOracleDAO instance;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = new ZarzadzanieKontamiOracleDAO();
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
     * Test of zwrocListeWszystkichKlientow method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testZwrocListeWszystkichKlientow() {
        KlientDAO k = instance.utworzNoweKonto();
        System.out.println("zwrocListeWszystkichKlientow");
        Collection<KlientDAO> expResult = null;
        Collection<KlientDAO> result = instance.zwrocListeWszystkichKlientow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zwrocDaneKlienta method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testZwrocDaneKlienta() {
        System.out.println("zwrocDaneKlienta");
        String nrpesel = "";
        KlientDAO expResult = null;
        KlientDAO result = instance.zwrocDaneKlienta(nrpesel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEm method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testGetEm() {
        System.out.println("getEm");
        EntityManager expResult = null;
        EntityManager result = instance.getEm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEm method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testSetEm() {
        System.out.println("setEm");
        EntityManager em = null;
        instance.setEm(em);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scalDaneKlienta method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testScalDaneKlienta() {
        System.out.println("scalDaneKlienta");
        KlientDAO klient = null;
        instance.scalDaneKlienta(klient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of utworzNoweKonto method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testUtworzNoweKonto() {
        System.out.println("utworzNoweKonto");
        KlientDAO expResult = null;
        KlientDAO result = instance.utworzNoweKonto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usunKonto method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testUsunKonto() {
        System.out.println("usunKonto");
        KlientDAO daneKlienta = null;
        instance.usunKonto(daneKlienta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startSesji method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testStartSesji() {
        System.out.println("startSesji");
        instance.startSesji();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commit method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testCommit() {
        System.out.println("commit");
        instance.commit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rollback method, of class ZarzadzanieKontamiOracleDAO.
     */
    @Test
    public void testRollback() {
        System.out.println("rollback");
        instance.rollback();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ZarzadzanieKontamiOracleDAOTest.class);
    }

}