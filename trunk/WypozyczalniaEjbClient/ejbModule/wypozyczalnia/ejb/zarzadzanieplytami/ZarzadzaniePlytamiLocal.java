package wypozyczalnia.ejb.zarzadzanieplytami;

import java.util.Collection;

import javax.ejb.Local;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;

@Local
public interface ZarzadzaniePlytamiLocal {
	void dodajFilm(FilmDAO film);

	void dodajPlyte(Integer idFilmu);

	void dodajPlyte(PlytaDAO idFilmu);

	PlytaDAO pobierzPlyte(String id);

	FilmDAO pobierzFilm(Integer id);

	Collection<FilmDAO> zwrocListeWszystkichFilmowDAO();

	Collection<FilmDAO> zwrocListeFilmowDAO(String tytul);

	Collection<PlytaDAO> zwrocListeWszystkichPlytDAO(FilmDAO film);

	FilmDAO dodajFilm(String tytul, String opis, String rok);
}
