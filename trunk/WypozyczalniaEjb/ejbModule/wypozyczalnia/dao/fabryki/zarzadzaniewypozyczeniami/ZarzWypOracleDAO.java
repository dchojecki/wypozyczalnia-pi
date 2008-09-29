/**
 *
 */
package wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wypozyczalnia.dao.ZamowienieDAO;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 *
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless
public class ZarzWypOracleDAO implements ZarzadzanieWypozyczeniamiDAOBean {

	@PersistenceContext(unitName="wypozyczalniaPU")
    private EntityManager em;

    public ZamowienieDAO utworzNoweZamowienie() {
        ZamowienieDAO z = new ZamowienieDAO();
        em.persist(z);
        return z;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#pobierzZamowienie()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ZamowienieDAO pobierzZamowienie(Integer id) {
        ZamowienieDAO ret;
        try {
            ret = em.find(ZamowienieDAO.class, id);
        } catch (Exception e) {
            ret = null;
        }
        // begin-user-code
        // TODO Auto-generated method stub
        return ret;
    // end-user-code
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#scalZamowienie()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public ZamowienieDAO scalZamowienie(ZamowienieDAO zamowienie) {        
        return em.merge(zamowienie);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * (non-Javadoc)
     * @see ZarzadzanieWypozyczeniamiDAO#pobierzWszystkieZamowienia()
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
	public Collection<? extends ZamowienieDAO> pobierzWszystkieZamowieniaOdDo(Date odd, Date ddo) {
        List<ZamowienieDAO> zamowienia =
                em.createNamedQuery("znajdzWszystkieZamowieniaOdDo").
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
    }

    public ZarzWypOracleDAO(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityMangerMock(EntityManager em) {
        this.em = em;
    }
}
