package zarzadzanieplytami;

import java.io.Serializable;

public class FilmTO implements Serializable {

	public FilmTO() {
		// TODO Auto-generated constructor stub
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getTytul() {
		return tytul;
	}

	public void setOpisFabuly(String opisFabuly) {
		this.opisFabuly = opisFabuly;
	}

	public String getOpisFabuly() {
		return opisFabuly;
	}

	public void setRokPremiery(String rokPremiery) {
		this.rokPremiery = rokPremiery;
	}

	public String getRokPremiery() {
		return rokPremiery;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private String tytul = "";
	private String opisFabuly = "";
	private String rokPremiery;

}
