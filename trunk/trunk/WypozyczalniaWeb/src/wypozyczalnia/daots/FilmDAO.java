package wypozyczalnia.daots;

import java.util.HashSet;
import java.util.Set;

public class FilmDAO {
	public FilmDAO() {
		egzemplarze = new HashSet<PlytaDAO>();
		wolne = new HashSet<PlytaDAO>();
	}

	Integer id;
	String tytul, opis, rok;

	private Set<PlytaDAO> egzemplarze, wolne;

	public PlytaDAO wolnyEgzemplarz() {
		if (wolne.size() > 0)
			return wolne.iterator().next();
		return null;
	}

	public void zamowPlyte(PlytaDAO plyta) {
		wolne.remove(plyta);
	}

	public String getTytul() {
		return tytul;
	}

	public String getOpis() {
		return opis;
	}

	public int getIleWolnych() {
		return wolne.size();
	}

	public String getRok() {
		return rok;
	}

	public Integer getId() {
		return id;
	}

	public Set<PlytaDAO> getPlyty() {
		return egzemplarze;
	}

	public Set<PlytaDAO> getWolne() {
		return wolne;
	}
}
