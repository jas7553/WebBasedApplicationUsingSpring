/**
 * @author Jason A Smith <jas7553>
 */
package security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StringUtils;

/**
 * This aspect abstracts authentication from across multiple controllers. It
 * authenticates users based on a cookie they have set in their browser. Upon
 * logging in, a cookie is set (with a session id), and on subsequent requests,
 * that cookie is checked.
 */
@Aspect
public class AuthenticationAspect {

	private static final String SESSION_ID = "SESSION_ID";

	// Begin the id at 2 because there are some pre-populated posts
	private static int id = 2;

	// Remember the valid id's that have been given out
	private static Set<Integer> validIds = new HashSet<Integer>();

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {}

	@Pointcut("within(*..MessageCentralControllerAdvised)")
	public void messageCentral() {}

	@Pointcut("within(*..GatewayControllerAdvised)")
	public void gatewayController() {}

	@Pointcut("execution(@org.springframework.web.bind.annotation.RequestMapping * *.*(..))")
	public void requestMapping() {}

	/**
	 * Authentication is required at these pointcuts. Check the user's cookie
	 * and redirect them to the login page if they're unauthorized.
	 */
	@Before("messageCentral() && requestMapping() &&" + 
			"args(response, cookie,..)")
	public void authenticationRequired(HttpServletResponse response, String cookie) throws Throwable {
		System.out.println("@Before(messageCentral() && requestMapping())");

		if (StringUtils.isEmpty(cookie)) {
			System.out.println("empty cookie, redirecting...");
			response.sendRedirect("/");

		} else {
			// user already has a cookie, let them through
		}
	}

	/**
	 * Set the user's cookie with a session id.
	 */
	@Before("gatewayController() && requestMapping() &&" + 
			"args(response, cookie)")
	public void login(HttpServletResponse response, String cookie) throws Throwable {
		if (StringUtils.isEmpty(cookie)) {
			cookie = Integer.toString(id);
			response.addCookie(new Cookie(SESSION_ID, cookie));

			validIds.add(id);

			id += 1;
		} else {
			// user already has a cookie, let them through
		}
	}

}
