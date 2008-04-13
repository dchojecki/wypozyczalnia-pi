/**
 * 
 */
package zarzadzaniewypozyczalnia.logika.konta;

import java.security.Permission;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.NoInitialContextException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import javax.naming.spi.NamingManager;

import org.eclipse.core.internal.resources.Resource;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import wypozyczalnia.ejb.ZarzadzanieKontami;
import wypozyczalnia.ejb.jeden;
import zarzadzaniewypozyczalnia.Activator;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ZarzadzanieKontamiDelegacja {
	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontami zarzadzaniekontami;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the zarzadzaniekontami
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontami getZarzadzaniekontami() {
		// begin-user-code
		return zarzadzaniekontami;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theZarzadzaniekontami the zarzadzaniekontami to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setZarzadzaniekontami(ZarzadzanieKontami theZarzadzaniekontami) {
		// begin-user-code
		zarzadzaniekontami = theZarzadzaniekontami;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ZarzadzanieKontami implementor;

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the implementor
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ZarzadzanieKontami getImplementor() {
		// begin-user-code
		return implementor;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param theImplementor the implementor to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setImplementor(ZarzadzanieKontami theImplementor) {
		// begin-user-code
		implementor = theImplementor;
		// end-user-code
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static final ZarzadzanieKontamiDelegacja instance = new ZarzadzanieKontamiDelegacja();

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public class MySecurityManager extends SecurityManager  {
		public MySecurityManager() {
		}
		public void checkPermission() {
		}
		public void checkPermission(Permission perm) {
		}
		public void checkPermission(Permission perm, Object context) {
		}
	}
	private void initJndi(String jndiProperties) {
		try {
		Context _context = null;
		Properties props = new Properties();
		props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");			
		props.put("java.naming.provider.url", "jnp://localhost:1099")			;
//		props.put("java.naming.provider.url", "localhost")			;
		props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		_context = new InitialContext(props);
		jeden value = 
			(jeden)_context.lookup("WypozyczalniaEARJBoss/jedenImpl/remote");
		
				/*System.setProperty( "java.naming.factory.initial", "org.jboss.naming.HttpNamingContextFactory" );
				System.setProperty( "java.naming.provider.url", "http://localhost:8080/invoker/JNDIFactory" );
				Hashtable props = new Hashtable();
				props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"com.sun.enterprise.naming.SerialInitContextFactory");
				props.put(InitialContext.PROVIDER_URL,  "jnp://127.0.0.1:1099");
				NamingManager.setInitialContextFactoryBuilder(new
						SoftappInitialContextFactoryBuilder());		
				_context = new InitialContext(props); 
*/
				ZarzadzanieKontami ziarenko =  
					(ZarzadzanieKontami)_context.lookup("ZarzadzanieKontamiBean");
				ziarenko.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	/*class SoftappInitialContextFactoryBuilder implements
	InitialContextFactoryBuilder{
		public InitialContextFactory
		createInitialContextFactory(Hashtable env) throws NamingException {
			InitialContextFactory factory;
			String className = env != null ?
					(String)env.get(Context.INITIAL_CONTEXT_FACTORY) : null;
					if (className == null) {
						NoInitialContextException ne = new
						NoInitialContextException(
								"Need to specify class name in environment or system " +
								"property, or as an applet parameter, or in an " +
								"application resource file:  " +
								Context.INITIAL_CONTEXT_FACTORY);
						throw ne;
					}
					try {
						factory = (InitialContextFactory)     
						this.getClass().getClassLoader().
						loadClass(className).newInstance();
					} catch(Exception e) {
						NoInitialContextException ne =
							new NoInitialContextException(
									"Cannot instantiate class: " + className);
						ne.setRootCause(e);
						throw ne;
					}
					return factory;
		}
	}*/

	private ZarzadzanieKontamiDelegacja() {
		// begin-user-code
//		Context context;
		initJndi("");
		/*zarzadzaniekontami = 
					(ZarzadzanieKontami)context.lookup("ZarzadzanieKontamiBean");*/				
	}

	/** 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ZarzadzanieKontamiDelegacja getInstance() {
		// begin-user-code

		return instance;
		// end-user-code
	}

	public String utworzNoweKonto(String nazwisko, String imie, String pesel, String mail, String dataUrodzenia) throws ZarzadzanieKontamiWyjatek {

		throw new ZarzadzanieKontamiWyjatek();
	}
}