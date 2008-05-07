/**
 * 
 */
package wypozyczalnia.logika.zarzadzaniewypozyczeniami;

import java.util.Collection;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import java.util.Date;
import javax.ejb.EJB;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieWypozyczeniamiDelegacja  {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    @EJB
	private ZarzadzanieWypozyczeniami realSubject;
        

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the realSubject
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieWypozyczeniami getRealSubject() {
		// begin-user-code
		return realSubject;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theRealSubject the realSubject to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRealSubject(ZarzadzanieWypozyczeniami theRealSubject) {
		// begin-user-code
		realSubject = theRealSubject;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
        * 
	 */
                

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param _do
	 * @param od
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<ZamowienieTO> pobierzZamowieniaWgCzasu(Date odd, Date doo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return realSubject.pobierzZamowieniaWgCzasu(odd, doo);
		// end-user-code
	}
        
	public Collection<ZamowienieTO> pobierzWszystkieZamowienia() {
		// begin-user-code
		// TODO Auto-generated method stub
		return realSubject.pobierzWszystkieZamowienia();
		// end-user-code
	}
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static final ZarzadzanieWypozyczeniamiDelegacja instance = new ZarzadzanieWypozyczeniamiDelegacja();

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieWypozyczeniamiDelegacja() {
		// begin-user-code
		// TODO: Implement constructor logic
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ZarzadzanieWypozyczeniamiDelegacja getInstance() {
		// begin-user-code

		return instance;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieWypozyczeniamiDelegacja(
			ZarzadzanieWypozyczeniami realSubject) {
		// begin-user-code
		this.realSubject = realSubject;

		// end-user-code
	}
}