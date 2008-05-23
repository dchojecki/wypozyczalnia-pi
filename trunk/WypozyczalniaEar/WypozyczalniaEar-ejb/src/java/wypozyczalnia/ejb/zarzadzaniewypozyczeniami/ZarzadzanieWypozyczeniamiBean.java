/**
 * 
 */
package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.StanZamowienia;
import static wypozyczalnia.dao.StanZamowienia.*;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.TransferObjectFactory;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypGLFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiDAO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/** 
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @author marcin
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Stateless
public class ZarzadzanieWypozyczeniamiBean implements ZarzadzanieWypozyczeniami {

    public ZarzadzanieWypozyczeniamiBean() {
    }
    private ZarzWypFabrykaDanych daoFabryka = new ZarzWypGLFabrykaDanych();

    public Collection<ZamowienieTO> pobierzZamowieniaWgCzasu(Date odd, Date doo) {
        ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka().createZarzadzanieWypozyczeniamiDAO();

        Collection<? extends ZamowienieDAO> zamowieniaDAO =
                dao.pobierzWszystkieZamowieniaOdDo(odd, doo);

        List<ZamowienieTO> zamowieniaTO = new LinkedList<ZamowienieTO>();
        Map<String, KlientTO> bufor = new HashMap<String, KlientTO>();

        for (ZamowienieDAO zamD : zamowieniaDAO) {
            ZamowienieTO zamT = TransferObjectFactory.stworzZamowienieTO(zamD);
            zamowieniaTO.add(zamT);

            KlientDAO kDao = zamD.getKlient();
            KlientTO klientT = bufor.get(kDao.getNrpesel());

            if (klientT == null) {
                // TODO
                klientT = new KlientTO();
                bufor.put(kDao.getNrpesel(), klientT);
            }
            zamT.setKlient(klientT);

            for (PozycjaZamowieniaDAO pzD : zamD.getPozycje()) {
                PozycjaZamowieniaTO pzT = TransferObjectFactory.stworzPozycjeZamowienia(pzD);
                zamT.getPozycjezamowienia().add(pzT);
            }

        }
        return zamowieniaTO;

    }

    public Collection<ZamowienieTO> pobierzWszystkieZamowienia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ZamowienieTO scalDaneZamowienia(ZamowienieTO zam) {
        ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka().createZarzadzanieWypozyczeniamiDAO();
        ZamowienieDAO zamowienie = dao.pobierzZamowienie(zam.getId());

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

        zam = TransferObjectFactory.stworzZamowienieTO(zamowienie);
        return zam;
    }

    public ZarzWypFabrykaDanych getDaoFabryka() {
        return daoFabryka;
    }

    public void setDaoFabryka(ZarzWypFabrykaDanych daoFabryka) {
        this.daoFabryka = daoFabryka;
    }

    public ZamowienieTO utworzNoweZamowienie() {
        ZarzadzanieWypozyczeniamiDAO dao = getDaoFabryka().createZarzadzanieWypozyczeniamiDAO();
        ZamowienieDAO z = dao.utworzNoweZamowienie();
        dao.scalZamowienie(z);
        ZamowienieTO ret = TransferObjectFactory.stworzZamowienieTO(z);
        return ret;
    }
}
