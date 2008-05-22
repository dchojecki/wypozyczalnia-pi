/**
 *
 */
package wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import wypozyczalnia.dao.ZamowienieDAO;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 *
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzWypOracleDAO implements ZarzadzanieWypozyczeniamiDAO {
    
    private EntityManager em;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#utworzNoweZamowienie()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ZamowienieDAO utworzNoweZamowienie() {
        ZamowienieDAO z = new ZamowienieDAO();
        em.getTransaction().begin();
        em.persist(z);
        em.getTransaction().commit();
        return z;
    }
    
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#pobierzZamowienie()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ZamowienieDAO pobierzZamowienie() {
        // begin-user-code
        // TODO Auto-generated method stub
        return null;
        // end-user-code
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#scalZamowienie()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void scalZamowienie(ZamowienieDAO zamowienie) {
        em.merge(zamowienie);
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#pobierzWszystkieZamowienia()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Collection<? extends ZamowienieDAO> pobierzWszystkieZamowienia() {
        List<ZamowienieDAO> zamowienia =
                em.createNamedQuery("znajdzWszystkieZamowienia").getResultList();
        return zamowienia;
        
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#pobierzWszystkieZamowieniaOdDo()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Collection<? extends ZamowienieDAO> pobierzWszystkieZamowieniaOdDo(Date odd, Date ddo) {
        List<ZamowienieDAO> zamowienia =
                em.createNamedQuery("znajdzWszystkieOdDo").
                setParameter("od", odd).setParameter("do", ddo).
                getResultList();
        return zamowienia;
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ZarzWypOracleDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DerbyPU");
        em = emf.createEntityManager();
        
    }
    
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
