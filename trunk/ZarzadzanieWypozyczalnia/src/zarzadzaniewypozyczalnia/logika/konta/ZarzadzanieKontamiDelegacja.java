/**
 * 
 */
package zarzadzaniewypozyczalnia.logika.konta;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import wypozyczalnia.ejb.ZarzadzanieKontami;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieKontamiDelegacja {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontami zarzadzaniekontami;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the zarzadzaniekontami
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontami getZarzadzaniekontami() {
		// begin-user-code
		return zarzadzaniekontami;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theZarzadzaniekontami the zarzadzaniekontami to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setZarzadzaniekontami(ZarzadzanieKontami theZarzadzaniekontami) {
		// begin-user-code
		zarzadzaniekontami = theZarzadzaniekontami;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontami implementor;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the implementor
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontami getImplementor() {
		// begin-user-code
		return implementor;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theImplementor the implementor to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setImplementor(ZarzadzanieKontami theImplementor) {
		// begin-user-code
		implementor = theImplementor;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static final ZarzadzanieKontamiDelegacja instance = new ZarzadzanieKontamiDelegacja();

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontamiDelegacja() {
		// begin-user-code
		 Context context;
			try {
				context = new InitialContext();
				zarzadzaniekontami = 
					(ZarzadzanieKontami)context.lookup("ZarzadzanieKontamiBean");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ZarzadzanieKontamiDelegacja getInstance() {
		// begin-user-code

		return instance;
		// end-user-code
	}
	
	public String utworzNoweKonto(String nazwisko, String imie, String pesel, String mail, String dataUrodzenia) throws ZarzadzanieKontamiWyjatek {
		
		throw new ZarzadzanieKontamiWyjatek();
	}
}