package wypozyczalnia.to.zarzadzaniewypozyczeniami;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class ZamowienieTOZbior implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<ZamowienieTO> zamowienia;

	public ZamowienieTOZbior(Collection<ZamowienieTO> zamowienia) {
		super();
		this.zamowienia = zamowienia;
	}

	public Collection<ZamowienieTO> zwrocWszystkieZamowienia() {
		return Collections.unmodifiableCollection(zamowienia);
	}

}
