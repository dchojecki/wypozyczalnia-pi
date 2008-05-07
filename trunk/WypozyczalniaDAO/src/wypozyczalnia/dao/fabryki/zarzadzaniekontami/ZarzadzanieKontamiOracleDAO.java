/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiOracleDAO implements ZarzadzanieKontamiDAO {
    @PersistenceContext(unitName = "WypozyczalniaDAOaDerbyPU")
    private EntityManager em;

    public Collection<KlientDAO> zwrocListeWszystkichKlientow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public KlientDAO zwrocDaneKlienta(String nrpesel) {
        Object klient = em.createNamedQuery("pobierzDaneKlienta").setParameter("pesel", nrpesel).
                getSingleResult();

        if (klient instanceof KlientDAO) {
            return (KlientDAO) klient;
        } else {
            return null;
        }

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void scalDaneKlienta(KlientDAO klient) {
        em.merge(klient);
    }

    public KlientDAO utworzNoweKonto() {
        KlientDAO nowyKlient = new KlientDAO();
        AdresDAO nowyAdres = new AdresDAO();
        KontoDAO noweKonto = new KontoDAO();
        nowyKlient.setAdres(nowyAdres);
        noweKonto.setKlient(nowyKlient);
        nowyKlient.getKonta().add(noweKonto);

        em.merge(nowyKlient);
        return nowyKlient;

    }
}
