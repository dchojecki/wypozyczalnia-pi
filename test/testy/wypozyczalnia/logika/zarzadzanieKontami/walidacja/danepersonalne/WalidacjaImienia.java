/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testy.wypozyczalnia.logika.zarzadzanieKontami.walidacja.danepersonalne;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.IWalidatorDanychKonta;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.WalidatorDanychKonta;
import static org.junit.Assert.*;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.WalidatorDanychKontaWyjatek;

/**
 *
 * @author marcin
 */
public class WalidacjaImienia {

    private IWalidatorDanychKonta walidator;

    public WalidacjaImienia() {
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
    public void polskieCzcionki() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("Żaba");            
        } catch (WalidatorDanychKontaWyjatek ex) {            
            fail();
        }
    }
    
    
    @Test
    public void imieOK() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("Marcin");            
        } catch (WalidatorDanychKontaWyjatek ex) {            
            fail();
        }
    }
    @Test
    public void sameLitery() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("abcdefghijklomnower");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {            
        }
    }

    @Test
    public void cyfry() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("1marcin");
            fail();
            walidator.zwalidujImie("1marcin1");
            fail();
            walidator.zwalidujImie("marcin9");
            fail();
            walidator.zwalidujImie("mar4cin");
            fail();
            walidator.zwalidujImie("230949345");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }

    }

    @Test
    public void pustePusteNieOk() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujImie("");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {

        }
    }

    @Test
    public void puste() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }

    @Test
    public void dwaZnaki() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("Ab");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }

        @Test
    public void dwaZnakiDuze() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("ŻM");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }
    @Test
    public void dwaZnakiMale() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("mm");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }

    @Test
    public void jedenDuzyZnak() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("A");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }
    }

    @Test
    public void jedenMalyZnak() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("a");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }
    }

    @Test
    public void spacja() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie("marcin pawel");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }
    }

    @Test
    public void nule() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujImie(null);
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void nulePusteNieOk() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujImie(null);
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        } catch (Exception ex) {
            fail();
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
