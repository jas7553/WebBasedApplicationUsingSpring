package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MainSiteController {

	@RequestMapping("/welcome")
	public ModelAndView test2(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("greeting");
		mav.addObject("name", "worldddd");
		return mav;
	}

}
