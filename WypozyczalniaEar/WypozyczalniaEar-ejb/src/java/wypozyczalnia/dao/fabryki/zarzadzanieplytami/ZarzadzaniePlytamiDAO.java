/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import java.util.Collection;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ZarzadzaniePlytamiDAO {
	
	public void scalPlyte(PlytaDAO plyta);
	public Collection<FilmDAO> pobierzWszystkieFilmy();
	public Collection<PlytaDAO> pobierzWszystkiePlyty(FilmDAO film);
	public Collection<PlytaDAO> pobierzWszystkiePlyty(Integer filmId);
	
	public PlytaDAO zwrocPlyte(Integer id);

}