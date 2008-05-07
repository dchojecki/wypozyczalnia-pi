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
public class KontaZbior {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<KontoDAO> konta;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the konta
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<KontoDAO> getKonta() {
		// begin-user-code
		return konta;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theKonta the konta to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setKonta(Set<KontoDAO> theKonta) {
		// begin-user-code
		konta = theKonta;
		// end-user-code
	}
}