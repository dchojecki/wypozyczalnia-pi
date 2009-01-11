package zarzadzanieWypozyczeniami;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypOracleDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypOracleDAOMock;

/**
 *
 * @author marcin
 */
public class ZarzWypOracleDAOTest {

    private ZarzWypOracleDAOMock wypDao;
//    private static ZarzadzanieKontamiDAO kontaDao;
    private static String pesel1 = "85110916799";

    public ZarzWypOracleDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void ready() {
        assertNotNull(wypDao);
        assertNotNull(wypDao.getEntityManager());
    }

    @Before
    public void setUp() {
    	wypDao = new ZarzWypOracleDAOMock();
    	wypDao.getEntityManagerMock().clear();
    }

    @After
    public void tearDown() {
    }

    /* @Test
    public void test1() {
    
    Collection<? extends ZamowienieDAO> zamowienia = dao.pobierzWszystkieZamowienia();
    for (ZamowienieDAO zz : zamowienia) {
    System.out.println(zz.getStanzamowienia().toString());
    }
    
    }*/
    /*
    @Test
    public void test3() {
    ZamowienieDAO z = dao.utworzNoweZamowienie();
    KlientDAO k = null;//daoKonta.zwrocDaneKlienta("13");
    z.setKlient(k);
    z.setStanzamowienia(StanZamowienia.ZREALIZOWANE);
    PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
    PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();
    p1.setCenaJednostkowa((float) 3.14);
    p2.setCenaJednostkowa((float) 2.73);
    
    z.getPozycje().add(p1);
    z.getPozycje().add(p2);
    
    dao.scalZamowienie(z);        
    
    Collection<? extends ZamowienieDAO> zamowienia = 
    dao.pobierzWszystkieZamowienia();
    
    }
    
    @Test
    public void test4() {
    Collection<? extends ZamowienieDAO> z = dao.pobierzWszystkieZamowienia();
    
    for (ZamowienieDAO zz : z) {
    System.out.println(zz.getKlient().getImie());
    }
    }
     */
    /**
     * Test of utworzNoweZamowienie method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testUtworzNoweZamowienie() {
        System.out.println("utworzNoweZamowienie");

        KlientDAO k = new KlientDAO();
        k.setNrpesel(pesel1);

        ZamowienieDAO z = wypDao.utworzNoweZamowienie();


//        z.setKlient(k);
        z.setStanzamowienia(StanZamowienia.PRZYJETE);
        PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
        PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();
        p1.setCenaJednostkowa((float) 3.14);
        p2.setCenaJednostkowa((float) 2.73);

        z.getPozycje().add(p1);
        z.getPozycje().add(p2);

        wypDao.scalZamowienie(z);

        Collection<? extends ZamowienieDAO> zams = wypDao.pobierzWszystkieZamowienia();

        boolean jest = false;
        for (ZamowienieDAO zam : zams) {
            if (zam.getId().equals(z.getId())) {
                if (zam.getPozycje().size() == 2 && zam.getStanzamowienia().equals(StanZamowienia.PRZYJETE)) {
                    jest = true;
                }
            }
        }

        if (!jest) {
            fail();
        }
    }

    @Test
    public void testPobierzZamowienie1() {
        System.out.println("pobierzZamowienie");

        ZamowienieDAO z = wypDao.utworzNoweZamowienie();

        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        wypDao.scalZamowienie(z);

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
        ZamowienieDAO z = wypDao.utworzNoweZamowienie();
        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        wypDao.scalZamowienie(z);

        ZamowienieDAO zz = wypDao.pobierzZamowienie(-1);
        assertNull(zz);
    }

    /**
     * Test of scalZamowienie method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testScalZamowienie() {
        ZamowienieDAO z = wypDao.utworzNoweZamowienie();
        assertNotNull(z);
        KlientDAO k = new KlientDAO();
        k.setNrpesel(pesel1);
        k.setImie("Marcin");
        z.setStanzamowienia(StanZamowienia.POZYCZONE);
//        z.setKlient(k);

        wypDao.scalZamowienie(z);

        Integer id = z.getId();
        z = wypDao.pobierzZamowienie(id);

        assertNotNull(z);
        assertTrue(z.getId() == id);
        assertTrue(z.getStanzamowienia() == StanZamowienia.POZYCZONE);
//        assertTrue(pesel1.equals(z.getKlient().getNrpesel()));
//        assertTrue("Marcin".equals(z.getKlient().getImie()));


        z.setStanzamowienia(StanZamowienia.POZYCZONE);
        PozycjaZamowieniaDAO p1 = new PozycjaZamowieniaDAO();
        PozycjaZamowieniaDAO p2 = new PozycjaZamowieniaDAO();

        z.getPozycje().add(p1);
        z.getPozycje().add(p2);

        wypDao.scalZamowienie(z);


        z = wypDao.pobierzZamowienie(id);

        assertNotNull(z);
        assertTrue(z.getId() == id);
        assertTrue(z.getStanzamowienia() == StanZamowienia.POZYCZONE);
//        assertTrue(pesel1.equals(z.getKlient().getNrpesel()));
//        assertTrue("Marcin".equals(z.getKlient().getImie()));

        assertTrue(z.getPozycje().size() == 2);
    }

    @Test
    public void testPobierzWszystkieZamowienia() {

        Collection<? extends ZamowienieDAO> zamowieniaPrzed = wypDao.pobierzWszystkieZamowienia();
        System.out.println("pobierzWszystkieZamowienia");
        ZamowienieDAO z1 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z2 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z3 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z4 = wypDao.utworzNoweZamowienie();

        z1.setStanzamowienia(StanZamowienia.POZYCZONE);
        z2.setStanzamowienia(StanZamowienia.ANULOWANE);
        z3.setStanzamowienia(StanZamowienia.DOODIORU);
        z4.setStanzamowienia(StanZamowienia.ZALEGLE);

        wypDao.scalZamowienie(z1);
        wypDao.scalZamowienie(z2);
        wypDao.scalZamowienie(z3);
        wypDao.scalZamowienie(z4);


        Collection<? extends ZamowienieDAO> zamowienia = wypDao.pobierzWszystkieZamowienia();

        assertTrue(zamowienia.size() == zamowieniaPrzed.size() + 4);

    }

    /**
     * Test of pobierzWszystkieZamowieniaOdDo method, of class ZarzWypOracleDAO.
     */
    @Test
    public void testPobierzWszystkieZamowieniaOdDo() {
        System.out.println("pobierzWszystkieZamowieniaOdDo");

        ZamowienieDAO z1 = wypDao.utworzNoweZamowienie();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date odd = new Date();
        ZamowienieDAO z2 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z3 = wypDao.utworzNoweZamowienie();
        Date ddo = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ZamowienieDAO z4 = wypDao.utworzNoweZamowienie();


        wypDao.scalZamowienie(z1);
        wypDao.scalZamowienie(z2);
        wypDao.scalZamowienie(z3);
        wypDao.scalZamowienie(z4);


        Collection<? extends ZamowienieDAO> zamowienia = wypDao.pobierzWszystkieZamowieniaOdDo(odd, ddo);

        assertTrue(zamowienia.size() == 2);

        for (ZamowienieDAO z : zamowienia) {
            if (z.getId() != z2.getId() &&
                    z.getId() != z3.getId()) {
                fail();
            }
        }
    }

