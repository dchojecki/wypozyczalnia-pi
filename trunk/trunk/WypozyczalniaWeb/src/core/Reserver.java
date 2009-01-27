package core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.PlytaDAO;

public class Reserver extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		Integer id = Integer.parseInt(req.getParameter("fid"));

		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");

		sesja.zamow(id);
		Collection<PlytaDAO> plyty = sesja.zamowionePlyty();

		ModelAndView m = new ModelAndView("res_pid");

		m.addObject("title", "Zamowione filmy");
		// m.addObject("query", query);
		m.addObject("ile", plyty.size());
		m.addObject("act_zamow", false);
		m.addObject("act_anuluj", true);
		m.addObject("plyty", plyty);

		return m;
	}

}
