package zarzadzaniePlytami;

import junit.framework.TestCase;

import org.junit.Before;

import wypozyczalnia.dao.fabryki.FactoryType;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytamiBean;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTOZbior;

public class ZarzadzaniePlytamiBeanTest extends TestCase {

    public ZarzadzaniePlytamiBeanTest() {
    }

    private ZarzadzaniePlytamiBean zarzadzanie;
    
    @Before
    public void setUp() throws Exception {
        zarzadzanie = new ZarzadzaniePlytamiBean();
        zarzadzanie.getFabrykaDAO().setFactoryType(FactoryType.MEMORY);
    }
	public void testZwrocListeWszystkichFilmow() {
		FilmTOZbior f = zarzadzanie.zwrocListeWszystkichFilmow();
	}

	public void testZwrocListeWszystkichPlyt() {
		FilmTO film = new FilmTO();
		film.setId(1);
		PlytaTOZbior f = zarzadzanie.zwrocListeWszystkichPlyt(null);
	}
}
