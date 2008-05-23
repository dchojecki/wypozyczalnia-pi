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
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DerbyPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ZarzadzanieKontamiOracleDAO(EntityManager em) {
        this.em = em;
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

        startSesji();
        em.persist(nowyAdres);
        commit();
        return nowyKlient;

    }

    public void usunKonto(KlientDAO daneKlienta) {
        em.remove(daneKlienta);
    }

    private void startSesji() {
        em.getTransaction().begin();

    }

    private void commit() {
        em.getTransaction().commit();
    }

    private void rollback() {
        em.getTransaction().rollback();
    }
}
