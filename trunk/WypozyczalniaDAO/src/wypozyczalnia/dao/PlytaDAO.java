/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import wypozyczalnia.dao.plyty.PlytaWolna;
import wypozyczalnia.dao.plyty.StanPlyty;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "PlytaTbl")
@NamedQueries( {
		@NamedQuery(name = "zwrocListePlyt", query = "select object(o) from PlytaDAO o where o.id = :id"),
		@NamedQuery(name = "zwrocPlyte", query = "select object(o) from PlytaDAO o where o.id = :id") })
public class PlytaDAO implements Serializable {

	/**
	 * 
	 */
	private KontoDAO pozyczona, zamowiona;
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "stanId")
	private StanPlyty stan;

	public PlytaDAO() {
		setStan(new PlytaWolna());
	}

	public void setStan(StanPlyty s) {
		stan = s;
	}

	public StanPlyty getStan() {
		return stan;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "filmId")
	private FilmDAO film;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "filmWolne")
	private FilmDAO filmWolne;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the film
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public FilmDAO getFilm() {
		// begin-user-code
		return film;
		// end-user-code
	}

	public String getRok() {
		return film.getRok();
	}

	public int getIleWolnych() {
		return film.getIleWolnych();
	}

	public String getTytul() {
		return film.getTytul();
	}

	public String getOpisFabuly() {
		return film.getOpisFabuly();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theFilm
	 *            the film to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setFilm(FilmDAO theFilm) {
		// begin-user-code
		film = theFilm;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	private String uwagiDoEgzemplarza;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the uwagiDoEgzemplarza
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public String getUwagiDoEgzemplarza() {
		// begin-user-code
		return uwagiDoEgzemplarza;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theUwagiDoEgzemplarza
	 *            the uwagiDoEgzemplarza to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setUwagiDoEgzemplarza(String theUwagiDoEgzemplarza) {
		// begin-user-code
		uwagiDoEgzemplarza = theUwagiDoEgzemplarza;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataNabycia;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the dataNabycia
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public Date getDataNabycia() {
		// begin-user-code
		return dataNabycia;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theDataNabycia
	 *            the dataNabycia to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	private void setDataNabycia() {
		// begin-user-code
		dataNabycia = new Date();
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void gotowa() {
		// if (getStanplyty() != WDRODZE) {
		// throw new IllegalArgumentException("zly stan poczatkowy");
		// }
		// setStanplyty(NIEWYPOZYCZONA);
		//
		// setDataNabycia();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void rezerwuj() {
		// if (getStanplyty() != NIEWYPOZYCZONA) {
		// throw new IllegalArgumentException("zly stan poczatkowy");
		// }
		// setStanplyty(ZAREZERWOWANA);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void wypozycz() {
		// if (getStanplyty() != ZAREZERWOWANA) {
		// throw new IllegalArgumentException("zly stan poczatkowy");
		// }
		// setStanplyty(WYPOZYCZONA);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void zwroc() {
		// if (getStanplyty() != WYPOZYCZONA) {
		// throw new IllegalArgumentException("zly stan poczatkowy");
		// }
		// setStanplyty(NIEWYPOZYCZONA);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setPozyczona(KontoDAO pozyczona) {
		this.pozyczona = pozyczona;
	}

	public KontoDAO getPozyczona() {
		return pozyczona;
	}

	public void setZamowiona(KontoDAO zamowiona) {
		this.zamowiona = zamowiona;
	}

	public KontoDAO getZamowiona() {
		return zamowiona;
	}

	public void setFilmWolne(FilmDAO filmWolne) {
		this.filmWolne = filmWolne;
	}

	public FilmDAO getFilmWolne() {
		return filmWolne;
	}

}
