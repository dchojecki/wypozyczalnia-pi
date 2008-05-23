/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zarzadzanieWypozyczeniami;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.StanZamowienia;
import static org.junit.Assert.*;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.mock.EntityManagerMock;
import wypozyczalnia.mock.ZarzWypOracleDAOMock;
import wypozyczalnia.mock.ZarzadzanieKontamiDAOMock;

/**
 *
 * @author marcin
 */
public class ZarzWypOracleDAOMockTest {

    private static ZarzWypOracleDAOMock wypDao;
    private static EntityManagerMock wypEM;
    private static ZarzadzanieKontamiDAOMock kontaDao;
    private static EntityManagerMock kontaEM;
    private static String pesel1 = "85110916799";

    public ZarzWypOracleDAOMockTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            wypDao = new ZarzWypOracleDAOMock();
            wypEM = wypDao.getEntityManagerMock();

            kontaDao = new ZarzadzanieKontamiDAOMock();
            kontaEM = wypDao.getEntityManagerMock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        wypEM.clear();
        kontaEM.clear();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of utworzNoweZamowienie method, of class ZarzWypOracleDAO.
     */
    @Test
    public void ready() {
        assertNotNull(wypDao);
        assertNotNull(kontaDao);
        assertNotNull(wypDao.getEntityManager());
    }

    @Test
    public void testUtworzNoweZamowienie() {
        System.out.println("utworzNoweZamowienie");

        KlientDAO k = new KlientDAO();
        k.setNrpesel(pesel1);

        dbConnectionTestPre();
        ZamowienieDAO z = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();


        z.setKlient(k);
        z.setStanzamowienia(StanZamowienia.PRZYJETE);
        PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
        PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();
        p1.setCenaJednostkowa((float) 3.14);
        p2.setCenaJednostkowa((float) 2.73);

        z.getPozycje().add(p1);
        z.getPozycje().add(p2);

        dbConnectionTestPre();
        wypDao.scalZamowienie(z);
        dbConnectionTestPost();
        
        assertTrue(wypEM.getStorage().contains(z));
    }

    /**
     * Test of pobierzZamowienie method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testPobierzZamowienie1() {
        System.out.println("pobierzZamowienie");

        dbConnectionTestPre();
        ZamowienieDAO z = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();

        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        dbConnectionTestPre();
        wypDao.scalZamowienie(z);
        dbConnectionTestPost();

        ZamowienieDAO zz = wypDao.pobierzZamowienie(z.getId());
        assertEquals(zz.getId(), z.getId());
        assertEquals(StanZamowienia.POZYCZONE, z.getStanzamowienia());
    }

    /**
     * "cichy find"
     * metoda pobierzZamowienie nie rzuca wyjatkiem, ale zwraca null
     * 
     */
    @Test
    public void testPobierzZamowienie2() {
        System.out.println("pobierzZamowienie");
        dbConnectionTestPre();
        ZamowienieDAO z = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        dbConnectionTestPre();
        wypDao.scalZamowienie(z);
        dbConnectionTestPost();

        ZamowienieDAO zz = wypDao.pobierzZamowienie(-1);
        assertNull(zz);
    }

