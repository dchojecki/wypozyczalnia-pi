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
import wypozyczalnia.dao.PracownikDAO;
import wypozyczalnia.dao.kontopracownika.KontoPracownikaDAO;

/**
 * 
 * @author marcin
 */
public class ZarzadzanieKontamiOracleDAO implements ZarzadzanieKontamiDAO {

	private EntityManager em;

	public ZarzadzanieKontamiOracleDAO() {
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("DerbyPU");
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ZarzadzanieKontamiOracleDAO(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public Collection<KlientDAO> zwrocListeWszystkichKlientow() {
		List<KlientDAO> klienci = em
				.createNamedQuery("zwrocWszystkichKlientow").getResultList();
		return klienci;
	}

	@SuppressWarnings("unchecked")
	public KlientDAO zwrocDaneKlienta(String nrpesel) {
		OsobaDAO klient = null;
		try {

			List lista = em.createNamedQuery("pobierzDaneKlienta")
					.setParameter("pesel", nrpesel).getResultList();
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
		em.getTransaction().begin();
		em.merge(klient);
		em.getTransaction().commit();
	}

	public KlientDAO utworzNoweKonto() {
		KlientDAO nowyKlient = new KlientDAO();
		AdresDAO nowyAdres = new AdresDAO();
		KontoDAO noweKonto = new KontoDAO();
		nowyKlient.setAdres(nowyAdres);
		noweKonto.setKlient(nowyKlient);
		nowyKlient.getKonta().add(noweKonto);

		em.getTransaction().begin();
		em.persist(nowyAdres);
		em.getTransaction().commit();
		return nowyKlient;

	}

	public void usunKonto(KlientDAO daneKlienta) {
		em.getTransaction().begin();
		em.remove(daneKlienta);
		em.getTransaction().commit();
	}

	@Override
	public PracownikDAO scalDanePracownika(PracownikDAO pracownik) {
		em.getTransaction().begin();
		em.merge(pracownik);
		em.getTransaction().commit();
		return pracownik;
	}

	@Override
	public PracownikDAO zwrocDanePracownika(String login) {
		KontoPracownikaDAO konto = (KontoPracownikaDAO) em.createNamedQuery(
				"pobierzDaneKlienta").setParameter(0, login).getSingleResult();
		return konto.getPracownik();

	}

}
