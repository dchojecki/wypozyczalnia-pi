package dbtest;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Test;

import wypozyczalnia.dao.PracownikDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAOBean;

public class HSQLTest {

	@Test
	public void test1() {
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs",
				"=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url", "localhost:1099");

		Context context2;
		try {
			context2 = new InitialContext(properties);
			ZarzadzanieKontamiDAOBean wyp = (ZarzadzanieKontamiDAOBean) context2
					.lookup("WypozyczalniaEar/ZarzadzanieKontamiOracleDAO/remote");
			
			PracownikDAO p = new PracownikDAO();
			p.setImie("marcin");
			wyp.scalDanePracownika(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
