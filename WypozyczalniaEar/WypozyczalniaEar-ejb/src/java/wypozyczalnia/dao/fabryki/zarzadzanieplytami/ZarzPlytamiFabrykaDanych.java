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
public abstract class ZarzPlytamiFabrykaDanych {

    public FactoryType getFactoryType() {
        return factoryType;
    }

    public void setFactoryType(FactoryType aFactoryType) {
        factoryType = aFactoryType;
    }
    private FactoryType factoryType;

    /** 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public abstract ZarzadzaniePlytamiDAO createZarzadzaniePlytamiDAO();
}