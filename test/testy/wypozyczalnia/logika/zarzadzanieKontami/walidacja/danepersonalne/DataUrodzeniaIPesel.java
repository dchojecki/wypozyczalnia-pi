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
public class DataUrodzeniaIPesel {

    private IWalidatorDanychKonta walidator;

    public DataUrodzeniaIPesel() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void jeden() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            String s1 = "09.11.1985";
            String s2 = "86110916792";
            walidator.zwalidujDateUrodzeniaZPeselem(s1, s2);
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }

    }
    
    @Test
    public void dwa() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            String s1 = "09.11.1985";
            String s2 = "85110916799";
            walidator.zwalidujDateUrodzeniaZPeselem(s1, s2);
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }

    }    
    
        @Test
    public void trzy() {
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            String s1 = "09.11.1985";
            String s2 = "85110916792";
            walidator.zwalidujDateUrodzeniaZPeselem(s1, s2);
            fail();
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }

    }   
    // @Test
    // public void hello() {}
}
