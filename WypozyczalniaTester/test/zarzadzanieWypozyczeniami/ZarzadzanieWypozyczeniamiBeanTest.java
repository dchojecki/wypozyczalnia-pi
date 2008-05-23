/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zarzadzanieWypozyczeniami;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static wypozyczalnia.dao.StanZamowienia.*;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiBean;
import static org.junit.Assert.*;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.dao.fabryki.FactoryType;
/**
 *
 * @author marcin
 */
public class ZarzadzanieWypozyczeniamiBeanTest {

    private static ZarzadzanieWypozyczeniamiBean zarzadzanie;
    
    public ZarzadzanieWypozyczeniamiBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        zarzadzanie = new ZarzadzanieWypozyczeniamiBean();
        zarzadzanie.getDaoFabryka().setFactoryType(FactoryType.MEMORY);
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

    /**
     * Test of pobierzZamowieniaWgCzasu method, of class ZarzadzanieWypozyczeniamiBean.
     */
    @Test
    public void testPobierzZamowieniaWgCzasu() {
        System.out.println("pobierzZamowieniaWgCzasu");
        Date odd = null;
        Date doo = null;
    }

    /**
     * Test of pobierzWszystkieZamowienia method, of class ZarzadzanieWypozyczeniamiBean.
     */
    @Test
    public void testPobierzWszystkieZamowienia() {
    }
    
    @Test
    public void  testScalDaneZamowienia() {        
        ZamowienieTO z1 = zarzadzanie.utworzNoweZamowienie();
        ZamowienieTO z2 = zarzadzanie.utworzNoweZamowienie();
        ZamowienieTO z3 = zarzadzanie.utworzNoweZamowienie();
        
        z1.setStanzamowienia(DOODIORU);
        z1 = zarzadzanie.scalDaneZamowienia(z1);
        assertSame(z1.getStanzamowienia(), DOODIORU);

        
        z1.setStanzamowienia(POZYCZONE);
        z1 = zarzadzanie.scalDaneZamowienia(z1);
        assertSame(z1.getStanzamowienia(), POZYCZONE);

        
        z1.setStanzamowienia(ZREALIZOWANE);
        z1 = zarzadzanie.scalDaneZamowienia(z1);
        assertSame(z1.getStanzamowienia(), ZREALIZOWANE);

        

        
        
        z2.setStanzamowienia(ANULOWANE);
        z2 = zarzadzanie.scalDaneZamowienia(z2);
        assertSame(z2.getStanzamowienia(), ANULOWANE);

        
        z3.setStanzamowienia(DOODIORU);
        z3 = zarzadzanie.scalDaneZamowienia(z3);
        assertSame(z3.getStanzamowienia(), DOODIORU);
        z3.setStanzamowienia(ANULOWANE);
        z3 = zarzadzanie.scalDaneZamowienia(z3);
        assertSame(z3.getStanzamowienia(), ANULOWANE);
        
        
    }

}