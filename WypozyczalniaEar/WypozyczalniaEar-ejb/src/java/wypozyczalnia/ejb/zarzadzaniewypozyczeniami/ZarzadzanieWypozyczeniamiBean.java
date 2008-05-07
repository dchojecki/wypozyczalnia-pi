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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypFabrykaDanych;
import wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami.ZarzWypGLFabrykaDanych;
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
@Stateless(mappedName="ZarzadzanieWypozyczeniamiBean")
public class ZarzadzanieWypozyczeniamiBean implements ZarzadzanieWypozyczeniami {    
    
    private ZarzWypFabrykaDanych daoFabryka = new ZarzWypGLFabrykaDanych();

    public Collection<ZamowienieTO> pobierzZamowieniaWgCzasu(Date odd, Date doo) {
        ZarzadzanieWypozyczeniamiDAO dao = daoFabryka.createZarzadzanieWypozyczeniamiDAO();

        Collection<? extends ZamowienieDAO> zamowieniaDAO =
                dao.pobierzWszystkieZamowieniaOdDo(odd, doo);

        List<ZamowienieTO> zamowieniaTO = new LinkedList<ZamowienieTO>();
        Map<String, KlientTO> bufor = new HashMap<String, KlientTO>();

        for (ZamowienieDAO zamD : zamowieniaDAO) {
            ZamowienieTO zamT = new ZamowienieTO(zamD);
            zamowieniaTO.add(zamT);

            KlientDAO kDao = zamD.getKlient();
            KlientTO klientT = bufor.get(kDao.getNrpesel());

            if (klientT == null) {
                klientT = new KlientTO(kDao);
                bufor.put(kDao.getNrpesel(), klientT);
            }
            zamT.setKlient(klientT);

            for (PozycjaZamowieniaDAO pzD : zamD.getPozycje()) {
                PozycjaZamowieniaTO pzT = new PozycjaZamowieniaTO(pzD);
                zamT.getPozycjezamowienia().add(pzT);
            }

        }
        return zamowieniaTO;

    }

    public Collection<ZamowienieTO> pobierzWszystkieZamowienia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
