/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testy.wypozyczalnia.dao.jndi;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class persistenceTest {

    public persistenceTest() {
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
    public void test() {
        try {
            Hashtable env = new Hashtable();    
            env.put( Context.INITIAL_CONTEXT_FACTORY, "oracle.j2ee.naming.ApplicationClientInitialContextFactory" );
            env.put( Context.SECURITY_PRINCIPAL, "oc4jadmin" );
            env.put( Context.SECURITY_CREDENTIALS, "welcome" );
            env.put(Context.PROVIDER_URL, "ormi://localhost:23791/PersistenceSamples");

            final Context context = new InitialContext();
            ZarzadzanieWypozyczeniami zarz = 
            (ZarzadzanieWypozyczeniami)context.lookup("wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiBean");            
            //assertNotNull(zarz);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

}