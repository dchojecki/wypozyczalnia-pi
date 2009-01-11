package wypozyczalnia.dao.fabryki.zarzadzanieplytami;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.StanPlyty;
import wypozyczalnia.mock.EntityManagerMock;

public class ZarzadzaniePlytamiOracleDAOMock extends ZarzPlytamiOracleDAO{
    private EntityManagerMock emMock;
    
    public ZarzadzaniePlytamiOracleDAOMock() {
        super(new EntityManagerMock());
        emMock = (EntityManagerMock) getEntityManager();
        
        
        FilmDAO f1 = new FilmDAO();
        FilmDAO f2 = new FilmDAO();
        FilmDAO f3 = new FilmDAO();
        
        PlytaDAO p1 = new PlytaDAO();
        p1.setStanplyty(StanPlyty.NIEWYPOZYCZONA);
        PlytaDAO p2 = new PlytaDAO();
        p2.setStanplyty(StanPlyty.WDRODZE);
        PlytaDAO p3 = new PlytaDAO();
        p3.setStanplyty(StanPlyty.WYPOZYCZONA);
        PlytaDAO p4 = new PlytaDAO();
        p4.setStanplyty(StanPlyty.WYPOZYCZONA);
        PlytaDAO p5 = new PlytaDAO();
        p5.setStanplyty(StanPlyty.WDRODZE);
        
        f1.setTytul("Indiana Jones");
        f2.setTytul("Kevin sam w domu");
        f3.setTytul("Batman forever");
        
        f1.setOpisFabuly("fajowe");
        f2.setOpisFabuly("nudne");
        f3.setOpisFabuly("super");
        
        p1.setFilm(f1);
        p1.setUwagiDoEgzemplarza("ok");
        p2.setFilm(f1);
        p2.setUwagiDoEgzemplarza("ok");
        p3.setFilm(f2);
        p3.setUwagiDoEgzemplarza("ok");
        p4.setFilm(f1);
        p4.setUwagiDoEgzemplarza("ok");
        p5.setFilm(f1);
        p5.setUwagiDoEgzemplarza("ok");
        
        f1.getPlyty().add(p1);
        f1.getPlyty().add(p2);
        f1.getPlyty().add(p4);
        f1.getPlyty().add(p5);
        f2.getPlyty().add(p3);
        emMock.persist(f1);
        emMock.persist(f2);
        emMock.persist(f3);
        emMock.persist(p1);
        emMock.persist(p2);
        emMock.persist(p3);
        emMock.persist(p4);
        emMock.persist(p5);
    }
    
    public void reset() {
        emMock.clear();
    }
}
