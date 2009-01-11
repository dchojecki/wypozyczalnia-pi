package wypozyczalnia.daots;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytamiLocal;

public class FilmyFactory {
	private ZarzadzaniePlytamiLocal plytyMgr;

	public FilmDAO getFilm(Integer id) {
		return null;
	}

	public FilmyFactory(ZarzadzaniePlytamiLocal plytyMgr) {
		HashMap<Integer, FilmDAO> _filmy = new HashMap<Integer, FilmDAO>();
		this.plytyMgr = plytyMgr;
		FilmDAO f;
		PlytaDAO p;

		f = new FilmDAO();
		f.setId(32);
		f.setTytul("Karmazynowy przyplyw");
		f.setRok("1995");
		f
				.setOpisFabuly("Zaloga lodzi podwodnej, pod przewodnictwem pierwszego oficera (Denzel Washington) "
						+ "buntuje sie przeciw kapitanowi (Gene Hackman).");
		Set<PlytaDAO> plyty = f.getPlyty();
		Set<PlytaDAO> wolne = f.getWolne();
		p = new PlytaDAO();
		p.setId("32/I");
		p.setFilm(f);
		p.setFilmWolne(f);

		plyty.add(p);

		p = new PlytaDAO();
		p.setId("32/II");
		p.setFilm(f);
		p.setFilmWolne(f);
		plyty.add(p);

		wolne.addAll(plyty);
		_filmy.put(f.getId(), f);

		f = new FilmDAO();
		f.setId(43);
		f.setTytul("Zezowate szczescie");
		f.setRok("1960");
		f
				.setOpisFabuly("Groteskowo opowiedziana historia pewnego oportunisty (Bogumil Kobiela).");

		p = new PlytaDAO();
		p.setId("43/I");
		p.setFilm(f);
		p.setFilmWolne(f);
		f.getPlyty().add(p);

		f.getWolne().addAll(f.getPlyty());
		_filmy.put(f.getId(), f);

		f = new FilmDAO();
		f.setId(188);
		f.setTytul("Imie rozy");
		f.setRok("1986");
		f
				.setOpisFabuly("Adaptacja powiesci Umberto Eco, z rewelacyjnym, jak zwykle, Seanem Connery.");

		p = new PlytaDAO();
		p.setId("188/I");
		p.setFilm(f);
		p.setFilmWolne(f);
		f.getPlyty().add(p);
		p = new PlytaDAO();
		p.setId("188/II");
		p.setFilm(f);
		p.setFilmWolne(f);
		f.getPlyty().add(p);
		p = new PlytaDAO();
		p.setId("188/III");
		p.setFilm(f);
		p.setFilmWolne(f);
		f.getPlyty().add(p);

		f.getWolne().addAll(f.getPlyty());
		_filmy.put(f.getId(), f);

		for (FilmDAO film : _filmy.values()) {
			plytyMgr.dodajFilm(film);
		}

	}

	public Collection<FilmDAO> getAll() {
		return plytyMgr.zwrocListeWszystkichFilmowDAO();
	}

	public void setPlytyMgr(ZarzadzaniePlytamiLocal plytyMgr) {
		this.plytyMgr = plytyMgr;
	}

	public ZarzadzaniePlytamiLocal getPlytyMgr() {
		return plytyMgr;
	}
}
