/**
 * 
 */
package wypozyczalnia.ejb.zarzadzaniekontami;

import java.util.Collection;
import java.util.LinkedList;
import javax.ejb.Stateless;
import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.StanKonta;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiGlownaFabrykaDanych;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless(mappedName = "ZarzadzanieKontamiBean")
public class ZarzadzanieKontamiBean implements ZarzadzanieKontami, ZarzadzanieKontamiLocal {

    private ZarzadzanieKontamiFabrykaDanych fabrykaDAO =
            new ZarzadzanieKontamiGlownaFabrykaDanych();

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#modyfikujDaneAdresu(AdresTO adres)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void modyfikujDaneAdresu(AdresTO adres) {
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#modyfikujDaneKlienta(KlientTO klient)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void modyfikujDaneKlienta(KlientTO klient) {
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#modyfikujDaneKonta(KontoTO konto)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void modyfikujDaneKonta(KontoTO konto) {
        // begin-user-code
        // TODO Auto-generated method stub

        // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zwrocDaneAdresu(String nrPesel)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public AdresTO zwrocDaneAdresu(String nrPesel) {
        // begin-user-code
        // TODO Auto-generated method stub
        return null;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zwrocDaneKonta(Integer nrKonta)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KontoTO zwrocDaneKonta(String nrpesel) {
        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        KlientDAO klient = dao.zwrocDaneKlienta(nrpesel);
        KontoTO ret = new KontoTO();
        // TODO
        return ret;
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zwrocDaneKlienta(String nrpesel)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KlientTO zwrocDaneKlienta(String nrpesel) {
        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        KlientDAO klient = dao.zwrocDaneKlienta(nrpesel);
        KlientTO ret = new KlientTO();
        // TODO
        return ret;
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zablokujKonto(Integer nrKonta)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void zablokujKonto(KlientTO klient) {
        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        KlientDAO k = dao.zwrocDaneKlienta(klient.getNrPeselKlienta());
        KontoDAO konto = k.zwrocPierwszeKonto();

        StanKonta stan = konto.getStankonta();

        if (stan == StanKonta.AKTYWNE || stan == StanKonta.WYGASLO_HASLO) {
            // nic
        } else {
            konto.setStankonta(StanKonta.ZABLOKOWANE);
            dao.scalDaneKlienta(k);
        }

    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#odblokujKonto(Integer nrKonta)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void odblokujKonto(KlientTO klient) {
        // begin-user-code
        // TODO Auto-generated method stub

        // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zmienHaslo(String nowySkrotHasla, Integer nrKonta, String starySkrotHasla)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void zmienHaslo(String nowySkrotHasla, Integer nrKonta,
            String starySkrotHasla) {
        // begin-user-code
        // TODO Auto-generated method stub

        // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zaloguj(String skrotHasla, Integer nrKonta)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KontoTO zaloguj(String skrotHasla, Integer nrKonta) {
        // begin-user-code
        // TODO Auto-generated method stub
        return null;
    // end-user-code
    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#czyKlientZarejestrowany(Integer nrPesel)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public boolean czyKlientZarejestrowany(String nrPesel) {
        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        KlientDAO k = dao.zwrocDaneKlienta(nrPesel);
        if (k == null) {
            return false;
        } else {
            return true;
        }

    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#zarejestrujKlienta(String nrPesel)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public KontoTO zarejestrujKlienta(KlientTO klient, AdresTO adres) {

        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        KlientDAO nowyKlient = dao.utworzNoweKonto();

        nowyKlient.setImie(klient.getImie());
        nowyKlient.setNazwisko(klient.getNazwisko());
        nowyKlient.setAdresMailowy(klient.getAdresMailowy());
        nowyKlient.setDataUrodzenia(klient.getDataUrodzenia());
        nowyKlient.setNrpesel(klient.getNrPeselKlienta());

        AdresDAO nowyAdres = nowyKlient.getAdres();
        nowyAdres.setMiasto(adres.getMiast());
        nowyAdres.setNrDomu(adres.getNrDomu());
        nowyAdres.setNrMieszkania(adres.getNrMieszkania());

        //       dao.startSesji();
        dao.scalDaneKlienta(nowyKlient);
        //     dao.commit();
        KontoTO retKonto = new KontoTO();
        // TODO
        return retKonto;

    }

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieKontami#wyloguj(Integer nrKonta)
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void wyloguj(Integer nrKonta) {
        // begin-user-code
        // TODO Auto-generated method stub

        // end-user-code
    }

    public void usunWszystkieKonta() {
        try {
            ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
            Collection<KlientDAO> klienci = dao.zwrocListeWszystkichKlientow();

            for (KlientDAO k : klienci) {
                dao.usunKonto(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Collection<KontoTO> zwrocListeWszystkichKont() {
        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        Collection<KlientDAO> klienci = dao.zwrocListeWszystkichKlientow();
        Collection<KontoTO> ret = new LinkedList<KontoTO>();

        for (KlientDAO k : klienci) {
            ret.add(new KontoTO());
        // TODO
        }

        return ret;

    }

    public void usunKonto(KontoTO konto) {
        ZarzadzanieKontamiDAO dao = getFabrykaDAO().pobierzWypozyczalniaDAO();
        KlientDAO klient = dao.zwrocDaneKlienta(konto.getNrPeselKlienta());
        dao.usunKonto(klient);
    }

    public ZarzadzanieKontamiFabrykaDanych getFabrykaDAO() {
        return fabrykaDAO;
    }

    public void setFabrykaDAO(ZarzadzanieKontamiFabrykaDanych fabrykaDAO) {
        this.fabrykaDAO = fabrykaDAO;
    }
}
