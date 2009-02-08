package core.memorydao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytamiLocal;

public class ZarzadzaniePlytamiMem implements ZarzadzaniePlytamiLocal {

	@Override
	public void dodajFilm(FilmDAO film) {
		film.setId(Storage.filmyBufor.size());
		Storage.filmyBufor.put(film.getId(), film);

	}

	@Override
	public void dodajPlyte(PlytaDAO plyta) {
		FilmDAO f = Storage.filmyBufor.get(plyta.getFilm().getId());
		plyta.setId(((Integer) Storage.plytyBufor.size()).toString());
		f.getPlyty().add(plyta);
		f.getWolne().add(plyta);
		Storage.plytyBufor.put(plyta.getId(), plyta);

	}

	@Override
	public FilmDAO pobierzFilm(Integer id) {
		return Storage.filmyBufor.get(id);

	}

	@Override
	public PlytaDAO pobierzPlyte(String id) {
		return Storage.plytyBufor.get(id);
	}

	@Override
	public Collection<FilmDAO> zwrocListeFilmowDAO(String tytul) {
		HashMap<Integer, FilmDAO> filmyBufor = Storage.filmyBufor;
		ArrayList<FilmDAO> ret = new ArrayList<FilmDAO>();
		for (FilmDAO f : filmyBufor.values()) {
			if (f.getTytul().equals(tytul)) {
				ret.add(f);
			}
		}
		return ret;
	}

	@Override
	public Collection<FilmDAO> zwrocListeWszystkichFilmowDAO() {
		return Storage.filmyBufor.values();
	}

	@Override
	public Collection<PlytaDAO> zwrocListeWszystkichPlytDAO(FilmDAO film) {
		FilmDAO filmDAO = Storage.filmyBufor.get(film.getId());
		return filmDAO.getPlyty();
	}

	@Override
	public FilmDAO dodajFilm(String tytul, String opis, String rok) {
		Collection<FilmDAO> filmy = zwrocListeFilmowDAO(tytul);
		if (!filmy.isEmpty())
			return null; // film juz istnieje

		FilmDAO film = new FilmDAO();
		film.setTytul(tytul);
		film.setOpisFabuly(opis);
		film.setRok(rok);
		film.setId(Storage.filmyBufor.size());
		Storage.filmyBufor.put(film.getId(), film);
		return film;

	}

	@Override
	public void dodajPlyte(Integer idFilmu) {
		FilmDAO film = Storage.filmyBufor.get(idFilmu);
		PlytaDAO plyta = new PlytaDAO();
		plyta.setFilm(film);
		plyta.setFilmWolne(film);
		plyta.setId(((Integer) Storage.plytyBufor.size()).toString());
		film.getPlyty().add(plyta);
		film.getWolne().add(plyta);
		Storage.plytyBufor.put(plyta.getId(), plyta);
	}

}
