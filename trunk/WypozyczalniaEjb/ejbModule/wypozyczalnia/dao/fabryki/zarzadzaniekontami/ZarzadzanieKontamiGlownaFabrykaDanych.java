/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

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
	private static ZarzadzanieKontamiDAO db = null;

	@Override
	public ZarzadzanieKontamiDAO pobierzWypozyczalniaDAO() {
		switch (getFactoryType()) {
		case OracleDAO:
			if (db == null)
				initDB();
			return db;

		case MEMORY:
			if (mock == null)
				mock = new ZarzadzanieKontamiDAOMock();
			return mock;
		}
		return null;
	}

	private void initDB() {
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs",
				"=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url", "localhost:1099");

		Context context2;
		try {
			context2 = new InitialContext(properties);
			db = (ZarzadzanieKontamiDAOBean) context2
					.lookup("WypozyczalniaEar/ZarzadzanieKontamiOracleDAO/remote");
		} catch (Exception e) {
			db = null;
		}

	}
}