package core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class DodajFilm extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");

		String tytul = req.getParameter("tytul");
		String rok = req.getParameter("rok");
		String opis = req.getParameter("opis");

		ModelAndView mv = new ModelAndView("dodajfilm");
		if (tytul != null) // jesli wchodzimy na strone po wypelnieniu
		// formularza
		{
			String tekst = sesja.dodajFilm(tytul, rok, opis);
			mv.addObject("tekst", tekst);
		} else {
			mv.addObject("tekst", "");
		}

		return mv;
	}

}
