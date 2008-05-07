/**
 * 
 */
package wypozyczalnia.to.zarzadzaniewypozyczeniami;

import java.io.Serializable;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PozycjaZamowieniaTO implements Serializable {

    public PozycjaZamowieniaTO() {
    }

    public PozycjaZamowieniaTO(PozycjaZamowieniaDAO pzD) {
        setCenaJednostkowa(pzD.getCenaJednostkowa());
        setTytulFilmu(pzD.getPlyta().getFilm().getTytul());
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private Object tytulFilmu;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the tytulFilmu
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Object getTytulFilmu() {
        // begin-user-code
        return tytulFilmu;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theTytulFilmu the tytulFilmu to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setTytulFilmu(Object theTytulFilmu) {
        // begin-user-code
        tytulFilmu = theTytulFilmu;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private Object cenaJednostkowa;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the cenaJednostkowa
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Object getCenaJednostkowa() {
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
    public void setCenaJednostkowa(Object theCenaJednostkowa) {
        // begin-user-code
        cenaJednostkowa = theCenaJednostkowa;
    // end-user-code
    }
}
