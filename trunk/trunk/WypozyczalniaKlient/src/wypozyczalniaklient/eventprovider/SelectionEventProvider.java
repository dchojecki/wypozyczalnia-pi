package wypozyczalniaklient.eventprovider;

import org.eclipse.core.commands.common.EventManager;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.PlytaTO;

public class SelectionEventProvider extends EventManager {

	private static final SelectionEventProvider provider = new SelectionEventProvider();

	public static void addListener(GlobalListener listener) {
		provider.addListenerObject(listener);
	}

	public static void removeListener(GlobalListener listener) {
		provider.removeListenerObject(listener);
	}

	public static void filmTOSelected(FilmTO film) {
		for (Object listener : provider.getListeners()) {
			((GlobalListener) listener).FilmTOSelected(film);
		}
	}

	public static void plytaTOSelected(PlytaTO film) {
		for (Object listener : provider.getListeners()) {
			((GlobalListener) listener).PlytaTOSelected(film);
		}
	}
	public static void zamowienieTOSelected(ZamowienieTO film) {
		for (Object listener : provider.getListeners()) {
			((GlobalListener) listener).ZamowienieTOSelected(film);
		}
	}

	public static void pozyucjaTOSelected(PozycjaZamowieniaTO film) {
		for (Object listener : provider.getListeners()) {
			((GlobalListener) listener).PozycjaZamowieniaTOSelected(film);
		}
	}
}
