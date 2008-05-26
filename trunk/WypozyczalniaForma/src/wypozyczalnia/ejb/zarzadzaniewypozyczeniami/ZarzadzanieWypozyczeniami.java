/**
 * 
 */
package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import java.util.Collection;
import java.util.Date;
import javax.ejb.Remote;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Remote
public interface ZarzadzanieWypozyczeniami {
    public Collection<ZamowienieTO>  pobierzZamowieniaWgCzasu(Date odd, Date doo);	
    public Collection<ZamowienieTO>  pobierzZamowieniaWgStanu(Date odd, Date doo, String stan);	
    public Collection<ZamowienieTO>  pobierzWszystkieZamowienia();
    public void setStan(int nr, StanZamowienia theStanZamowienia);
    public void initialize();
}