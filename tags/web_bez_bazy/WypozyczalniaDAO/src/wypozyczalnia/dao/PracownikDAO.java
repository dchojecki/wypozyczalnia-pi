/**
 * 
 */
package wypozyczalnia.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wypozyczalnia.dao.kontopracownika.KontoPracownikaDAO;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "PracownikTbl")
public class PracownikDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean administrator;
	private String imie;
	private String nazwisko;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "kontoId")
	private KontoPracownikaDAO konto = new KontoPracownikaDAO();

	public PracownikDAO(boolean administrator, String imie, String nazwisko, String login, String haslo) {
		konto.setPracownik(this); 
		konto.setLogin(login);
		konto.setHaslo(haslo);
		this.administrator = administrator;
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public PracownikDAO() {
		konto.setPracownik(this); 
	}

	public boolean czyJestAdministratorem() {
		return administrator;
	}

	/**
	 * @param administrator
	 *            the administrator to set
	 */
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	/**
	 * @param imie
	 *            the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}

	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}

	/**
	 * @param nazwisko
	 *            the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}

	/**
	 * @param konto the konto to set
	 */
	public void setKonto(KontoPracownikaDAO konto) {
		this.konto = konto;
	}

	/**
	 * @return the konto
	 */
	public KontoPracownikaDAO getKonto() {
		return konto;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
}