/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieWypozyczeniami;

import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.*;
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
        ZarzWypGLFabrykaDanych instance = new ZarzWypGLFabrykaDanych();
        ZarzadzanieWypozyczeniamiDAO expResult = null;
        ZarzadzanieWypozyczeniamiDAO result = instance.createZarzadzanieWypozyczeniamiDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}