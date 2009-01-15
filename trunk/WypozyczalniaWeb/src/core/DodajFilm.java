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

		if (req.getParameter("tytul") != null) // jesli wchodzimy na strone po wypelnieniu formularza
		{
			if (req.getParameter("tytul").equals(""))
			{
				tekst = new String("Musisz podac tytul!!!");
			}
			else
			{
				try
				{
					if ((Integer.valueOf(req.getParameter("rok")) < 1900) ||
							(Integer.valueOf(req.getParameter("rok")) > 2009))
					{
						tekst = new String("Niepoprawny rok.");
					}
					else
					{
						ZarzadzaniePlytamiLocal plytyMgr = sesja.getPlytyMgr();
						Collection<FilmDAO> filmy = plytyMgr.zwrocListeFilmowDAO(req.getParameter("tytul"));
						if (!filmy.isEmpty())
						{
							tekst = new String("Film o takim tytule juz istnieje!!!");
						}
						else
						{
							film = new FilmDAO();
							film.setTytul(req.getParameter("tytul"));
							film.setRok(req.getParameter("rok"));
							film.setOpisFabuly(req.getParameter("opis"));
							sesja.getPlytyMgr().dodajFilm(film);
							tekst = new String("Film " + film.getTytul() + " zostal poprawnie dodany do bazy!");
						}
					}
				}
				catch (NumberFormatException e)
				{
					tekst = new String("Niepoprawny rok.");
				}
			}
		}
		ModelAndView mv = new ModelAndView("dodajfilm");
		mv.addObject("tekst", tekst);
		return mv;
	}
}
