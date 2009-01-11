/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import java.util.Collection;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ZarzadzaniePlytamiDAO {

	Collection<FilmDAO> pobierzWszystkieFilmy();

	Collection<PlytaDAO> pobierzWszystkiePlyty(FilmDAO film);

	Collection<PlytaDAO> pobierzWszystkiePlyty(Integer filmId);

	FilmDAO zwrocFilm(Integer id);

	void scalFilm(FilmDAO film);

	PlytaDAO zwrocPlyte(String id);

	Collection<FilmDAO> zwrocFilmy(String tytul);

}