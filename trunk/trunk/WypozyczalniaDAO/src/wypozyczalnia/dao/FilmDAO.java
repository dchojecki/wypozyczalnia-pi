/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "FilmTbl")
@NamedQueries( {
		@NamedQuery(name = "zwrocListeWszystkichFilmow", query = "select object(o) from FilmDAO o"),
		@NamedQuery(name = "zwrocFilm", query = "select object(o) from FilmDAO o where o.id = :id"),
		@NamedQuery(name = "zwrocListeFilmow", query = "select object(o) from FilmDAO o where o.tytul = :tytul")

})
public class FilmDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theGatunki
	 *            the gatunki to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	@OneToMany(mappedBy = "film", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<PlytaDAO> plyty = new HashSet<PlytaDAO>();
	@OneToMany(mappedBy = "filmWolne", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<PlytaDAO> wolne = new HashSet<PlytaDAO>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the plyty
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public Set<PlytaDAO> getPlyty() {
		// begin-user-code
		return plyty;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param thePlyty
	 *            the plyty to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setPlyty(Set<PlytaDAO> thePlyty) {
		// begin-user-code
		plyty = thePlyty;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	private String tytul;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the tytul
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public String getTytul() {
		// begin-user-code
		return tytul;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theTytul
	 *            the tytul to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setTytul(String theTytul) {
		// begin-user-code
		tytul = theTytul;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	private String rok;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the rokPremiery
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public String getRok() {
		// begin-user-code
		return rok;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theRokPremiery
	 *            the rokPremiery to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setRok(String r) {
		// begin-user-code
		rok = r;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	private String opisFabuly;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the opisFabuly
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public String getOpisFabuly() {
		// begin-user-code
		return opisFabuly;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param theOpisFabuly
	 *            the opisFabuly to set
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public void setOpisFabuly(String theOpisFabuly) {
		// begin-user-code
		opisFabuly = theOpisFabuly;
		// end-user-code
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	// private OcenyZbior oceny;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the oceny
	 * @generated "UML to Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform
	 *            )"
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIleWolnych() {
		return wolne.size();
	}

	public PlytaDAO wolnyEgzemplarz() {
		if (wolne.size() > 0)
			return wolne.iterator().next();
		return null;
	}

	public void zamowPlyte(PlytaDAO plyta) {
		wolne.remove(plyta);
	}

	public Set<PlytaDAO> getWolne() {
		return wolne;
	}
}