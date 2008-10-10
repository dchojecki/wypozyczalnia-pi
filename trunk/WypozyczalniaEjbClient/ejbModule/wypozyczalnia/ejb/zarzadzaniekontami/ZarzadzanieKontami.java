/**
 * 
 */
package wypozyczalnia.ejb.zarzadzaniekontami;

import javax.ejb.Remote;

import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTOZbior;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Remote
public interface ZarzadzanieKontami {

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param adres
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void modyfikujDaneAdresu(AdresTO adres);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param klient
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void modyfikujDaneKlienta(KlientTO klient);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param konto
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void modyfikujDaneKonta(KontoTO konto);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrPesel
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public AdresTO zwrocDaneAdresu(String nrPesel);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrKonta
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KontoTO zwrocDaneKonta(String nrpesel);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrpesel
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KlientTO zwrocDaneKlienta(String nrpesel);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrKonta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void zablokujKonto(KlientTO klient);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrKonta
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void odblokujKonto(KlientTO klient);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nowySkrotHasla
     * @param nrKonta
     * @param starySkrotHasla
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void zmienHaslo(String nowySkrotHasla, Integer nrKonta,
            String starySkrotHasla);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param skrotHasla
     * @param nrKonta
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KontoPracownikaTO zaloguj(String login, String haslo) throws LogowanieWyjatek;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrPesel
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public boolean czyKlientZarejestrowany(String nrPesel);

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrKonta
     * @throws LogowanieWyjatek 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KontoPracownikaTO wyloguj(String login) throws LogowanieWyjatek;

    public KontoTO zarejestrujKlienta(KlientTO klient, AdresTO adres);

    void usunWszystkieKonta();
    
    KontoTOZbior zwrocListeWszystkichKont();

    void usunKonto(KontoTO konto);
    
    void dodajPracownika(String imie, String nazwisko, String login, String haslo, boolean administrator);
    
    KontoPracownikaTO zwrocDanePracownika(String login);
}
