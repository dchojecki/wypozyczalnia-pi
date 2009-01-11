package core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;

public class DodajPlyte extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		Sesja sesja = (Sesja) webApplicationContext.getBean("sesja");
		Collection<FilmDAO> zwrocListeFilmowDAO = sesja.getPlytyMgr()
				.zwrocListeFilmowDAO("300");
		FilmDAO next = zwrocListeFilmowDAO.iterator().next();
		int filmId = next.getId();// z request
		PlytaDAO plyta = sesja.dodajPlyte("1/I", filmId, "uwagi do plyty1");
		// Collection<FilmDAO> filmy = plytyMgr.zwrocListeFilmowDAO("300");
		// FilmDAO film = filmy.iterator().next(); // normalnie to po id

		ModelAndView mv = new ModelAndView("dodajplyte");
		mv.addObject("plyta", plyta);
		return mv;
	}

}
