package core;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.ejb.zarzadzanieplytami.ZarzadzaniePlytamiLocal;

public class DodajFilm extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");

		FilmDAO film = null;
		String tekst = new String();

		String tytul = req.getParameter("tytul");
		if (tytul != null) // jesli wchodzimy na strone po wypelnieniu
							// formularza
		{
			if (tytul.equals("")) {
				tekst = new String("Musisz podac tytul!!!");
			} else {
				try {
					Integer rok = Integer.valueOf(req.getParameter("rok"));
					if ((rok < 1900) || (rok > 2009)) {
						tekst = new String("Niepoprawny rok.");
					} else {
						ZarzadzaniePlytamiLocal plytyMgr = sesja.getPlytyMgr();
						Collection<FilmDAO> filmy = plytyMgr
								.zwrocListeFilmowDAO(tytul);
						if (!filmy.isEmpty()) {
							tekst = new String(
									"Film o takim tytule juz istnieje!!!");
						} else {
							film = new FilmDAO();
							film.setTytul(tytul);
							film.setRok(req.getParameter("rok"));
							film.setOpisFabuly(req.getParameter("opis"));
							sesja.getPlytyMgr().dodajFilm(film);
							tekst = new String("Film " + film.getTytul()
									+ " zostal poprawnie dodany do bazy!");
						}
					}
				} catch (NumberFormatException e) {
					tekst = new String("Niepoprawny rok.");
				}
			}
		}
		ModelAndView mv = new ModelAndView("dodajfilm");
		mv.addObject("tekst", tekst);
		return mv;
	}
}
