package core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class DodajPlyte extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		WebApplicationContext webApplicationContext = getWebApplicationContext();
		Sesja sesja = (Sesja) webApplicationContext.getBean("sesja");

		Integer ileDodano = 0;
		String tekst = "Wybierz film, do ktorego chcesz dodac plyty.";
		String ile = arg0.getParameter("ile");
		String fid = arg0.getParameter("fid");
		Integer idFilmu = Integer.valueOf(fid);
		Integer ileDodac = Integer.valueOf(arg0.getParameter("iledodac"));

		if ((fid != null) && (ile != null)) {
			if (ile.equals("jedna")) {
				tekst = sesja.dodajJednaPlyte(idFilmu);
				ileDodano = 1;
			} else if (ile.equals("wiele")) {

				tekst = sesja.dodajWielePlyt(idFilmu, ileDodac);
				ileDodano = ileDodac;
			}
		}
		ModelAndView mv = new ModelAndView("dodajplyte");
		mv.addObject("films", sesja.getFilmy().getAll());
		mv.addObject("tekst", tekst);
		mv.addObject("idFilmu", idFilmu);
		mv.addObject("ileDodano", ileDodano);
		return mv;
	}

}
