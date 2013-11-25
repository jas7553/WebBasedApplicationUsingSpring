package security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StringUtils;

@Aspect
public class AuthenticationAspect {

	private static final String SESSION_ID = "SESSION_ID";

	private static int id = 2;

	private static Set<Integer> validIds = new HashSet<Integer>();

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {}

	@Pointcut("within(*..MessageCentralControllerAdvised)")
	public void messageCentral() {}

	@Pointcut("within(*..GatewayControllerAdvised)")
	public void gatewayController() {}

	@Pointcut("execution(@org.springframework.web.bind.annotation.RequestMapping * *.*(..))")
	public void requestMapping() {}

	@Before("messageCentral() && requestMapping() &&" + 
			"args(response, cookie,..)")
	public void authenticationRequired(HttpServletResponse response, String cookie) throws Throwable {
		System.out.println("@Before(messageCentral() && requestMapping())");

		if (StringUtils.isEmpty(cookie)) {
			System.out.println("empty cookie, redirecting...");
			response.sendRedirect("/");

//		} else if (!validIds.contains(Integer.parseInt(cookie))) {
//			System.out.println("invalid cookie, redirecting...");
//			response.sendRedirect("/");

		} else {
			// user already has a cookie, let them through
		}
	}

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
