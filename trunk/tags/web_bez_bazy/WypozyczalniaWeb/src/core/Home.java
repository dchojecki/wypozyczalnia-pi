package core;


import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class Home extends AbstractController {
	
	@EJB(name = "ZarzadzanieWypozyczeniamiBean")
	
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) {
		setRequireSession(true);
		
		String login = req.getParameter("login");
		String haslo = req.getParameter("haslo");
		
		WebApplicationContext ctx = getWebApplicationContext();
		Sesja sesja = (Sesja) ctx.getBean("sesja");
		
		if (login != null && haslo != null) {
			sesja.zaloguj(login, haslo);
		}
		
		ModelAndView m;
		
		if (sesja.czyZalogowany()) {
			m = new ModelAndView("home");
			m.addObject("uzytkownik", sesja.zalogowany);
		} else {
			m = new ModelAndView("login");
		}
		return m;
	}

}