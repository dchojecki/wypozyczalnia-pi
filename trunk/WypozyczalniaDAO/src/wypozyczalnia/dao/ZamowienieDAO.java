/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ZamowienieTbl")
@SequenceGenerator(name= "zamowienieIdSeq", sequenceName = "zamowienieIdSeq", 
initialValue = 10, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name="znajdzWszystkieZamowienia", query="select object(o) from ZamowienieDAO o"),
    @NamedQuery(name="znajdzWszystkieZamowieniaOdDo", query="select object(o) from ZamowienieDAO o where o.dataPrzyjecia >= :od and o.dataPrzyjecia <= :do")
})
public class ZamowienieDAO implements Serializable {

    @Id    
    @GeneratedValue(generator = "zamowienieIdSeq")    
    private Integer id;
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "zamowienie")
    private Set<PozycjaZamowieniaDAO> pozycje = new HashSet<PozycjaZamowieniaDAO>();

    @ManyToOne(cascade = {CascadeType.ALL})
    private KlientDAO klient;
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the pozycje
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Set<PozycjaZamowieniaDAO> getPozycje() {
        // begin-user-code
        return pozycje;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param thePozycje the pozycje to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setPozycje(Set<PozycjaZamowieniaDAO> thePozycje) {
        // begin-user-code
        pozycje = thePozycje;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.DATE)
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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRealizacji;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataRelizacji
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
     * @param theDataRelizacji the dataRelizacji to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDataRealizacji(Date theDataRelizacji) {
        // begin-user-code
        dataRealizacji = theDataRelizacji;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.DATE)
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
    @Basic
    @Enumerated(EnumType.ORDINAL)
    private StanZamowienia stanzamowienia;

    public Integer getId() {
        return id;
    }

    public StanZamowienia getStanzamowienia() {
        return stanzamowienia;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPozyczenia;

    public Date getDataPozyczenia() {
        return dataPozyczenia;
    }

    public void setDataPozyczenia(Date dataPozyczenia) {
        this.dataPozyczenia = dataPozyczenia;
    }

    public void setStanzamowienia(StanZamowienia stanzamowienia) {
        this.stanzamowienia = stanzamowienia;
    }

    public KlientDAO getKlient() {
        return klient;
    }

    public void setKlient(KlientDAO klient) {
        this.klient = klient;
    }
}
