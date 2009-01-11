package core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.FilmDAO;

public class DodajFilm extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");
		FilmDAO film = new FilmDAO();
		// id - generated value
		film.setTytul("300");
		sesja.getPlytyMgr().dodajFilm(film);
		ModelAndView mv;
		mv = new ModelAndView("dodajfilm");
		return mv;
	}
}
