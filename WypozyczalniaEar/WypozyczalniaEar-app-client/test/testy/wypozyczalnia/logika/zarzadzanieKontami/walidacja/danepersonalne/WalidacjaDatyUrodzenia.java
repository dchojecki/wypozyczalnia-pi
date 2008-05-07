/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testy.wypozyczalnia.logika.zarzadzanieKontami.walidacja.danepersonalne;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.IWalidatorDanychKonta;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.WalidatorDanychKonta;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.WalidatorDanychKontaWyjatek;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class WalidacjaDatyUrodzenia {

    private IWalidatorDanychKonta walidator;

    public WalidacjaDatyUrodzenia() {
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

    @Test
    public void jeden() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujDateUrodzenia("15.04.2008");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }

    @Test
    public void dwa() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujDateUrodzenia("");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }

    @Test
    public void trzy() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujDateUrodzenia("");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {

        }
    }
    
    @Test
    public void cztery() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujDateUrodzenia("29.02.2008");            
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }
@Test
    public void piec() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujDateUrodzenia("29.02.2009");            
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }    

@Test
    public void szesc() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujDateUrodzenia("01.01.2009");                        
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    } 
}
