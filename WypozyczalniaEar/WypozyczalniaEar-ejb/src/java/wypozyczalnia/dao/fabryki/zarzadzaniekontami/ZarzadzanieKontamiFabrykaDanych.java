/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import wypozyczalnia.dao.fabryki.FactoryType;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class ZarzadzanieKontamiFabrykaDanych {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */


	public ZarzadzanieKontamiFabrykaDanych() {
		setFactoryType(FactoryType.MEMORY);
	}

	public abstract ZarzadzanieKontamiDAO pobierzWypozyczalniaDAO();

	public FactoryType getFactoryType() {
		return factoryType;
	}

	public void setFactoryType(FactoryType aFactoryType) {
		factoryType = aFactoryType;
	}

	private FactoryType factoryType;
}