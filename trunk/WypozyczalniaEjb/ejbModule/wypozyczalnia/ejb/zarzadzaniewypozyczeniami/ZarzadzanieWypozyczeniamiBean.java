/**
 * 
 */
package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import static wypozyczalnia.dao.StanZamowienia.ANULOWANE;
import static wypozyczalnia.dao.StanZamowienia.DOODIORU;
import static wypozyczalnia.dao.StanZamowienia.POZYCZONE;
import static wypozyczalnia.dao.StanZamowienia.PRZYJETE;
import static wypozyczalnia.dao.StanZamowienia.ZALEGLE;
import static wypozyczalnia.dao.StanZamowienia.ZREALIZOWANE;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;

import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.TransferObjectFactory;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniekontami.ZarzadzanieKontamiGlownaFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzPlytamiFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzPlytamiGLFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzadzaniePlytamiDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypGLFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiDAO;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTOZbior;
import zarzadzanieplytami.PlytaTO;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author marcin
 * 
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless
public class ZarzadzanieWypozyczeniamiBean implements ZarzadzanieWypozyczeniami {

	public ZarzadzanieWypozyczeniamiBean() {
	}

	private ZarzWypFabrykaDanych daoFabryka = new ZarzWypGLFabrykaDanych();
	private ZarzPlytamiFabrykaDanych plytyFabryka = new ZarzPlytamiGLFabrykaDanych();
	private ZarzadzanieKontamiFabrykaDanych kontaDaoFabryka = new ZarzadzanieKontamiGlownaFabrykaDanych();
	
	public ZamowienieTOZbior pobierzZamowieniaWgCzasu(Date odd, Date doo) {
		ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka()
				.createZarzadzanieWypozyczeniamiDAO();

		Collection<? extends ZamowienieDAO> zamowieniaDAO = dao
				.pobierzWszystkieZamowieniaOdDo(odd, doo);

		return new ZamowienieTOZbior(TransferObjectFactory.kopiujKolekcje(zamowieniaDAO));
	}

	public ZamowienieTOZbior pobierzWszystkieZamowienia() {
		ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka()
				.createZarzadzanieWypozyczeniamiDAO();
		Collection<? extends ZamowienieDAO> zamowienia = dao
				.pobierzWszystkieZamowienia();
		return new ZamowienieTOZbior(TransferObjectFactory
				.kopiujKolekcje(zamowienia));

	}

	public ZamowienieTO scalDaneZamowienia(ZamowienieTO zam) {
		ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka()
				.createZarzadzanieWypozyczeniamiDAO();
		
		ZarzadzanieKontamiDAO kontaDAO = kontaDaoFabryka.pobierzWypozyczalniaDAO();
		KlientDAO k = kontaDAO.zwrocDaneKlienta(zam.getKonto().getNrPeselKlienta());
		
		ZamowienieDAO zamowienie = dao.pobierzZamowienie(zam.getId());
		zamowienie.setKonto(k.zwrocPierwszeKonto());
		
		if (zamowienie == null) {
			return null;
		}
		StanZamowienia stanDAO = zamowienie.getStanzamowienia();
		StanZamowienia stanTO = zam.getStanzamowienia();

		if (stanDAO == PRZYJETE && stanTO == DOODIORU) {
			zamowienie.gotowe();
		}
		if (stanDAO == DOODIORU && stanTO == POZYCZONE) {
			zamowienie.odebrane();
		}
		if (stanDAO == POZYCZONE && stanTO == ZREALIZOWANE) {
			zamowienie.oddane();
		}
		if (stanDAO == DOODIORU && stanTO == ANULOWANE) {
			zamowienie.anuluj();
		}
		if (stanDAO == PRZYJETE && stanTO == ANULOWANE) {
			zamowienie.anuluj();
		}
		if (stanDAO == ZALEGLE && stanTO == ZREALIZOWANE) {
			zamowienie.uregulowano();
		}

		zamowienie.getPozycje().clear();
		
		ZarzadzaniePlytamiDAO zarzPlytami = plytyFabryka.createZarzadzaniePlytamiDAO();
		for (PozycjaZamowieniaTO pz: zam.getPozycjezamowienia()) {
			PlytaTO pt = pz.getPlyta();
			PlytaDAO plyta = zarzPlytami.zwrocPlyte(pt.getIdPlyty());
			
			PozycjaZamowieniaDAO pd = new PozycjaZamowieniaDAO();
			pd.setPlyta(plyta);
			zamowienie.getPozycje().add(pd);
		}
		dao.scalZamowienie(zamowienie);
		zam = TransferObjectFactory.stworzZamowienieTO(zamowienie);
		return zam;
	}

	public ZarzWypFabrykaDanych getDaoFabryka() {
		return daoFabryka;
	}

	public ZamowienieTO utworzNoweZamowienie() {
		ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka()
				.createZarzadzanieWypozyczeniamiDAO();
		ZamowienieDAO z = dao.utworzNoweZamowienie();
		dao.scalZamowienie(z);
		ZamowienieTO ret = TransferObjectFactory.stworzZamowienieTO(z);
		return ret;
	}

}
