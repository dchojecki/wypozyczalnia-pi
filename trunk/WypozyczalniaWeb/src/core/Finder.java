package core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.FilmyFactory;

public class Finder extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String query = req.getParameter("q");
		
		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");

		Collection<FilmDAO> filmy = sesja.filmy.getAll(); 
		ModelAndView m = new ModelAndView("results");
		m.addObject("title", "Filmy");
		m.addObject("query", query);
		m.addObject("ile", filmy.size());
		m.addObject("act_zamow", true);
		m.addObject("act_anuluj", false);
		m.addObject("films", filmy);
		//m.addObject("films", filmy);
		return m;
	}

}