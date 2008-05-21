package wypozyczalnia.ejb.zarzadzaniekontami;

/*a
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DateFormat;
import java.util.Collection;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiOracleDAOTest {

    public ZarzadzanieKontamiOracleDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    private static DateFormat formatter;
    private ZarzadzanieKontami zarzadzanie;

    @Before
    public void setUp() {
        try {
    Hashtable env = new Hashtable();
    //  Standalone OC4J connection details
    env.put( Context.INITIAL_CONTEXT_FACTORY, "oracle.j2ee.naming.ApplicationClientInitialContextFactory" );
    env.put( Context.SECURITY_PRINCIPAL, "oc4jadmin" );
    env.put( Context.SECURITY_CREDENTIALS, "welcome" );
    //env.put(Context.PROVIDER_URL, "ormi://localhost:23791/WypozyczalniaEar");
    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.evermind.server.ApplicationClientInitialContextFactory");
env.put(Context.PROVIDER_URL, "ormi://localhost:22667");
env.put(Context.SECURITY_PRINCIPAL, "pi");
env.put(Context.SECURITY_CREDENTIALS, "pi");
            
            final Context context = new InitialContext(env);
            zarzadzanie = (ZarzadzanieKontami) context.lookup("ZarzadzanieKontamiBean");

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
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
    public void test1() {
        zarzadzanie.usunWszystkieKonta();
        Collection<KontoTO> konta = zarzadzanie.zwrocListeWszystkichKont();
        assertEquals(konta.size(), 0);
    }

    @Test
    public void test2() {
        KlientTO klient = new KlientTO();
        AdresTO adres = new AdresTO();

        klient.setImie("Marcin");
        klient.setNazwisko("Kowalski");
        klient.setNrPeselKlienta("85110916799");
        klient.setAdresMailowy("scinek@gmail.com");
        zarzadzanie.zarejestrujKlienta(klient, adres);

        boolean ret = zarzadzanie.czyKlientZarejestrowany("85110916799");
        assertTrue(ret);
    }

    @Test
    public void test4() {
        boolean ret = zarzadzanie.czyKlientZarejestrowany("85110916798");
        assertFalse(ret);
    }

    @Test
    public void test5() {
    }

    @Test
    public void test6() {
        KontoTO konto = new KontoTO();
        konto.setNrPeselKlienta("85110916799");
        zarzadzanie.usunKonto(konto);


        boolean ret = zarzadzanie.czyKlientZarejestrowany(konto.getNrPeselKlienta());
        assertFalse(ret);

    }

    @Test
    public void test7() {
        KlientTO klient = new KlientTO();
        AdresTO adres = new AdresTO();
        klient.setImie("Mis");
        klient.setNazwisko("Jogi");
        klient.setNrPeselKlienta("85110916799");
        klient.setAdresMailowy("jogi@gmail.com");
        zarzadzanie.zarejestrujKlienta(klient, adres);
        
        zarzadzanie.zarejestrujKlienta(klient, adres);

        assertNull(null);
    }
}
