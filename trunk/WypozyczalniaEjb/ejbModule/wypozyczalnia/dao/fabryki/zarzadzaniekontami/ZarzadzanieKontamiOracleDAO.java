/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
@Stateless
public class ZarzadzanieKontamiOracleDAO implements ZarzadzanieKontamiDAOBean {

	@PersistenceContext(unitName = "wypozyczalniaPU")
	private EntityManager em;

	public ZarzadzanieKontamiOracleDAO() {
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
		List lista = em.createNamedQuery("pobierzDaneKlienta").setParameter(
				"pesel", nrpesel).getResultList();
		int a = lista.size();
		if (a > 0) {
			klient = (OsobaDAO) lista.get(0);
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

	public KlientDAO scalDaneKlienta(KlientDAO klient) {
		return em.merge(klient);
	}

	public KlientDAO utworzNoweKonto() {
		KlientDAO nowyKlient = new KlientDAO();
		AdresDAO nowyAdres = new AdresDAO();
		KontoDAO noweKonto = new KontoDAO();
		nowyKlient.setAdres(nowyAdres);
		noweKonto.setKlient(nowyKlient);
		nowyKlient.getKonta().add(noweKonto);

		em.persist(nowyAdres);
		return nowyKlient;

	}

	public void usunKonto(KlientDAO daneKlienta) {
		try {
			KlientDAO k = em.find(KlientDAO.class, daneKlienta.getNrpesel());
			em.remove(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PracownikDAO scalDanePracownika(PracownikDAO pracownik) {
		return em.merge(pracownik);
	}

	@Override
	public PracownikDAO zwrocDanePracownika(String login) {
		try {
			KontoPracownikaDAO konto = (KontoPracownikaDAO) em
					.createNamedQuery("pobierzDaneKontaPracownika")
					.setParameter("login", login).getSingleResult();

			if (konto != null) {
				return konto.getPracownik();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;

	}

	@Override
	public void usunDanePracownika(PracownikDAO pracownik) {
		try {
			PracownikDAO k = em.find(PracownikDAO.class, pracownik.getId());
			em.remove(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
