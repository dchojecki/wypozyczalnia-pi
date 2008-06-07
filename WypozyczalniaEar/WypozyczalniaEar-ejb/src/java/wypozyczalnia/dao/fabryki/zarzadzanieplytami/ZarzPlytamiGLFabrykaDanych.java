/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import wypozyczalnia.dao.fabryki.FactoryType;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzPlytamiGLFabrykaDanych extends ZarzPlytamiFabrykaDanych {

    private static ZarzadzaniePlytamiOracleDAOMock mock = null;
    
    public ZarzPlytamiGLFabrykaDanych() {
        setFactoryType(FactoryType.MEMORY);
    }

    @Override
    public ZarzadzaniePlytamiDAO createZarzadzaniePlytamiDAO() {

        switch (getFactoryType()) {
            case OracleDAO:
                return new ZarzPlytamiOracleDAO();

            case MEMORY:
                if (mock == null) mock = new ZarzadzaniePlytamiOracleDAOMock();
                return mock;
        }
                return null;
    }
}