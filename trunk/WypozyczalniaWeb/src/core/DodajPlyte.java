package core;

import java.util.Collection;
import java.util.Random;

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
		
		Integer idFilmu = -1;
		String tekst = new String("Wybierz film, do ktorego chcesz dodac plyty.");
		if ((arg0.getParameter("fid") != null) && (arg0.getParameter("ile") != null)) {
			if (arg0.getParameter("ile").equals("jedna")) {
				idFilmu = Integer.valueOf(arg0.getParameter("fid"));
				ZarzadzaniePlytamiLocal plytyMgr = sesja.getPlytyMgr();	
				FilmDAO film = plytyMgr.pobierzFilm(idFilmu);
				PlytaDAO plyta = new PlytaDAO();
				plyta.setFilm(film);
				plyta.setFilmWolne(film);
				Random r = new Random();
				plyta.setId(Long.toString(r.nextLong())); // wygeneruj losowe ID
				plytyMgr.dodajPlyte(plyta);
				tekst = new String("Dodano plyte do filmu " + film.getTytul() + " !");		
			} else if (arg0.getParameter("ile").equals("wiele")) {
				// tutaj trzeba juz zmienic ModelAndView i pokazac formularz
				tekst = "TODO";
			}
		}
		
		ModelAndView mv = new ModelAndView("dodajplyte");
		mv.addObject("films", filmy);
		mv.addObject("tekst", tekst);
		mv.addObject("idFilmu", idFilmu);
		return mv;
	}

}
