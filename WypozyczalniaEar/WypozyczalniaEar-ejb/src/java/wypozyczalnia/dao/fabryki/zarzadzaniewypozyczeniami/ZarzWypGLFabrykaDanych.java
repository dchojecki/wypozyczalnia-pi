/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami;

import wypozyczalnia.dao.fabryki.FactoryType;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzWypGLFabrykaDanych extends ZarzWypFabrykaDanych {

    private static ZarzWypOracleDAOMock mock = null;
    
    public ZarzWypGLFabrykaDanych() {
        setFactoryType(FactoryType.MEMORY);
    }

    @Override
    public ZarzadzanieWypozyczeniamiDAO createZarzadzanieWypozyczeniamiDAO() {

        switch (getFactoryType()) {
            case OracleDAO:
                return new ZarzWypOracleDAO();

            case MEMORY:
                if (mock == null) mock = new ZarzWypOracleDAOMock();
                return mock;
        }
                return null;
    }
}