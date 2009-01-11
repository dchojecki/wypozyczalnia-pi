package core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.FilmDAO;

public class Account extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		
		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");

		Collection<FilmDAO> filmy = sesja.zamowioneFilmy();

		ModelAndView m = new ModelAndView("results");
		
		m.addObject("title", "Zamowione filmy");
		//m.addObject("query", query);
		m.addObject("ile", filmy.size());
		m.addObject("act_zamow", false);
		m.addObject("act_anuluj", true);
		m.addObject("films", filmy);
		
		return m;
	}

}
