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
public class ZarzadzaniePlytamiBean implements ZarzadzaniePlytami {

	private ZarzPlytamiFabrykaDanych fabrykaDAO = new ZarzPlytamiGLFabrykaDanych();

	public FilmTOZbior zwrocListeWszystkichFilmow() {
		ZarzadzaniePlytamiDAO z = getFabrykaDAO().createZarzadzaniePlytamiDAO();
		Collection<FilmDAO> filmy = z.pobierzWszystkieFilmy();
		return TransferObjectFactory.stworzFilmyTO(filmy);
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

}