/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzWypGLFabrykaDanych extends ZarzWypFabrykaDanych {

    @Override
    public ZarzadzanieWypozyczeniamiDAO createZarzadzanieWypozyczeniamiDAO() {
        return new ZarzWypOracleDAO();
    }
}