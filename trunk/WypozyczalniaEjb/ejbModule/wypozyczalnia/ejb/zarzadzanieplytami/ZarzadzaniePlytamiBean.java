/**
 * 
 */
package wypozyczalnia.ejb.zarzadzanieplytami;

import java.util.Collection;

import javax.ejb.Stateless;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.fabryki.TransferObjectFactory;
import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzPlytamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzPlytamiGLFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzadzaniePlytamiDAO;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless(mappedName = "ZarzadzanieKontamiBean")
public class ZarzadzaniePlytamiBean implements ZarzadzaniePlytami,
		ZarzadzaniePlytamiLocal {

	private ZarzPlytamiFabrykaDanych fabrykaDAO = new ZarzPlytamiGLFabrykaDanych();

	public FilmTOZbior zwrocListeWszystkichFilmow() {
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		Collection<FilmDAO> filmy = z.pobierzWszystkieFilmy();
		return TransferObjectFactory.stworzFilmyTO(filmy);
	}

	@Override
	public Collection<FilmDAO> zwrocListeWszystkichFilmowDAO() {
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		Collection<FilmDAO> filmy = z.pobierzWszystkieFilmy();
		return filmy;
	}

	public PlytaTOZbior zwrocListeWszystkichPlyt(FilmTO film) {
		if (film == null)
			return null;
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		Collection<PlytaDAO> plyty = z.pobierzWszystkiePlyty(film.getId());
		return TransferObjectFactory.stworzPlytyTO(plyty);
	}

	/**
	 * @return the fabrykaDAO
	 */
	public ZarzPlytamiFabrykaDanych getFabrykaDAO() {
		return fabrykaDAO;
	}

	@Override
	public void dodajPlyte(FilmTO film, PlytaTO plyta) {
		ZarzadzaniePlytamiDAO dao = getFabrykaDAO()
				.createZarzadzaniePlytamiDAO();
		FilmDAO f = dao.zwrocFilm(film.getId());
		PlytaDAO p = new PlytaDAO();
		p.setFilm(f);
		// p.setStanplyty(plyta.getStan());
		p.setUwagiDoEgzemplarza(plyta.getUwagiDoEgzemplarza());
		f.getPlyty().add(p);
		dodajPlyte(p);
	}

	@Override
	public void dodajFilm(FilmTO film) {
		FilmDAO f = new FilmDAO();
		f.setOpisFabuly(film.getOpisFabuly());
		f.setRok(film.getRokPremiery());
		f.setTytul(film.getTytul());
		dodajFilm(f);

	}

	@Override
	public void dodajFilm(FilmDAO film) {
		ZarzadzaniePlytamiDAO dao = getFabrykaDAO()
				.createZarzadzaniePlytamiDAO();
		dao.scalFilm(film);

	}

	@Override
	public void dodajPlyte(PlytaDAO plyta) {
		ZarzadzaniePlytamiDAO dao = getFabrykaDAO()
				.createZarzadzaniePlytamiDAO();
		FilmDAO f = dao.zwrocFilm(plyta.getFilm().getId());
		f.getPlyty().add(plyta);
		dao.scalFilm(f);

	}

	@Override
	public FilmDAO pobierzFilm(Integer id) {
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		FilmDAO film = z.zwrocFilm(id);
		return film;
	}

	@Override
	public PlytaDAO pobierzPlyte(String id) {
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		PlytaDAO zwrocPlyte = z.zwrocPlyte(id);
		return zwrocPlyte;
	}

	@Override
	public Collection<PlytaDAO> zwrocListeWszystkichPlytDAO(FilmDAO film) {
		if (film == null)
			return null;
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		Collection<PlytaDAO> plyty = z.pobierzWszystkiePlyty(film.getId());
		return plyty;
	}

	@Override
	public Collection<FilmDAO> zwrocListeFilmowDAO(String tytul) {
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		Collection<FilmDAO> filmy = z.zwrocFilmy(tytul);
		return filmy;
	}

}