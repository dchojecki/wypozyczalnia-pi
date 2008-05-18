/**
 * 
 */
package wypozyczalnia.to.zarzadzaniewypozyczeniami;

import java.io.Serializable;
import java.util.Set;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.dao.StanZamowienia;
import java.util.Date;
import wypozyczalnia.dao.ZamowienieDAO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZamowienieTO implements Serializable{

    public ZamowienieTO(ZamowienieDAO zam) {
        setDataOdbioru(zam.getDataDoOdbioru());        
        setDataPrzyjecia(zam.getDataPrzyjecia());
        setDataRealizacji(getDataRealizacji());    
        setDataPrzyjecia(zam.getDataPozyczenia());
    }

    public ZamowienieTO() {
    }
    
    
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<PozycjaZamowieniaTO> pozycjezamowienia;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the pozycjezamowienia
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Set<PozycjaZamowieniaTO> getPozycjezamowienia() {
		// begin-user-code
		return pozycjezamowienia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param thePozycjezamowienia the pozycjezamowienia to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPozycjezamowienia(
			Set<PozycjaZamowieniaTO> thePozycjezamowienia) {
		// begin-user-code
		pozycjezamowienia = thePozycjezamowienia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private float cenaSumaryczna;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the cenaSumaryczna
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public float getCenaSumaryczna() {
		// begin-user-code
		return cenaSumaryczna;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theCenaSumaryczna the cenaSumaryczna to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCenaSumaryczna(float theCenaSumaryczna) {
		// begin-user-code
		cenaSumaryczna = theCenaSumaryczna;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private KlientTO klient;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the klient
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public KlientTO getKlient() {
		// begin-user-code
		return klient;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theKlient the klient to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setKlient(KlientTO theKlient) {
		// begin-user-code
		klient = theKlient;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private StanZamowienia stanzamowienia;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the stanzamowienia
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public StanZamowienia getStanzamowienia() {
		// begin-user-code
		return stanzamowienia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theStanzamowienia the stanzamowienia to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setStanzamowienia(StanZamowienia theStanzamowienia) {
		// begin-user-code
		stanzamowienia = theStanzamowienia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date dataPrzyjecia;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the dataPrzyjecia
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getDataPrzyjecia() {
		// begin-user-code
		return dataPrzyjecia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theDataPrzyjecia the dataPrzyjecia to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDataPrzyjecia(Date theDataPrzyjecia) {
		// begin-user-code
		dataPrzyjecia = theDataPrzyjecia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date dataDoOdbioru;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the dataOdbioru
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getDataOdbioru() {
		// begin-user-code
		return dataDoOdbioru;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theDataOdbioru the dataOdbioru to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDataOdbioru(Date theDataOdbioru) {
		// begin-user-code
		dataDoOdbioru = theDataOdbioru;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date dataPozyczenia;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the dataOddania
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getDataOddania() {
		// begin-user-code
		return dataPozyczenia;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theDataOddania the dataOddania to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDataOddania(Date theDataOddania) {
		// begin-user-code
		dataPozyczenia = theDataOddania;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date dataRealizacji;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the dataRealizacji
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getDataRealizacji() {
		// begin-user-code
		return dataRealizacji;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theDataRealizacji the dataRealizacji to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDataRealizacji(Date theDataRealizacji) {
		// begin-user-code
		dataRealizacji = theDataRealizacji;
		// end-user-code
	}
}