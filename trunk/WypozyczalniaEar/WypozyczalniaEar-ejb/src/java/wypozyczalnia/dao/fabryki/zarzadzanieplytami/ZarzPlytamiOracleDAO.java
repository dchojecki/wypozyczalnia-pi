/**
 *
 */
package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
public class ZarzPlytamiOracleDAO implements ZarzadzaniePlytamiDAO {

	private EntityManager em;

	public ZarzPlytamiOracleDAO() {
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("DerbyPU");
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public void scalPlyte(PlytaDAO plyta) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<PlytaDAO> pobierzWszystkiePlyty(Integer filmId) {
		List<PlytaDAO> plyty = em.createNamedQuery("zwrocListePlyt")
				.setParameter(0, filmId).getResultList();
		return plyty;
	}

	@Override
	public PlytaDAO zwrocPlyte(Integer id) {
		PlytaDAO p = (PlytaDAO) em.createNamedQuery("zwrocPlyte").setParameter(0, id).getSingleResult();
		return p;
	}
}
