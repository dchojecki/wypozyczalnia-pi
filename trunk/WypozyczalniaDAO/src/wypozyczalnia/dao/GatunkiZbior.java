/**
 * 
 */
package wypozyczalnia.dao;

import java.util.Set;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GatunkiZbior {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<GatunekDAO> gatunki;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the gatunki
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<GatunekDAO> getGatunki() {
		// begin-user-code
		return gatunki;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theGatunki the gatunki to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setGatunki(Set<GatunekDAO> theGatunki) {
		// begin-user-code
		gatunki = theGatunki;
		// end-user-code
	}
}