/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "AdresTbl")
@SequenceGenerator(name = "adresIdSeq", sequenceName = "adresIdSeq", initialValue = 10, allocationSize = 1)
public class AdresDAO implements Serializable {

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @GeneratedValue(generator = "adresIdSeq")
    private Integer id;
    
    private String ulica;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the ulica
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getUlica() {
        // begin-user-code
        return ulica;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theUlica the ulica to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setUlica(String theUlica) {
        // begin-user-code
        ulica = theUlica;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String miasto;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the miasto
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getMiasto() {
        // begin-user-code
        return miasto;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theMiasto the miasto to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setMiasto(String theMiasto) {
        // begin-user-code
        miasto = theMiasto;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private Integer nrDomu;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nrDomu
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Integer getNrDomu() {
        // begin-user-code
        return nrDomu;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNrDomu the nrDomu to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNrDomu(Integer theNrDomu) {
        // begin-user-code
        nrDomu = theNrDomu;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private Integer nrMieszkania;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nrMieszkania
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Integer getNrMieszkania() {
        // begin-user-code
        return nrMieszkania;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNrMieszkania the nrMieszkania to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNrMieszkania(Integer theNrMieszkania) {
        // begin-user-code
        nrMieszkania = theNrMieszkania;
    // end-user-code
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
