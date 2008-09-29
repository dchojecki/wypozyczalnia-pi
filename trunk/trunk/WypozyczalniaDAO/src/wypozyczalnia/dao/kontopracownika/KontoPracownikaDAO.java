package wypozyczalnia.dao.kontopracownika;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wypozyczalnia.dao.PracownikDAO;

@Entity
@Table(name = "KontoPracownikaTbl")
@NamedQueries({
    @NamedQuery(name="pobierzDaneKontaPracownika", query="select object(o) from KontoPracownikaDAO o where o.login = :login")
})
public class KontoPracownikaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "stanId")
	private StanKontaPracownika stan = new StanNieaktywne();
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pracownikId")
	private PracownikDAO pracownik;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	private String login;
	private String haslo = "";
	private Date czasLogowania;
	private Integer licznikNieudanychProb;

	public KontoPracownikaDAO() {
		licznikNieudanychProb = 0;
	}

	public KontoPracownikaDAO(String login, String haslo, Date czasLogowania,
			PracownikDAO pracownik) {
		super();
		this.login = login;
		this.haslo = haslo;
		this.czasLogowania = czasLogowania;
		this.pracownik = pracownik;
	}

	public void loguj(String i_haslo) throws NieobsluzoneZdarzenie {
		stan.loguj(this, i_haslo);
	}

	public void wyloguj() {
		getStan().wyloguj(this);

	}

	public void zablokuj() {
		getStan().zablokuj(this);

	}

	public void odblokuj() {
		getStan().odblokuj(this);

	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setCzasLogowania(Date czasLogowania) {
		this.czasLogowania = czasLogowania;
	}

	public Date getCzasLogowania() {
		return czasLogowania;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getHaslo() {
		return haslo;
	}

	/**
	 * @param stan
	 *            the stan to set
	 */
	public void setStan(StanKontaPracownika stan) {
		this.stan = stan;
	}

	/**
	 * @return the stan
	 */
	public StanKontaPracownika getStan() {
		return stan;
	}

	public boolean hasloJestPoprawne(String i_haslo) {
		return haslo.equals(i_haslo);
	}

	/**
	 * @param pracownik
	 *            the pracownik to set
	 */
	public void setPracownik(PracownikDAO pracownik) {
		this.pracownik = pracownik;
	}

	/**
	 * @return the pracownik
	 */
	public PracownikDAO getPracownik() {
		return pracownik;
	}

	public void rejestrujCzasLogowania() {
		czasLogowania = new Date();
	}

	public void inkrementujLiczbeNieudanychProb() {
		++licznikNieudanychProb;
	}

	public void resetujLicznikBlednychProb() {
		licznikNieudanychProb = 0;
	}

	public Integer getLicznikNieudanychProb() {
		return licznikNieudanychProb;
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
