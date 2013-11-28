/**
 * @author Jason A Smith <jas7553>
 */
package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle all things related to entering the site.
 */
@Controller
public class GatewayControllerAdvised {

	private static final String SESSION_ID = "SESSION_ID";

	/**
	 * Home page.
	 */
	@RequestMapping("/")
	public ModelAndView index(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	/**
	 * Page for logging in (i.e., creating an account). Redirect the user to
	 * Message Central once they're authenticated.
	 */
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
