package wypozyczalnia.dao;

import java.util.Collection;
import java.util.HashMap;

public class FilmyFactory {
	private static HashMap<Integer, FilmDAO> _filmy = new HashMap<Integer, FilmDAO>();

	public static FilmDAO getFilm(Integer id) {
		if (_filmy.containsKey(id))
			return _filmy.get(id);
		return null;
	}
	
	public FilmyFactory() {
		FilmDAO f;
		PlytaDAO p;
		
		f = new FilmDAO();
		f.id = 32;
		f.tytul = "Karmazynowy przyplyw";
		f.rok = "1995";
		f.opis = "Zaloga lodzi podwodnej, pod przewodnictwem pierwszego oficera (Denzel Washington) "
			+"buntuje sie przeciw kapitanowi (Gene Hackman).";
		
		p = new PlytaDAO();
		p.nr = "32/I";
		p.film = f;
		f.egzemplarze.add(p);
		
		p = new PlytaDAO();
		p.nr = "32/II";
		p.film = f;
		f.egzemplarze.add(p);
		
		f.wolne.addAll(f.egzemplarze);
		_filmy.put(f.id, f);
		
		
		
		f = new FilmDAO();
		f.id = 43;
		f.tytul = "Zezowate szczescie";
		f.rok = "1960";
		f.opis = "Groteskowo opowiedziana historia pewnego oportunisty (Bogumil Kobiela).";
		
		p = new PlytaDAO();
		p.nr = "43/I";
		p.film = f;
		f.egzemplarze.add(p);
		
		f.wolne.addAll(f.egzemplarze);
		_filmy.put(f.id, f);
		
		
		
		f = new FilmDAO();
		f.id = 188;
		f.tytul = "Imie rozy";
		f.rok = "1986";
		f.opis = "Adaptacja powiesci Umberto Eco, z rewelacyjnym, jak zwykle, Seanem Connery.";
		
		p = new PlytaDAO();
		p.nr = "188/I";
		p.film = f;
		f.egzemplarze.add(p);
		p = new PlytaDAO();
		p.nr = "188/II";
		p.film = f;
		f.egzemplarze.add(p);
		p = new PlytaDAO();
		p.nr = "188/III";
		p.film = f;
		f.egzemplarze.add(p);
		
		f.wolne.addAll(f.egzemplarze);
		_filmy.put(f.id, f);
	}

	public static Collection<FilmDAO> getAll() {
		return _filmy.values();
	}
}
