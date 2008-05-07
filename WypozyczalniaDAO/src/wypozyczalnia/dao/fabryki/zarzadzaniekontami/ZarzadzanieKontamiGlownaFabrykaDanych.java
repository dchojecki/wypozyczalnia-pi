/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieKontamiGlownaFabrykaDanych extends
		ZarzadzanieKontamiFabrykaDanych {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontamiFabrykaDanych#createWypozyczalniaDAO()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontamiDAO createWypozyczalniaDAO() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontamiDAO createZarzadzanieKontamiDAO() {
		// begin-user-code

		return new ZarzadzanieKontamiOracleDAO();
		// end-user-code
	}
}