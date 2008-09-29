/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalniaklient.delegacje.konta.walidacja;

/**
 * 
 * @author marcin
 */
public class WalidatorDanychKontaWyjatek extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1319537050185154438L;
	private String wartosc;

	public WalidatorDanychKontaWyjatek(String komunikat, String wartosc) {
		super(komunikat);
	}

	public String getWartosc() {
		return wartosc;
	}

}
