package wypozyczalniaklient;
// test
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import wypozyczalnia.ejb.zarzadzaniekontami.ZarzadzanieKontami;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytami;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.plyty.ZarzadzaniePlytamiDelegacja;
import wypozyczalniaklient.delegacje.wypozyczenia.ZarzadzanieWypozyczeniamiDelegacja;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "WypozyczalniaKlient";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs",
				"=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url", "localhost:1099");

		Context context2;
		try {
/*			try {
				ApplicationContext appCont = new ClassPathXmlApplicationContext(
						"lib/jndibeans.xml");
				ZarzadzanieKontami za = (ZarzadzanieKontami) appCont
						.getBean("ZarzadzanieKontami");
				System.out.println(za.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			context2 = new InitialContext(properties);

			ZarzadzanieWypozyczeniami wyp = (ZarzadzanieWypozyczeniami) context2
					.lookup("WypozyczalniaEar/ZarzadzanieWypozyczeniamiBean/remote");

			ZarzadzanieWypozyczeniamiDelegacja.getInstance()
					.setRealSubject(wyp);

			ZarzadzanieKontami konta = (ZarzadzanieKontami) context2
					.lookup("WypozyczalniaEar/ZarzadzanieKontamiBean/remote");
			ZarzadzanieKontamiDelegacja.setZarzadzanieKontami(konta);

			ZarzadzaniePlytami plyty = (ZarzadzaniePlytami) context2
					.lookup("WypozyczalniaEar/ZarzadzaniePlytamiBean/remote");

			ZarzadzaniePlytamiDelegacja.setZarzadzanieKontami(plyty);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
