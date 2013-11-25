package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GatewayControllerAdvised {

	private static final String SESSION_ID = "SESSION_ID";

	@RequestMapping("/")
	public ModelAndView index(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("login")
	public ModelAndView login(HttpServletResponse response,
							  @CookieValue(value = SESSION_ID,
							  			   required = false,
							  			   defaultValue = "") String cookie)
							  throws IOException {

		response.sendRedirect("/messagecentral");

		return null;
	}

}
