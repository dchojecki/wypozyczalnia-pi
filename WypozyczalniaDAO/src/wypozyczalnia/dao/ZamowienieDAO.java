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

import static wypozyczalnia.dao.StanZamowienia.*;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "ZamowienieTbl")
@SequenceGenerator(name = "zamowienieIdSeq", sequenceName = "zamowienieIdSeq",
initialValue = 10, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "znajdzWszystkieZamowienia", query = "select object(o) from ZamowienieDAO o"),
    @NamedQuery(name = "znajdzWszystkieZamowieniaOdDo", query = "select object(o) from ZamowienieDAO o where o.dataPrzyjecia >= :od and o.dataPrzyjecia <= :do")
})
public class ZamowienieDAO implements Serializable {

    public ZamowienieDAO() {
        setStanzamowienia(PRZYJETE);
    }
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
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
    private void setDataPrzyjecia() {
       dataPrzyjecia = new Date();
    }

    private void setDataDoOdbioru() {
        dataDoOdbioru = new Date();
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
    private void setDataRealizacji() {
        dataRealizacji = new Date();
    }
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataZalegle;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataRelizacji
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataZalegle() {
        // begin-user-code        
        return dataZalegle;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theDataRelizacji the dataRelizacji to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private void setDataZalegle() {
        dataZalegle = new Date();
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDoOdbioru;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataOdbioru
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataDoOdbioru() {
        // begin-user-code            
        return dataDoOdbioru;
    // end-user-code
    }
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAnulowania;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the dataOdbioru
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Date getDataAnulowania() {
        // begin-user-code            
        return dataAnulowania;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theDataOdbioru the dataOdbioru to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private void setDataAnulowania() {
        dataAnulowania = new Date();
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
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataPozyczenia;

    public Date getDataPozyczenia() {
        return dataPozyczenia;
    }

    private void setDataPozyczenia() {
        dataPozyczenia = new Date();
    }

    public void setStanzamowienia(StanZamowienia stanzamowienia) {
        this.stanzamowienia = stanzamowienia;

        switch (stanzamowienia) {
            case ANULOWANE:
                setDataAnulowania();
                break;
            case DOODBIORU:
                setDataDoOdbioru();
                zarezerwujPlyty();
                break;
            case POZYCZONE:
                setDataPozyczenia();
                pozyczPlyty();
                break;
            case PRZYJETE:
                setDataPrzyjecia();
                break;
            case ZALEGLE:
                setDataZalegle();
                break;
            case ZREALIZOWANE:
                setDataRealizacji();
                oddajPlyty();
                break;
        }
    }

    public KlientDAO getKlient() {
        return klient;
    }

    public void setKlient(KlientDAO klient) {
        this.klient = klient;
    }

    public void gotowe() {
        if (getStanzamowienia() != StanZamowienia.PRZYJETE) {
            throw new IllegalArgumentException();
        }
        setStanzamowienia(StanZamowienia.DOODBIORU);
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void odebrane() {

        if (getStanzamowienia() != StanZamowienia.DOODBIORU) {
            throw new IllegalArgumentException();
        }
        setStanzamowienia(StanZamowienia.POZYCZONE);
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void anuluj() {
        if (getStanzamowienia() != StanZamowienia.DOODBIORU && getStanzamowienia() != StanZamowienia.PRZYJETE) {
            throw new IllegalArgumentException();
        }
        if (getStanzamowienia() == StanZamowienia.DOODBIORU) {
            anulujRezerwacjePlyt();
        }
        setStanzamowienia(stanzamowienia.ANULOWANE);

    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void oddane() {
        if (getStanzamowienia() != StanZamowienia.POZYCZONE) {
            throw new IllegalArgumentException();
        }
        setStanzamowienia(StanZamowienia.ZREALIZOWANE);
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void uregulowano() {
        if (getStanzamowienia() != StanZamowienia.ZALEGLE) {
            throw new IllegalArgumentException();
        }
        setStanzamowienia(StanZamowienia.ZREALIZOWANE);
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void sprawdzCzyZalegle() {
        setStanzamowienia(ZALEGLE);// TODO

    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private void zarezerwujPlyty() {
        for (PozycjaZamowieniaDAO p : pozycje) {
            p.getPlyta().rezerwuj();
        }

    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private void anulujRezerwacjePlyt() {
        for (PozycjaZamowieniaDAO p : pozycje) {
            p.getPlyta().anulujRezerwacje();
        }
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private void pozyczPlyty() {
        for (PozycjaZamowieniaDAO p : pozycje) {
            p.getPlyta().wypozycz();
        }
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private void oddajPlyty() {
        for (PozycjaZamowieniaDAO p : pozycje) {
            p.getPlyta().zwroc();
        }
    }
}
