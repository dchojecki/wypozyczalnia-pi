package core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateful;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.daots.FilmyFactory;
import wypozyczalnia.daots.KontaFactory;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytamiLocal;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniamiLocal;
import wypozyczalnia.managers.ZarzadzajKontami;

@Stateful
public class Sesja {
	private String name;
	private Integer id;

	private ZarzadzaniePlytamiLocal plytyMgr;
	private ZarzadzanieWypozyczeniamiLocal zamowieniaMgr;
	KontaFactory konta = new KontaFactory();
	private FilmyFactory filmy;
	KontoDAO zalogowany;

	public Sesja() {
		// zalogowany = KontaFactory.getKonto("jasiu");
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
			FilmDAO film = plytyMgr.pobierzFilm(id);
			zamowieniaMgr.zamow(zalogowany, film);
		}
	}

	public void anuluj(String id) {
		if (czyZalogowany()) {
			PlytaDAO plyta = plytyMgr.pobierzPlyte(id);
			zamowieniaMgr.anuluj(zalogowany, plyta);
		}
	}

	public Collection<PlytaDAO> zamowionePlyty() {
		if (czyZalogowany()) {
			Set<ZamowienieDAO> zamowienia = zalogowany.getZamowienia();
			HashSet<PlytaDAO> ps = new HashSet<PlytaDAO>();
			for (ZamowienieDAO z : zamowienia) {
				Set<PozycjaZamowieniaDAO> pozycje = z.getPozycje();
				for (PozycjaZamowieniaDAO pz : pozycje) {
					ps.add(pz.getPlyta());
				}
			}

			return ps;
		}
		return new HashSet<PlytaDAO>();
	}

	public boolean czyZalogowany() {
		return zalogowany != null;
	}

	public void zaloguj(String login, String haslo) {
		ZarzadzajKontami manager = new ZarzadzajKontami();
		zalogowany = manager.zaloguj(login, haslo);
	}

	public void setPlytyMgr(ZarzadzaniePlytamiLocal plytyMgr) {
		this.plytyMgr = plytyMgr;
	}

	public ZarzadzaniePlytamiLocal getPlytyMgr() {
		return plytyMgr;
	}

	public void setFilmy(FilmyFactory filmy) {
		this.filmy = filmy;
	}

	public FilmyFactory getFilmy() {
		return filmy;
	}

	public void setZamowieniaMgr(ZarzadzanieWypozyczeniamiLocal zamowieniaMgr) {
		this.zamowieniaMgr = zamowieniaMgr;
	}

	public ZarzadzanieWypozyczeniamiLocal getZamowieniaMgr() {
		return zamowieniaMgr;
	}

	public FilmDAO nowyFilm(String tytul, String rok, String opis) {
		FilmDAO film = new FilmDAO();
		// id - generated value
		film.setTytul("300");
		film.setRok(rok);
		film.setOpisFabuly(opis);
		getPlytyMgr().dodajFilm(film);
		return film;
	}

	public PlytaDAO dodajPlyte(String plytaId, int filmId, String string2) {
		FilmDAO film = plytyMgr.pobierzFilm(filmId);
		PlytaDAO plyta = new PlytaDAO();
		plyta.setFilm(film);
		plyta.setFilmWolne(film);
		plyta.setId("1/I");
		plytyMgr.dodajPlyte(plyta);
		return plyta;
	}
}
