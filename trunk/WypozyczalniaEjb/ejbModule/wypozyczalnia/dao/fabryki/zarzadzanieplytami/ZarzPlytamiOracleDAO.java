/**
 *
 */
package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless
public class ZarzPlytamiOracleDAO implements ZarzadzaniePlytamiDAOBean {

	@PersistenceContext(unitName="wypozyczalniaPU")
	private EntityManager em;

	public ZarzPlytamiOracleDAO() {
	}

	public ZarzPlytamiOracleDAO(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityMangerMock(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<FilmDAO> pobierzWszystkieFilmy() {
		List<FilmDAO> filmy = em.createNamedQuery("zwrocListeWszystkichFilmow")
				.getResultList();
		return filmy;
	}

	@Override
	public Collection<PlytaDAO> pobierzWszystkiePlyty(FilmDAO film) {
		return pobierzWszystkiePlyty(film.getId());
	}

	@Override
	public void scalFilm(FilmDAO film) {
		em.merge(film);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<PlytaDAO> pobierzWszystkiePlyty(Integer filmId) {
		List<PlytaDAO> plyty = em.createNamedQuery("zwrocListePlyt")
				.setParameter("id", filmId).getResultList();
		return plyty;
	}

	@Override
	public PlytaDAO zwrocPlyte(Integer id) {
		PlytaDAO p = (PlytaDAO) em.createNamedQuery("zwrocPlyte").setParameter("id", id).getSingleResult();
		return p;
	}

	@Override
	public FilmDAO zwrocFilm(Integer id) {
		FilmDAO p = (FilmDAO) em.createNamedQuery("zwrocFilm").setParameter("id", id).getSingleResult();
		return p;
	}
}
