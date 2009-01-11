package wypozyczalniaklient.eventprovider;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.PlytaTO;

public interface GlobalListener {
	void FilmTOSelected(FilmTO film);
	void PlytaTOSelected(PlytaTO plyta);
	void ZamowienieTOSelected(ZamowienieTO plyta);
	void PozycjaZamowieniaTOSelected(PozycjaZamowieniaTO plyta);

}