    @Test
    public void testPobierzWszystkieZamowieniaOdDo2() {
        System.out.println("pobierzWszystkieZamowieniaOdDo");

        Date odd = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        ZamowienieDAO z1 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z2 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z3 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z4 = wypDao.utworzNoweZamowienie();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date ddo = new Date();


        wypDao.scalZamowienie(z1);
        wypDao.scalZamowienie(z2);
        wypDao.scalZamowienie(z3);
        wypDao.scalZamowienie(z4);


        Collection<? extends ZamowienieDAO> zamowienia = wypDao.pobierzWszystkieZamowieniaOdDo(odd, ddo);

        assertTrue(zamowienia.size() == 4);

        for (ZamowienieDAO z : zamowienia) {
            if (z.getId() != z2.getId() &&
                    z.getId() != z1.getId() &&
                    z.getId() != z3.getId() &&
                    z.getId() != z4.getId()) {
                fail();
            }
        }
    }

    @Test
    public void testPobierzWszystkieZamowieniaOdDo3() {
        System.out.println("pobierzWszystkieZamowieniaOdDo");

        Date odd = new Date();
        Date ddo = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ZarzWypOracleDAOMockTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        ZamowienieDAO z1 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z2 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z3 = wypDao.utworzNoweZamowienie();
        ZamowienieDAO z4 = wypDao.utworzNoweZamowienie();


        wypDao.scalZamowienie(z1);
        wypDao.scalZamowienie(z2);
        wypDao.scalZamowienie(z3);
        wypDao.scalZamowienie(z4);


        Collection<? extends ZamowienieDAO> zamowienia = wypDao.pobierzWszystkieZamowieniaOdDo(odd, ddo);

        assertTrue(zamowienia.size() == 0);
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ZarzWypOracleDAOTest.class);
    }
}
