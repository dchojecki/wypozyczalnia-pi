/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typ")
@Table(name = "OsobaTbl")
public abstract class OsobaDAO implements Serializable {

    public OsobaDAO() {
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String imie;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the imie
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getImie() {
        // begin-user-code
        return imie;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theImie the imie to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setImie(String theImie) {
        // begin-user-code
        imie = theImie;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String nazwisko;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nazwisko
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getNazwisko() {
        // begin-user-code
        return nazwisko;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNazwisko the nazwisko to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNazwisko(String theNazwisko) {
        // begin-user-code
        nazwisko = theNazwisko;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String adresMailowy;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the adresMailowy
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getAdresMailowy() {
        // begin-user-code
        return adresMailowy;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theAdresMailowy the adresMailowy to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setAdresMailowy(String theAdresMailowy) {
        // begin-user-code
        adresMailowy = theAdresMailowy;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id    
    private String nrpesel;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nrpesel
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getNrpesel() {
        // begin-user-code
        return nrpesel;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNrpesel the nrpesel to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNrpesel(String theNrpesel) {
        // begin-user-code
        nrpesel = theNrpesel;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataUrodzenia;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataUrodzenia
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataUrodzenia() {
        // begin-user-code
        return dataUrodzenia;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theDataUrodzenia the dataUrodzenia to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDataUrodzenia(Date theDataUrodzenia) {
        // begin-user-code
        dataUrodzenia = theDataUrodzenia;
    // end-user-code
    }

}
