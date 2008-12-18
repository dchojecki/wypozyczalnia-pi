package core;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.ejb.Stateful;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.FilmyFactory;
import wypozyczalnia.dao.KontaFactory;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.managers.ZarzadzajKontami;
import wypozyczalnia.managers.ZarzadzajZamowieniami;

@Stateful
public class Sesja {
	private String name;
	private Integer id;
	
	KontaFactory konta = new KontaFactory();
	FilmyFactory filmy = new FilmyFactory();
	KontoDAO zalogowany;
	

	public Sesja() {
//		zalogowany = KontaFactory.getKonto("jasiu");
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void zamow(Integer id) {
		if (czyZalogowany()) {
			ZarzadzajZamowieniami manager = new ZarzadzajZamowieniami();
			manager.zamow(zalogowany.getLogin(), id);
		}
	}
	
	public Collection<FilmDAO> zamowioneFilmy() {
		if (czyZalogowany()) {
			Collection<PlytaDAO> ps = zalogowany.getZamowione();
			HashSet<FilmDAO> fs = new HashSet<FilmDAO>();
			for (PlytaDAO p : ps) {
				fs.add(p.getFilm());
			}
			return fs;
		}
		return new HashSet<FilmDAO>();
	}
	
	public boolean czyZalogowany() {
		return zalogowany != null;
	}

	public void zaloguj(String login, String haslo) {
		ZarzadzajKontami manager = new ZarzadzajKontami();
		zalogowany = manager.zaloguj(login, haslo);
	}
}
