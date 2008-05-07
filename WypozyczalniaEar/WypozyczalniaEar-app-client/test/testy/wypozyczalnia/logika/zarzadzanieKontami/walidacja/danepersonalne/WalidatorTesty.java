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
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class WalidatorTesty {
    private IWalidatorDanychKonta walidator;
    
    public WalidatorTesty() {
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
    public void pobierzEgzemplarz() {        
        walidator = WalidatorDanychKonta.pobierzWalidator(true);
        assertNotNull(walidator);
    }
    @Test
    public void walidujPoprawne() {
        walidator = WalidatorDanychKonta.pobierzWalidator(true);
        try {
            walidator.zwalidujImie("Marcin");
            walidator.zwalidujImie("Kowalski");
            //walidator.zwalidujDateUrodzenia("28.02.2008");
            walidator.zwalidujMail("adda@bbbb.com");
            //walidator.zwalidujPESEL("85110916799");            
        }
        catch(Exception e)
        {
            fail();
        }
    }
    
    @Test
    public void pobierzEgzemplarz2() {        
        walidator = WalidatorDanychKonta.pobierzWalidator(false);
        assertNotNull(walidator);
    }
    @Test
    public void walidujPoprawne2() {
        walidator = WalidatorDanychKonta.pobierzWalidator(false);
        try {
            walidator.zwalidujImie("Marcin");
            walidator.zwalidujImie("Kowalski");
            walidator.zwalidujDateUrodzenia("28.02.2008");
            walidator.zwalidujMail("abc@bef.com");
            walidator.zwalidujPESEL("85110916799");            
        }
        catch(Exception e)
        {
            fail();
        }
    }

}