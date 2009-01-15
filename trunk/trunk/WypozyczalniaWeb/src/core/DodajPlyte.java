package core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytamiLocal;

public class DodajPlyte extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		Sesja sesja = (Sesja) webApplicationContext.getBean("sesja");
		Collection<FilmDAO> filmy = sesja.getFilmy().getAll();
		
		// TODO: wyswietlamy liste filmow (jak w Finder) i przy kazdym z nich pokazujemy ilosc,
		// i dodajemy linka "zwieksz ilosc"
		
		/*
		ZarzadzaniePlytamiLocal plytyMgr = sesja.getPlytyMgr();
		Collection<FilmDAO> filmy = plytyMgr.zwrocListeFilmowDAO("300");
		FilmDAO film = filmy.iterator().next(); // normalnie to po id
		PlytaDAO plyta = new PlytaDAO();
		plyta.setFilm(film);
		plyta.setFilmWolne(film);
		plyta.setId("1/I");
		plytyMgr.dodajPlyte(plyta);

		plyta = new PlytaDAO();
		plyta.setFilm(film);
		plyta.setFilmWolne(film);
		plyta.setId("2/I");
		plytyMgr.dodajPlyte(plyta);
		 */
		
		ModelAndView mv = new ModelAndView("dodajplyte");
		mv.addObject("films", filmy);
		return mv;
	}

}
