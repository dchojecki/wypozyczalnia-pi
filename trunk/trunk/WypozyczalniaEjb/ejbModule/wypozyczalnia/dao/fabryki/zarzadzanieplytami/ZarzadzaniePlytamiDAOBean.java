package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import javax.ejb.Remote;

import wypozyczalnia.dao.KontoDAO;

@Remote
public interface ZarzadzaniePlytamiDAOBean extends ZarzadzaniePlytamiDAO {

	void scalKonto(KontoDAO konto);

}
