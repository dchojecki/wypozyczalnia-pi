/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;



/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieKontamiGlownaFabrykaDanych extends
		ZarzadzanieKontamiFabrykaDanych {
	private static ZarzadzanieKontamiDAOMock mock = null;

	@Override
	public ZarzadzanieKontamiDAO pobierzWypozyczalniaDAO() {
		switch (getFactoryType()) {
		case OracleDAO:
			return new ZarzadzanieKontamiOracleDAO();

		case MEMORY:
			if (mock == null)
				mock = new ZarzadzanieKontamiDAOMock();
			return mock;
		}
		return null;
	}
}