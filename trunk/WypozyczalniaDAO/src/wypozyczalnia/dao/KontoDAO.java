/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "KontoTbl")
@SequenceGenerator(name = "kontoIdSeq", sequenceName = "kontoIdSeq", initialValue = 10, allocationSize = 1)
public class KontoDAO implements Serializable {

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private boolean wygasloHaslo;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the wygasloHaslo
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public boolean getWygasloHaslo() {
        // begin-user-code
        return wygasloHaslo;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theWygasloHaslo the wygasloHaslo to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setWygasloHaslo(boolean theWygasloHaslo) {
        // begin-user-code
        wygasloHaslo = theWygasloHaslo;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="klientId")
    private KlientDAO klient;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the klient
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KlientDAO getKlient() {
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
    public void setKlient(KlientDAO theKlient) {
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
    @Basic
    @Enumerated(EnumType.ORDINAL)
    private StanKonta stankonta;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the stankonta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public StanKonta getStankonta() {
        // begin-user-code
        return stankonta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theStankonta the stankonta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setStankonta(StanKonta theStankonta) {
        // begin-user-code
        stankonta = theStankonta;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataOstatniegoLogowania;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataUstatniegoLogowania
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataUstatniegoLogowania() {
        // begin-user-code
        return dataOstatniegoLogowania;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theDataUstatniegoLogowania the dataUstatniegoLogowania to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDataUstatniegoLogowania(Date theDataUstatniegoLogowania) {
        // begin-user-code
dataOstatniegoLogowania = theDataUstatniegoLogowania;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String skrotHasla;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the skrotHasla
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getSkrotHasla() {
        // begin-user-code
        return skrotHasla;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theSkrotHasla the skrotHasla to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSkrotHasla(String theSkrotHasla) {
        // begin-user-code
        skrotHasla = theSkrotHasla;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @GeneratedValue(generator = "kontoIdSeq")
    @Column(name = "id")
    private Integer nrKonta;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the nrKonta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Integer getNrKonta() {
        // begin-user-code
        return nrKonta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theNrKonta the nrKonta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNrKonta(Integer theNrKonta) {
        // begin-user-code
        nrKonta = theNrKonta;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataOstatniejZmianyHasla;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataOstatniejZmianyHasla
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataOstatniejZmianyHasla() {
        // begin-user-code
        return dataOstatniejZmianyHasla;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theDataOstatniejZmianyHasla the dataOstatniejZmianyHasla to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDataOstatniejZmianyHasla(Date theDataOstatniejZmianyHasla) {
        // begin-user-code
        dataOstatniejZmianyHasla = theDataOstatniejZmianyHasla;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param czas
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void ustawCzasWylogowania(Date czas) {
    // begin-user-code
    // TODO Auto-generated method stub

    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param czas
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void ustawCzasLogowania(Date czas) {
    // begin-user-code
    // TODO Auto-generated method stub

    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param skrot
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void ustawSkrotHasla(String skrot) {
    // begin-user-code
    // TODO Auto-generated method stub

    // end-user-code
    }
}
