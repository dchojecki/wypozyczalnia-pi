/**
 * 
 */
package wypozyczalnia.dao.fabryki;

import wypozyczalnia.dao.KontoDAO;
import java.util.Set;
import wypozyczalnia.dao.KlientDAO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ZarzadzanieKontamiDAO {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrpesel
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoDAO nrKonta(String nrpesel);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param konto
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void scalDaneKonta(KontoDAO konto);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<KontoDAO> zwrocListeWszystkichKont();

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<KlientDAO> zwrocListeWszystkichKlientow();

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrpesel
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object utworzNoweKonto(String nrpesel);
}