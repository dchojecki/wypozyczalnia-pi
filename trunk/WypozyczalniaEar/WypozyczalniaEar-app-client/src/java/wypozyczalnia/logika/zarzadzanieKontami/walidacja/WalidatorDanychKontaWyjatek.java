/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.logika.zarzadzanieKontami.walidacja;

/**
 *
 * @author marcin
 */
public class WalidatorDanychKontaWyjatek extends Exception{
    private String wartosc;
    
    public WalidatorDanychKontaWyjatek(String komunikat, String wartosc)
    {
        super(komunikat);        
    }

    public String getWartosc() {
        return wartosc;
    }
    

}
