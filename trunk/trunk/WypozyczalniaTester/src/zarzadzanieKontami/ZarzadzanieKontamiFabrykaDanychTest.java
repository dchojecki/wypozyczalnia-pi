/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieKontami;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wypozyczalnia.dao.fabryki.FactoryType;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAOMock;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiGlownaFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiOracleDAO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiFabrykaDanychTest {

    public ZarzadzanieKontamiFabrykaDanychTest() {
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
     * Test of pobierzWypozyczalniaDAO method, of class ZarzadzanieKontamiFabrykaDanych.
     */
    @Test
    public void testPobierzWypozyczalniaDAO() {
        System.out.println("pobierzWypozyczalniaDAO");
        ZarzadzanieKontamiFabrykaDanych instance = new ZarzadzanieKontamiGlownaFabrykaDanych();
        Class<ZarzadzanieKontamiDAOMock> c1 = ZarzadzanieKontamiDAOMock.class;
        Class<ZarzadzanieKontamiOracleDAO> c2 = ZarzadzanieKontamiOracleDAO.class;
        
        
        ZarzadzanieKontamiDAO result = instance.pobierzWypozyczalniaDAO();
        assertEquals(c1, result.getClass());
        
        instance.setFactoryType(FactoryType.OracleDAO);
        result = instance.pobierzWypozyczalniaDAO();
        assertNotNull(result);
        assertTrue(result instanceof ZarzadzanieKontamiDAO);
    }
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ZarzadzanieKontamiFabrykaDanychTest.class);
    }
}