    /**
     * Test of scalZamowienie method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testScalZamowienie() {
        dbConnectionTestPre();
        ZamowienieDAO z = wypDao.utworzNoweZamowienie();
        assertNotNull(z);
        dbConnectionTestPost();
        KlientDAO k = new KlientDAO();
        k.setNrpesel(pesel1);
        k.setImie("Marcin");
        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        z.setKlient(k);

        dbConnectionTestPre();
        wypDao.scalZamowienie(z);
        dbConnectionTestPost();

        Integer id = z.getId();
        z = wypDao.pobierzZamowienie(id);

        assertNotNull(z);
        assertTrue(z.getId() == id);
        assertTrue(z.getStanzamowienia() == StanZamowienia.POZYCZONE);
        assertTrue(pesel1.equals(z.getKlient().getNrpesel()));
        assertTrue("Marcin".equals(z.getKlient().getImie()));


        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
        PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();
        p1.setId(2);
        p2.setId(3);

        z.getPozycje().add(p1);
        z.getPozycje().add(p2);

        dbConnectionTestPre();
        wypDao.scalZamowienie(z);
        dbConnectionTestPost();


        z = wypDao.pobierzZamowienie(id);

        assertNotNull(z);
        assertTrue(z.getId() == id);
        assertTrue(z.getStanzamowienia() == StanZamowienia.POZYCZONE);
        assertTrue(pesel1.equals(z.getKlient().getNrpesel()));
        assertTrue("Marcin".equals(z.getKlient().getImie()));

        assertTrue(z.getPozycje().size() == 2);
        for (PozycjaZamowieniaDAO pz : z.getPozycje()) {
            if (pz.getId() != 2 && pz.getId() != 3) {
                fail();
            }
        }

    }

    /**
     * Test of pobierzWszystkieZamowienia method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testPobierzWszystkieZamowienia() {
        System.out.println("pobierzWszystkieZamowienia");
        dbConnectionTestPre();
        ZamowienieDAO z1 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        dbConnectionTestPre();
        ZamowienieDAO z2 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        dbConnectionTestPre();
        ZamowienieDAO z3 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        dbConnectionTestPre();
        ZamowienieDAO z4 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();

        z1.setStanzamowienia(StanZamowienia.POZYCZONE);
        z2.setStanzamowienia(StanZamowienia.ANULOWANE);
        z3.setStanzamowienia(StanZamowienia.DOODIORU);
        z4.setStanzamowienia(StanZamowienia.ZALEGLE);

        dbConnectionTestPre();
        wypDao.scalZamowienie(z1);
        dbConnectionTestPost();
        dbConnectionTestPre();
        wypDao.scalZamowienie(z2);
        dbConnectionTestPost();
        dbConnectionTestPre();
        wypDao.scalZamowienie(z3);
        dbConnectionTestPost();
        dbConnectionTestPre();
        wypDao.scalZamowienie(z4);
        dbConnectionTestPost();


        dbConnectionTestPre();
        Collection<? extends ZamowienieDAO> zamowienia = wypDao.pobierzWszystkieZamowienia();
        dbConnectionTestPost();

        assertTrue(zamowienia.size() == 4);

        for (ZamowienieDAO z : zamowienia) {
            if (z.getId() != z1.getId() &&
                    z.getId() != z2.getId() &&
                    z.getId() != z3.getId() &&
                    z.getId() != z4.getId()) {
                fail();
            }
        }


    }

    /**
     * Test of pobierzWszystkieZamowieniaOdDo method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testPobierzWszystkieZamowieniaOdDo() {
        System.out.println("pobierzWszystkieZamowieniaOdDo");

        dbConnectionTestPre();
        ZamowienieDAO z1 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date odd = new Date();
        dbConnectionTestPre();
        ZamowienieDAO z2 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        dbConnectionTestPre();
        ZamowienieDAO z3 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();
        Date ddo = new Date();
        dbConnectionTestPre();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ZamowienieDAO z4 = wypDao.utworzNoweZamowienie();
        dbConnectionTestPost();


        dbConnectionTestPre();
        wypDao.scalZamowienie(z1);
        dbConnectionTestPost();
        dbConnectionTestPre();
        wypDao.scalZamowienie(z2);
        dbConnectionTestPost();
        dbConnectionTestPre();
        wypDao.scalZamowienie(z3);
        dbConnectionTestPost();
        dbConnectionTestPre();
        wypDao.scalZamowienie(z4);
        dbConnectionTestPost();


        dbConnectionTestPre();
        Collection<? extends ZamowienieDAO> zamowienia = wypDao.pobierzWszystkieZamowieniaOdDo(odd, ddo);
        dbConnectionTestPost();

        assertTrue(zamowienia.size() == 2);

        for (ZamowienieDAO z : zamowienia) {
            if (z.getId() != z2.getId() &&
                    z.getId() != z3.getId()) {
                fail();
            }
        }
    }

    /**
     * Test of getEm method, of class ZarzWypOracleDAO.
     */
    /**
     * Test of setEm method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testSetEm() {
        System.out.println("setEm");
        EntityManager em = null;
        wypDao.setEntityMangerMock(em);
        assertNull(wypDao.getEntityManager());

    }

    @Test
    public void testGetEm() {
        System.out.println("getEm");
        wypDao.setEntityMangerMock(wypEM);
        assertSame(wypDao.getEntityManagerMock(), wypEM);
    }

    private void dbConnectionTestPost() {
        assertTrue(wypEM.isOpen());
        assertFalse(wypEM.getTransactionMock().isActive());
        assertTrue(wypEM.getTransactionMock().isComitDone());
        assertFalse(wypEM.getTransactionMock().isRollbackDone());
        wypEM.reset();
    }

    private void dbConnectionTestPre() {
        assertTrue(wypEM.isOpen());
        assertFalse(wypEM.getTransactionMock().isActive());
        assertFalse(wypEM.getTransactionMock().isComitDone());
        assertFalse(wypEM.getTransactionMock().isRollbackDone());
    }
}