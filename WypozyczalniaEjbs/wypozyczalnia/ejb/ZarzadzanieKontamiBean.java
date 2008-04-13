/**
 * 
 */
package wypozyczalnia.ejb;

import javax.ejb.Stateless;

import wypozyczalnia.dao.fabryki.ZarzadzanieKontamiFabrykaDanych;
import wypozyczalnia.to.AdresTO;
import wypozyczalnia.to.KlientTO;
import wypozyczalnia.to.KontoTO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless(name = "ZarzadzanieKontami", mappedName="ZarzadzanieKontamiBean")
public class ZarzadzanieKontamiBean implements ZarzadzanieKontami {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontamiFabrykaDanych wypozyczalniaFabrykaDanych;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the wypozyczalniaFabrykaDanych
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontamiFabrykaDanych getWypozyczalniaFabrykaDanych() {
		// begin-user-code
		return wypozyczalniaFabrykaDanych;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theWypozyczalniaFabrykaDanych the wypozyczalniaFabrykaDanych to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setWypozyczalniaFabrykaDanych(
			ZarzadzanieKontamiFabrykaDanych theWypozyczalniaFabrykaDanych) {
		// begin-user-code
		wypozyczalniaFabrykaDanych = theWypozyczalniaFabrykaDanych;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#modyfikujDaneAdresu(AdresTO adres)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modyfikujDaneAdresu(AdresTO adres) {
		adres.setMiast("adsfasdf");
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#modyfikujDaneKlienta(KlientTO klient)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modyfikujDaneKlienta(KlientTO klient) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#modyfikujDaneKonta(KontoTO konto)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modyfikujDaneKonta(KontoTO konto) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zwrocDaneAdresu(String nrPesel)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public AdresTO zwrocDaneAdresu(String nrPesel) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zwrocDaneKonta(Integer nrKonta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoTO zwrocDaneKonta(Integer nrKonta) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zwrocDaneKlienta(String nrpesel)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KlientTO zwrocDaneKlienta(String nrpesel) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#stworzNoweKonto(KlientTO klient)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoTO stworzNoweKonto(KlientTO klient) {
		KontoTO konto = new KontoTO();
		// begin-user-code
		// TODO Auto-generated method stub
		return konto;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zablokujKonto(Integer nrKonta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void zablokujKonto(Integer nrKonta) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#odblokujKonto(Integer nrKonta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void odblokujKonto(Integer nrKonta) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zmienHaslo(String nowySkrotHasla, Integer nrKonta, String starySkrotHasla)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void zmienHaslo(String nowySkrotHasla, Integer nrKonta,
			String starySkrotHasla) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zaloguj(String skrotHasla, Integer nrKonta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KontoTO zaloguj(String skrotHasla, Integer nrKonta) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#czyKlientZarejestrowany(Integer nrPesel)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean czyKlientZarejestrowany(String nrPesel) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#zarejestrujKlienta(String nrPesel)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KlientTO zarejestrujKlienta(String nrPesel) {
		// begin-user-code
		KlientTO nowyKlient = new KlientTO();
//		nowyKlient.setNrPeselKlienta(nrPesel);
		return nowyKlient;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * (non-Javadoc)
	 * @see ZarzadzanieKontami#wyloguj(Integer nrKonta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void wyloguj(Integer nrKonta) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}