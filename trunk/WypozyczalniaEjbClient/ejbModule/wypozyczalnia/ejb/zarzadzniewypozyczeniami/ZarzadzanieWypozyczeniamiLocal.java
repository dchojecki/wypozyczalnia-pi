/**
 * 
 */
package wypozyczalnia.ejb.zarzadzniewypozyczeniami;

import javax.ejb.Local;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Local
public interface ZarzadzanieWypozyczeniamiLocal {
	void zamow(KontoDAO konto, FilmDAO film);
}