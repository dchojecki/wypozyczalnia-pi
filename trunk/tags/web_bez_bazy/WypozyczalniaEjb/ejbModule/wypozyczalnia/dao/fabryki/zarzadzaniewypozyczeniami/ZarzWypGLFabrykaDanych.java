/**
 * 
 */
package wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import wypozyczalnia.dao.fabryki.FactoryType;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzWypGLFabrykaDanych extends ZarzWypFabrykaDanych {

	private static ZarzadzanieWypozyczeniamiDAOBean db = null;
	private static ZarzWypOracleDAOMock mock = null;

	public ZarzWypGLFabrykaDanych() {
		setFactoryType(FactoryType.OracleDAO);
	}

	@Override
	public ZarzadzanieWypozyczeniamiDAO createZarzadzanieWypozyczeniamiDAO() {

		switch (getFactoryType()) {
		case OracleDAO:
			if (db == null)
				initDB();
			return db;

		case MEMORY:
			if (mock == null)
				mock = new ZarzWypOracleDAOMock();
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
			db = (ZarzadzanieWypozyczeniamiDAOBean) context2
					.lookup("WypozyczalniaEar/ZarzWypOracleDAO/remote");
		} catch (Exception e) {
			db = null;
		}

	}
}