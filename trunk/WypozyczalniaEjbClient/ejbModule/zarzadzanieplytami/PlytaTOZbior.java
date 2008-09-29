package zarzadzanieplytami;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class PlytaTOZbior implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<PlytaTO> plyty;

	public PlytaTOZbior(Collection<PlytaTO> filmy) {
		super();
		this.plyty = filmy;
	}

	public Collection<PlytaTO> zwrocWszystkiePlyty() {
		return Collections.unmodifiableCollection(plyty);
	}
}
