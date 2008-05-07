/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testy.wypozyczalnia.logika.zarzadzanieKontami.walidacja.tworzenieKonta;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.logika.zarzadzanieKontami.ZarzadzanieKontamiDelegacja;
import static org.junit.Assert.*;
import wypozyczalnia.logika.zarzadzanieKontami.ZarzadzanieKontamiWyjatek;
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.WalidatorDanychKontaWyjatek;

/**
 *
 * @author marcin
 */
public class delegacjaDaneWejsciowe {
    
    private ZarzadzanieKontamiDelegacja delegacja;
    
    public delegacjaDaneWejsciowe() {
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
            delegacja = ZarzadzanieKontamiDelegacja.getInstance();
            delegacja.utworzNoweKonto("", "", "", "", "");
            fail();
        } catch (ZarzadzanieKontamiWyjatek ex) {
     
        } catch (WalidatorDanychKontaWyjatek ex) {
   
        }       
    }

@Test
    public void dwa() {
        try {
            delegacja = ZarzadzanieKontamiDelegacja.getInstance();
            delegacja.utworzNoweKonto("Kowalski", "Marcin", "09.11.1985", "85110916799", "scinek@o2.pl");                        
        } catch (ZarzadzanieKontamiWyjatek ex) {
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();
        }       
        
    }
        
@Test
    public void trzy() {
        try {
            delegacja = ZarzadzanieKontamiDelegacja.getInstance();
            delegacja.utworzNoweKonto("Kowalski", "Marcin", "09.11.1985", "85110916799", "scinek@o2.pl");
            delegacja.czyUzytkownikZarejestrowany("85110916799");
        } catch (ZarzadzanieKontamiWyjatek ex) {
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();

        }       
    }       
@Test
    public void cztery() {
        try {
            delegacja = ZarzadzanieKontamiDelegacja.getInstance();
            delegacja.czyUzytkownikZarejestrowany("");
            fail();
        } catch (ZarzadzanieKontamiWyjatek ex) {
        } catch (WalidatorDanychKontaWyjatek ex) {            

        }       
    }      
    @Test
    public void singleton(){
        ZarzadzanieKontamiDelegacja a = ZarzadzanieKontamiDelegacja.getInstance();
        ZarzadzanieKontamiDelegacja b = ZarzadzanieKontamiDelegacja.getInstance();        
        assertSame(a, b);                        
    }
}