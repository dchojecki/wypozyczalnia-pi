/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieKontami;

import wypozyczalnia.dao.fabryki.zarzadzaniekontami.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        ZarzadzanieKontamiFabrykaDanych instance = new ZarzadzanieKontamiFabrykaDanych();
        ZarzadzanieKontamiDAO expResult = null;
        ZarzadzanieKontamiDAO result = instance.pobierzWypozyczalniaDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}