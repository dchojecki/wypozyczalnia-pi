package zarzadzanieplytami;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class FilmTOZbior implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<FilmTO> filmy;

	public FilmTOZbior(Collection<FilmTO> filmy) {
		super();
		this.filmy = filmy;
	}

	public Collection<FilmTO> zwrocWszystkieFilmy() {
		return Collections.unmodifiableCollection(filmy);
	}

}
