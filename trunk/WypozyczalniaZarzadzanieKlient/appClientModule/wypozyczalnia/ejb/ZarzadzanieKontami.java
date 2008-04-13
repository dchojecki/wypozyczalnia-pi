/**
 * 
 */
package wypozyczalnia.ejb;

import javax.ejb.Remote;

import wypozyczalnia.to.AdresTO;
import wypozyczalnia.to.KlientTO;
import wypozyczalnia.to.KontoTO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 *  
 */
@Remote
public interface ZarzadzanieKontami {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param adres
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modyfikujDaneAdresu(AdresTO adres);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param klient
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modyfikujDaneKlienta(KlientTO klient);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param konto
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modyfikujDaneKonta(KontoTO konto);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrPesel
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public AdresTO zwrocDaneAdresu(String nrPesel);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrKonta
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoTO zwrocDaneKonta(Integer nrKonta);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrpesel
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KlientTO zwrocDaneKlienta(String nrpesel);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param klient
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoTO stworzNoweKonto(KlientTO klient);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrKonta
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void zablokujKonto(Integer nrKonta);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrKonta
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void odblokujKonto(Integer nrKonta);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nowySkrotHasla
	 * @param nrKonta
	 * @param starySkrotHasla
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void zmienHaslo(String nowySkrotHasla, Integer nrKonta,
			String starySkrotHasla);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param skrotHasla
	 * @param nrKonta
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoTO zaloguj(String skrotHasla, Integer nrKonta);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrPesel
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean czyKlientZarejestrowany(Integer nrPesel);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrPesel
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KlientTO zarejestrujKlienta(String nrPesel);

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param nrKonta
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void wyloguj(Integer nrKonta);
}