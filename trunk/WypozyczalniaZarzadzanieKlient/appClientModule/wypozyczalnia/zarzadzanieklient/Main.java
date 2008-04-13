package wypozyczalnia.zarzadzanieklient;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import wypozyczalnia.ejb.ZarzadzanieKontami;

public class Main {
	@EJB
	private static ZarzadzanieKontami zarzadzanieKontami;
		
	public static void main(String[] args) {
		new Main().run();
	}
	
	public void run() {		
		
		 Context context;
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(zarzadzanieKontami.toString());
	
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}