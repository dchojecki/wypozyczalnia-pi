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
public class WalidacjaPesel {
  private IWalidatorDanychKonta walidator;

    public WalidacjaPesel() {
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
    public void cyfry() {
      try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujPESEL("85110916799");            
        } catch (WalidatorDanychKontaWyjatek ex) {            
            fail();
        }
    }
    @Test
    public void litery() {
      try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujPESEL("8511a916799");            
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {                        
        }
    }
    
@Test
    public void cyfraKontrolna() {
      try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujPESEL("85110916791");            
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {                        
        }
    }   
 
        @Test
    public void dataWpeselu() {
      try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujPESEL("85132109052");            
            fail();            
        } catch (WalidatorDanychKontaWyjatek ex) {                        
            
        }
    } 

@Test
    public void pusty() {
      try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujPESEL("");            
            
        } catch (WalidatorDanychKontaWyjatek ex) {                        
            fail();
        }
    } 

@Test
    public void pustyChocNiePowinien() {
      try {
            walidator = WalidatorDanychKonta.pobierzWalidator(false);
            walidator.zwalidujPESEL("");            
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {                        
            
        }
    } 
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}