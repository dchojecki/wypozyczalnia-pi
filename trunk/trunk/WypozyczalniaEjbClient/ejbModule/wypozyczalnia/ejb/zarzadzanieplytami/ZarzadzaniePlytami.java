/**
 * 
 */
package wypozyczalnia.ejb.zarzadzanieplytami;

import javax.ejb.Remote;

import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Remote
public interface ZarzadzaniePlytami {

	FilmTOZbior zwrocListeWszystkichFilmow();

	PlytaTOZbior zwrocListeWszystkichPlyt(FilmTO film);

	void dodajFilm(FilmTO film);

	void dodajPlyte(FilmTO film, PlytaTO plyta);

}