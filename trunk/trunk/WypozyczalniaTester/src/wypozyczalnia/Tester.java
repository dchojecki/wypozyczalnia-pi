/*package wypozyczalnia;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypOracleDAO;
import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytami;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

public class Tester {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs",
				"=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url", "localhost:1099");

		Context context2;
		try {
			context2 = new InitialContext(properties);
			ZarzadzanieWypozyczeniami wyp = (ZarzadzanieWypozyczeniami) context2
					.lookup("WypozyczalniaEar/ZarzadzanieWypozyczeniamiBean/remote");
			
			ZamowienieTO t = wyp.utworzNoweZamowienie();
			
			ZarzadzanieKontami konta = (ZarzadzanieKontami) context2
					.lookup("WypozyczalniaEar/ZarzadzanieKontamiBean/remote");
			
			
			ZarzadzaniePlytami plyty = (ZarzadzaniePlytami) context2
			.lookup("WypozyczalniaEar/ZarzadzaniePlytamiBean/remote");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ZarzWypOracleDAO wyp = new ZarzWypOracleDAO();
		ZamowienieDAO z = wyp.utworzNoweZamowienie();
		z.gotowe();
		wyp.scalZamowienie(z);
		System.out.println("koniec");

	}

}
*/