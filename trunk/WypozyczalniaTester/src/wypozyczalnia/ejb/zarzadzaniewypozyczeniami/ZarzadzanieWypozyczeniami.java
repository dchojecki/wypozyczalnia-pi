package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;


import java.util.Collection;
import javax.ejb.Remote;
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
    public Collection<? extends ZamowienieTO>  pobierzZamowieniaWgCzasu();	
}