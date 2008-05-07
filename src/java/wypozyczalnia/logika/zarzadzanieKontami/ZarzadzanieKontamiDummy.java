/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.logika.zarzadzanieKontami;

import java.util.Collection;
import java.util.HashMap;
import wypozyczalnia.dao.StanKonta;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiDummy implements ZarzadzanieKontami{
    
    private HashMap<String, KlientTO> klienci = new HashMap<String, KlientTO>();
    private HashMap<String, KontoTO> konta = new HashMap<String, KontoTO>();

    public void modyfikujDaneAdresu(AdresTO adres) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modyfikujDaneKlienta(KlientTO klient) {
        klienci.put(klient.getNrPeselKlienta(), klient);
    }

    public void modyfikujDaneKonta(KontoTO konto) {
        konta.put(konto.getNrPeselKlienta(), konto);        
    }

    public AdresTO zwrocDaneAdresu(String nrPesel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public KontoTO zwrocDaneKonta(String nrpesel) {
        return konta.get(nrpesel);
    }

    public KlientTO zwrocDaneKlienta(String nrpesel) {
        return klienci.get(nrpesel);        
    }

    public void zablokujKonto(KlientTO klient) {
        konta.get(klient.getNrPeselKlienta()).setStanKonta(StanKonta.ZABLOKOWANE);
    }

    public void odblokujKonto(KlientTO klient) {
        konta.get(klient.getNrPeselKlienta()).setStanKonta(StanKonta.NIEAKTYWNE);        
    }

    public void zmienHaslo(String nowySkrotHasla, Integer nrKonta, String starySkrotHasla) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public KontoTO zaloguj(String skrotHasla, Integer nrKonta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean czyKlientZarejestrowany(String nrPesel) {
        KlientTO klient = zwrocDaneKlienta(nrPesel);
        return (klient == null);
    }

    public void wyloguj(Integer nrKonta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public KontoTO zarejestrujKlienta(KlientTO klient, AdresTO adres) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void usunWszystkieKonta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<KontoTO> zwrocListeWszystkichKont() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void usunKonto(KontoTO konto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
