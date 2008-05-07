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
public class WalidacjaNazwiska {
  private IWalidatorDanychKonta walidator;

    public WalidacjaNazwiska() {
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
            walidator.zwalidujNazwisko("Żaba");            
        } catch (WalidatorDanychKontaWyjatek ex) {            
            fail();
        }
    }
    
    
    @Test
    public void imieOK() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("Marcin");            
        } catch (WalidatorDanychKontaWyjatek ex) {            
            fail();
        }
    }
    @Test
    public void sameLitery() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("abcdefghijklomnower");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {            
        }
    }

    @Test
    public void cyfry() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("1marcin");
            fail();
            walidator.zwalidujNazwisko("1marcin1");
            fail();
            walidator.zwalidujNazwisko("marcin9");
            fail();
            walidator.zwalidujNazwisko("mar4cin");
            fail();
            walidator.zwalidujNazwisko("230949345");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }

    }

    @Test
    public void pustePusteNieOk() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujNazwisko("");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {

        }
    }

    @Test
    public void puste() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }

    @Test
    public void dwaZnaki() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("Ab");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }
    }

        @Test
    public void dwaZnakiDuze() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("ŻM");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }
    @Test
    public void dwaZnakiMale() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("mm");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }

    @Test
    public void jedenDuzyZnak() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("A");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }
    }

    @Test
    public void jedenMalyZnak() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("a");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }
    }

    @Test
    public void spacja() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko("marcin pawel");
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        }
    }

    @Test
    public void nule() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujNazwisko(null);
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
            walidator.zwalidujNazwisko(null);
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
        } catch (Exception ex) {
            fail();
        }
    }
}
