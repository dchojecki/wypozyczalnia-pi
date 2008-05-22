package zarzadzanieWypozyczeniami;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiOracleDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypOracleDAO;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class ZarzWypOracleDAOTest {
    
    public ZarzWypOracleDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            formatter = new SimpleDateFormat("yyMMdd");
            dao = new ZarzWypOracleDAO();
            ZamowienieDAO zz = dao.utworzNoweZamowienie();
            zz.setStanzamowienia(StanZamowienia.ANULOWANE);
            dao.scalZamowienie(zz);
            daoKonta = new ZarzadzanieKontamiOracleDAO();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    private static DateFormat formatter;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ZarzWypOracleDAO dao;
    private static ZarzadzanieKontamiOracleDAO daoKonta;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1() {
        
        Collection<? extends ZamowienieDAO> zamowienia = dao.pobierzWszystkieZamowienia();
        for (ZamowienieDAO zz : zamowienia) {
            System.out.println(zz.getStanzamowienia().toString());
        }
        
    }
    
    @Test
    public void test3() {
        ZamowienieDAO z = dao.utworzNoweZamowienie();
        KlientDAO k = daoKonta.zwrocDaneKlienta("13");
        z.setKlient(k);
        z.setStanzamowienia(StanZamowienia.ZREALIZOWANE);
        PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
        PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();
        p1.setCenaJednostkowa((float) 3.14);
        p2.setCenaJednostkowa((float) 2.73);
        
        z.getPozycje().add(p1);
        z.getPozycje().add(p2);
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        dao.scalZamowienie(z);
        try {
            et.commit();
        } catch (Exception e) {
            fail();
        }
        
    }
    
    @Test
    public void test4() {
        Collection<? extends ZamowienieDAO> z = dao.pobierzWszystkieZamowienia();
        
        for (ZamowienieDAO zz : z) {
            System.out.println(zz.getKlient().getImie());
        }
    }
    
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ZarzWypOracleDAOTest.class);
    }
}
