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
public class PunktDAO {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ManagerDAO manager;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the manager
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ManagerDAO getManager() {
		// begin-user-code
		return manager;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theManager the manager to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setManager(ManagerDAO theManager) {
		// begin-user-code
		manager = theManager;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<PlytaDAO> plyty;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the plyty
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<PlytaDAO> getPlyty() {
		// begin-user-code
		return plyty;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param thePlyty the plyty to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPlyty(Set<PlytaDAO> thePlyty) {
		// begin-user-code
		plyty = thePlyty;
		// end-user-code
	}
}