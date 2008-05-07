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
import wypozyczalnia.logika.zarzadzanieKontami.walidacja.WalidatorDanychKontaWyjatek;
import static org.junit.Assert.*;
/**
 *
 * @author marcin
 */
public class WalidacjaMaila {
  private IWalidatorDanychKonta walidator;

    public WalidacjaMaila() {
    }
    
    @Test
    public void ok(){
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujMail("scinek@o2.pl");
        } catch (WalidatorDanychKontaWyjatek ex) {
            fail();         
        }
    }
    
  @Test
    public void dwa(){
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujMail("scineko2.pl");
            fail();         
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }   
  
  @Test
    public void trzy(){
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujMail("scinek@pl");
            fail();         
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }    
  
  @Test
    public void cztery(){
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujMail("a");
            fail();         
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }     
    
  @Test
    public void piec(){
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujMail("@bbb");
            fail();         
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }     
  @Test
    public void szesc(){
        try {
            walidator = WalidatorDanychKonta.pobierzWalidator(true);
            walidator.zwalidujMail("aaa@");
            fail();         
        } catch (WalidatorDanychKontaWyjatek ex) {
            
        }
    }   
}
