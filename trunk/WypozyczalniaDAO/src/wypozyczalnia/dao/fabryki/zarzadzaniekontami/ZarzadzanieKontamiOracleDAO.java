/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.OsobaDAO;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiOracleDAO implements ZarzadzanieKontamiDAO {

    private EntityManager em;

    public ZarzadzanieKontamiOracleDAO() {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("WypozyczalniaDAODerbyPU");
        em = emf.createEntityManager();

    }

    public Collection<KlientDAO> zwrocListeWszystkichKlientow() {
        List<KlientDAO> klienci = em.createNamedQuery("zwrocWszystkichKlientow").getResultList();
        return klienci;
    }

    public KlientDAO zwrocDaneKlienta(String nrpesel) {
        OsobaDAO klient = null;
        try {

            List lista = em.createNamedQuery("pobierzDaneKlienta").setParameter("pesel", nrpesel).getResultList();
            int a = lista.size();
            if (a > 0) {
                klient = (OsobaDAO) lista.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public void usunKonto(KlientDAO daneKlienta) {
        em.remove(daneKlienta);
    }

    public void startSesji() {
        em.getTransaction().begin();

    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void rollback() {
        em.getTransaction().rollback();
    }
}
