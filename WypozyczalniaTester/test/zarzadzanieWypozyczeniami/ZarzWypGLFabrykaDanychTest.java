/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieWypozyczeniami;

import junit.framework.JUnit4TestAdapter;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.dao.fabryki.FactoryType;
import wypozyczalnia.mock.ZarzWypOracleDAOMock;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class ZarzWypGLFabrykaDanychTest {
    
    public ZarzWypGLFabrykaDanychTest() {
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
     * Test of createZarzadzanieWypozyczeniamiDAO method, of class ZarzWypGLFabrykaDanych.
     */
    @Test
    public void testCreateZarzadzanieWypozyczeniamiDAO() {
        System.out.println("createZarzadzanieWypozyczeniamiDAO");
        Class c1 = ZarzWypOracleDAO.class;
        Class c2 = ZarzWypOracleDAOMock.class;
        
        ZarzWypGLFabrykaDanych instance = new ZarzWypGLFabrykaDanych();
        ZarzadzanieWypozyczeniamiDAO result = instance.createZarzadzanieWypozyczeniamiDAO();
        assertNotNull(result);
        assertEquals(c1, result.getClass());
        
        instance.setFactoryType(FactoryType.OracleDAO);
        result = instance.createZarzadzanieWypozyczeniamiDAO();        
        assertNotNull(result);
        assertEquals(c1, result.getClass());
        assertNotNull(((ZarzWypOracleDAO)result).getEntityManager());
        
        instance.setFactoryType(FactoryType.MEMORY);
        result = instance.createZarzadzanieWypozyczeniamiDAO();
        assertNotNull(result);
        assertEquals(c2, result.getClass());
    }
    
    
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ZarzWypGLFabrykaDanychTest.class);
    }
    
    @Test
    public void testGetFactoryType() {
        ZarzWypGLFabrykaDanych instance = new ZarzWypGLFabrykaDanych();
        // default:
        assertTrue(instance.getFactoryType() == FactoryType.OracleDAO);
    }
    
    @Test
    public void testSetFactoryType() {
        ZarzWypGLFabrykaDanych instance = new ZarzWypGLFabrykaDanych();
        instance.setFactoryType(FactoryType.MEMORY);
        assertSame(instance.getFactoryType(), FactoryType.MEMORY);
        instance.setFactoryType(FactoryType.OracleDAO);
        assertSame(instance.getFactoryType(), FactoryType.OracleDAO);
    }
}