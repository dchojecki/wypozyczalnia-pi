/**
 * 
 */
package wypozyczalnia.ejb.zarzadzniewypozyczeniami;

import java.util.Date;

import javax.ejb.Remote;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTOZbior;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Remote
public interface ZarzadzanieWypozyczeniami {
    public ZamowienieTOZbior pobierzZamowieniaWgCzasu(Date odd, Date doo);	
    public ZamowienieTOZbior pobierzWszystkieZamowienia();
    
    public ZamowienieTO scalDaneZamowienia(ZamowienieTO zam);
    public ZamowienieTO utworzNoweZamowienie();
	void anuluj(KontoDAO konto, PlytaDAO film);
}