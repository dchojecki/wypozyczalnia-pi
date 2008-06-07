/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import java.util.Collection;

import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PracownikDAO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ZarzadzanieKontamiDAO {

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Collection<KlientDAO> zwrocListeWszystkichKlientow();

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param nrpesel
     * @return
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    KlientDAO zwrocDaneKlienta(String nrpesel);

    void scalDaneKlienta(KlientDAO klient);

    KlientDAO utworzNoweKonto();

    void usunKonto(KlientDAO daneKlienta);
    
    
    PracownikDAO zwrocDanePracownika(String login);
    PracownikDAO scalDanePracownika(PracownikDAO pracownik);

}
