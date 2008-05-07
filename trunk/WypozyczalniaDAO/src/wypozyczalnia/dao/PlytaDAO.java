/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PlytaTbl")
@SequenceGenerator(name= "plytaIdSeq", sequenceName = "plytaIdSeq", 
initialValue = 10, allocationSize = 1)
public class PlytaDAO implements Serializable {

    @Id
    @GeneratedValue(generator = "plytaIdSeq")
    private Integer id;

    public PlytaDAO() {
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "filmId")
    private FilmDAO film;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the film
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public FilmDAO getFilm() {
        // begin-user-code
        return film;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theFilm the film to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setFilm(FilmDAO theFilm) {
        // begin-user-code
        film = theFilm;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String uwagiDoEgzemplarza;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the uwagiDoEgzemplarza
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getUwagiDoEgzemplarza() {
        // begin-user-code
        return uwagiDoEgzemplarza;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theUwagiDoEgzemplarza the uwagiDoEgzemplarza to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setUwagiDoEgzemplarza(String theUwagiDoEgzemplarza) {
        // begin-user-code
        uwagiDoEgzemplarza = theUwagiDoEgzemplarza;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNabycia;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataNabycia
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataNabycia() {
        // begin-user-code
        return dataNabycia;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theDataNabycia the dataNabycia to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDataNabycia(Date theDataNabycia) {
        // begin-user-code
        dataNabycia = theDataNabycia;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Basic
    @Enumerated(EnumType.ORDINAL)
    private StanPlyty stanplyty;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the stanplyty
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public StanPlyty getStanplyty() {
        // begin-user-code
        return stanplyty;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theStanplyty the stanplyty to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setStanplyty(StanPlyty theStanplyty) {
        // begin-user-code
        stanplyty = theStanplyty;
    // end-user-code
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
