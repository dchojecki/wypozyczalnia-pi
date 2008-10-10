package test;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.AbstractController;

public class SpringTestController2 extends AbstractController {

	@SuppressWarnings("deprecation")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("welcome");
		ViewResolver vr;
		mav.addObject("date", new Date(1985, 11, 9, 11, 12));

		WebApplicationContext webApplicationContext = getWebApplicationContext();
		mav.addObject("id", webApplicationContext.toString());
		bean1 b = (bean1) webApplicationContext.getBean("los");
		mav.addObject("bean", b);
		return mav;
	}

}
