/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieKontamiGlownaFabrykaDanych extends
		ZarzadzanieKontamiFabrykaDanych {
    
    @Override
    public ZarzadzanieKontamiDAO pobierzWypozyczalniaDAO() {
        return new ZarzadzanieKontamiOracleDAO();
    }
}