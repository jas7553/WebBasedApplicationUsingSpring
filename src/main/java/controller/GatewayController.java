package controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class GatewayController {

	private static final String SESSION_ID = "SESSION_ID";

	private static int id = 2;

	@RequestMapping("/")
	public ModelAndView index(HttpServletResponse response,
							  @CookieValue(value = SESSION_ID,
							  			   required = false,
							  			   defaultValue = "") String cookie) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("login")
	public ModelAndView login(HttpServletResponse response,
							  @CookieValue(value = SESSION_ID,
							  			   required = false,
							  			   defaultValue = "") String cookie)
							  throws IOException {

		if (StringUtils.isEmpty(cookie)) {
			cookie = Integer.toString(id);
			response.addCookie(new Cookie(SESSION_ID, cookie));
			id += 1;
		} else {
			// user already has a cookie, let them through
		}

		response.sendRedirect("/messagecentral");

		return null;
	}

}
