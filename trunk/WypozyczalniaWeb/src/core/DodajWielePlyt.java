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

public class DodajWielePlyt extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		Sesja sesja = (Sesja) webApplicationContext.getBean("sesja");
		ZarzadzaniePlytamiLocal plytyMgr = sesja.getPlytyMgr();	
		FilmDAO film = plytyMgr.pobierzFilm(Integer.valueOf(arg0.getParameter("fid")));
		
		ModelAndView mv = new ModelAndView("dodajwieleplyt");
		mv.addObject("film", film);
		return mv;
	}

}
