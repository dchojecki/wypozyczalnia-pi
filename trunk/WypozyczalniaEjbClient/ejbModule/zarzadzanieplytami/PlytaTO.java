package zarzadzanieplytami;

import java.io.Serializable;
import java.util.Date;

import wypozyczalnia.dao.StanPlyty;

public class PlytaTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dataNabycia = new Date();
	private String tytul = "";
	private int idFilmu = 0;
	private String uwagiDoEgzemplarza = "";
	private StanPlyty stan = StanPlyty.NIEWYPOZYCZONA;
	private String idPlyty;

	public void setDataNabycia(Date dataNabycia) {
		this.dataNabycia = dataNabycia;
	}

	public Date getDataNabycia() {
		return dataNabycia;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getTytul() {
		return tytul;
	}

	public void setIdFilmu(int idFilmu) {
		this.idFilmu = idFilmu;
	}

	public int getIdFilmu() {
		return idFilmu;
	}

	/**
	 * @param uwagiDoEgzemplarza
	 *            the uwagiDoEgzemplarza to set
	 */
	public void setUwagiDoEgzemplarza(String uwagiDoEgzemplarza) {
		this.uwagiDoEgzemplarza = uwagiDoEgzemplarza;
	}

	/**
	 * @return the uwagiDoEgzemplarza
	 */
	public String getUwagiDoEgzemplarza() {
		return uwagiDoEgzemplarza;
	}

	/**
	 * @param stan
	 *            the stan to set
	 */
	public void setStan(StanPlyty stan) {
		this.stan = stan;
	}

	/**
	 * @return the stan
	 */
	public StanPlyty getStan() {
		return stan;
	}

	/**
	 * @param idPlyty
	 *            the idPlyty to set
	 */
	public void setIdPlyty(String idPlyty) {
		this.idPlyty = idPlyty;
	}

	/**
	 * @return the idPlyty
	 */
	public String getIdPlyty() {
		return idPlyty;
	}
}
