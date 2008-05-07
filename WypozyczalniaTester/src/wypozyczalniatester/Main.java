/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * CREATE USER "PI" PROFILE "DEFAULT" IDENTIFIED BY "pi" ACCOUNT UNLOCK
GRANT "CONNECT" TO "PI"
 * */
package wypozyczalniatester;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import wypozyczalnia.dao.AdresDAO;
import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.PozycjaZamowieniaDAO;
import wypozyczalnia.dao.StanKonta;
import wypozyczalnia.dao.StanPlyty;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.dao.ZamowienieDAO;

/**
 *
 * @author marcin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyMMdd");

            final EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("WypozyczalniaDAODerbyPU");
            EntityManager em = emf.createEntityManager();
            
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ZamowienieDAO z = new ZamowienieDAO();
            PozycjaZamowieniaDAO p = new PozycjaZamowieniaDAO();
            PlytaDAO plyta = new PlytaDAO();
            FilmDAO film = new FilmDAO();

            p.setCenaJednostkowa((float) 12.22);
            z.setStanzamowienia(StanZamowienia.DOODIORU);            
                    

            plyta.setUwagiDoEgzemplarza("afd");
            plyta.setFilm(film);
            plyta.setDataNabycia(formatter.parse("851109"));
            plyta.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
            film.setOpisFabuly("opisik");
            film.setTytul("indiana jones");

            p.setZamowienie(z);
            p.setPlyta(plyta);
            z.getPozycje().add(p);

            em.persist(z);

            KontoDAO konto = new KontoDAO();
            KlientDAO klient = new KlientDAO();
            z.setKlient(klient);
            AdresDAO adres = new AdresDAO();

            konto.setSkrotHasla("losiek");
            konto.setStankonta(StanKonta.WYGASLO_HASLO);
            konto.setDataUstatniegoLogowania(formatter.parse("080102"));

            adres.setMiasto("wroclaw");
            adres.setNrDomu(9);
            klient.setAdres(adres);
            klient.setImie("marcinek");
            klient.setNazwisko("kowalski");
            klient.setNrpesel("85110916800");
            konto.setKlient(klient);

            em.persist(konto);

            et.commit();
            
            
            //final Context context = new InitialContext();
            //ZarzadzanieWypozyczeniami zarz = (ZarzadzanieWypozyczeniami) context.lookup("ZarzadzanieWypozyczeniamiBean");            

            System.out.println(StanPlyty.NIEWYPOZYCZONA.ordinal());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
