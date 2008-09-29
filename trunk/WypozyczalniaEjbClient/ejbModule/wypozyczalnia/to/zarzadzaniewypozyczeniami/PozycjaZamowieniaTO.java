/**
 * 
 */
package wypozyczalnia.to.zarzadzaniewypozyczeniami;

import java.io.Serializable;

import zarzadzanieplytami.PlytaTO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PozycjaZamowieniaTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PozycjaZamowieniaTO() {
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private PlytaTO plyta;
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the tytulFilmu
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theTytulFilmu the tytulFilmu to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private Float cenaJednostkowa = 0.f;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the cenaJednostkowa
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Float getCenaJednostkowa() {
        // begin-user-code
        return cenaJednostkowa;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theCenaJednostkowa the cenaJednostkowa to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setCenaJednostkowa(Float theCenaJednostkowa) {
        // begin-user-code
        cenaJednostkowa = theCenaJednostkowa;
    // end-user-code
    }

	/**
	 * @param idPlyty the idPlyty to set
	 */
	public void setPlyta(PlytaTO idPlyty) {
		this.plyta = idPlyty;
	}

	/**
	 * @return the idPlyty
	 */
	public PlytaTO getPlyta() {
		return plyta;
	}
}
