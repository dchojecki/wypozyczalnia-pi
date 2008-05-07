/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "PozycjaZamowieniaTbl")
@SequenceGenerator(name = "pZamowieniaIdSeq", sequenceName = "pozycjaZamowieniaIdSeq", initialValue = 10, allocationSize = 1)
public class PozycjaZamowieniaDAO implements Serializable {

    public PozycjaZamowieniaDAO() {
    }
    @Id
    @GeneratedValue(generator = "pZamowieniaIdSeq")    
    private Integer id;
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "plytaId")
    private PlytaDAO plyta;
    @ManyToOne
    @JoinColumn(name = "zamowienieId")
    private ZamowienieDAO zamowienie;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the plyta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public PlytaDAO getPlyta() {
        // begin-user-code
        return plyta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param thePlyta the plyta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setPlyta(PlytaDAO thePlyta) {
        // begin-user-code
        plyta = thePlyta;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private float cenaJednostkowa;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the cenaJednostkowa
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public float getCenaJednostkowa() {
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
    public void setCenaJednostkowa(float theCenaJednostkowa) {
        // begin-user-code
        cenaJednostkowa = theCenaJednostkowa;
    // end-user-code
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZamowienieDAO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDAO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
