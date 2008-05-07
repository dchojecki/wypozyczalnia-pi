/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "OsobaTbl")
@DiscriminatorValue("Klient")
@NamedQueries({
    @NamedQuery(name="czyKlientZarejestrowany", query="select object(o) from KlientDAO o"),
    @NamedQuery(name="pobierzDaneKlienta", query="select object(o) from KlientDAO o where o.nrpesel = :pesel")    
    
})
public class KlientDAO extends OsobaDAO implements Serializable {

    public KlientDAO() {
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "klient")
    private Set<KontoDAO> konta = new HashSet<KontoDAO>();

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the konta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Set<KontoDAO> getKonta() {
        // begin-user-code
        return konta;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theKonta the konta to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setKonta(Set<KontoDAO> theKonta) {
        // begin-user-code
        konta = theKonta;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "klient")
    private Set<ZamowienieDAO> zamowienia;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the zamowienia
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Set<ZamowienieDAO> getZamowienia() {
        // begin-user-code
        return zamowienia;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theZamowienia the zamowienia to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setZamowienia(Set<ZamowienieDAO> theZamowienia) {
        // begin-user-code
        zamowienia = theZamowienia;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Transient
    private OcenyZbior oceny;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the oceny
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public OcenyZbior getOceny() {
        // begin-user-code
        return oceny;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theOceny the oceny to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setOceny(OcenyZbior theOceny) {
        // begin-user-code
        oceny = theOceny;
    // end-user-code
    }
    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "adresId")
    private AdresDAO adres;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the adres
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public AdresDAO getAdres() {
        // begin-user-code
        return adres;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param theAdres the adres to set
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setAdres(AdresDAO theAdres) {
        // begin-user-code
        adres = theAdres;
    // end-user-code
    }

    public KontoDAO zwrocPierwszeKonto() {
        if (konta.size() > 0) {
            return konta.iterator().next();
        }

        return null;
    }
}
