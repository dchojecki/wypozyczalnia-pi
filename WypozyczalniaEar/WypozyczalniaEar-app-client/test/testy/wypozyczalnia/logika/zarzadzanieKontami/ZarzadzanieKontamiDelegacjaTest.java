/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testy.wypozyczalnia.logika.zarzadzanieKontami;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.logika.zarzadzanieKontami.ZarzadzanieKontamiDelegacja;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiDelegacjaTest {

    public ZarzadzanieKontamiDelegacjaTest() {
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
    // @Test
    // public void hello() {}
    
    @Test
    public void singleton(){
        ZarzadzanieKontamiDelegacja a = ZarzadzanieKontamiDelegacja.getInstance();
        ZarzadzanieKontamiDelegacja b = ZarzadzanieKontamiDelegacja.getInstance();        
        assertSame(a, b);                        
    }
    
    @Test
    public void implementator(){
        assertTrue(ZarzadzanieKontamiDelegacja.getInstance().czyPolaczenieNawiazane());
    }    

}