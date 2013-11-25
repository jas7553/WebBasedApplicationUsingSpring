package test;

import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

/*
	@Before("requestMapping()")
	public void b() throws Throwable {
		System.out.println("before request mapping...");
	}
*/
//	@Pointcut("execution(@org.springframework.web.bind.annotation.RequestMapping * *.*(..))")
//	private static int callCount = 0;
//	@Before("execution(* *.*(..))")
//	public void advice() throws Throwable {
//		System.out.println("TESTING");
//	}
//	@Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
//	public void requestMapping() {}
/*
	@Around("execution(String *.*(..))")
	public Object advice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("TESTING TESTING");
		callCount += 1;
		System.out.println("callCount: " + callCount);
		return (String) pjp.proceed();
	}
*/
/*
	@Around("execution(String *.login(..))")
	public Object advice2(ProceedingJoinPoint pjp) throws Throwable {
		String serviceGreeting = (String) pjp.proceed();
		return "greeting2";
	}
*/
/*
	private static Map<String, User> userDatabase = new HashMap<String, User>();

	private final static String COOKIE = "COOKIE_NAME";

	private static int id = 0;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "firstName", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("firstName", name);
		return "greeting";
	}

	@RequestMapping("/example")
	public String displayHeaderInfo(@CookieValue(value = COOKIE, required = false, defaultValue = "") String cookie, Model model) {
		System.out.println("cookie: {" + cookie + "}");

		if (StringUtils.isEmpty(cookie)) {
			return "404";
		} else {
			model.addAttribute("user_id", cookie);
			return "greeting";
		}
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletResponse response) {
		System.out.println("logging them in...");
		System.out.println("giving them id #" + id);

		response.addCookie(new Cookie(COOKIE, Integer.toString(id)));

		try {
			response.sendError(401, "derp");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("greeting");
		mav.addObject("user_id", id);

		id += 1;

		return mav;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpServletResponse response) {
//		try {
//			response.sendError(418);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return new ModelAndView("index");
	}
*/
/*
	@RequestMapping("/example")
	public String displayHeaderInfo(@CookieValue(value = SESSION_ID, required = false, defaultValue = "") String cookie, Model model) {
		System.out.println("cookie: {" + cookie + "}");

		if (StringUtils.isEmpty(cookie)) {
			return "404";
		} else {
			model.addAttribute("user_id", cookie);
			return "greeting2";
		}
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletResponse response) {
		System.out.println("logging them in...");
		System.out.println("giving them id #" + id);

		response.addCookie(new Cookie(SESSION_ID, Integer.toString(id)));

		try {
			response.sendError(401, "derp");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView("greeting2");
		mav.addObject("user_id", id);

		id += 1;

		return mav;
	}
*/


//	private static Map<String, User> userDatabase = new HashMap<String, User>();

//	private static int id = 0;

//	@RequestMapping("*")
//	public ModelAndView index(HttpServletResponse response) {
//
//		try {
//			response.sendRedirect("/404");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return new ModelAndView("index");
//	}

/*
	@RequestMapping("join")
	public ModelAndView join(HttpServletResponse response) {
		System.out.println("at join()");

		Cookie cookie = new Cookie(SESSION_ID, Integer.toString(id));

		// here, have a cookie
		response.addCookie(cookie);

		ModelAndView mav = new ModelAndView("index");

		return mav;
	}
*/
/*
	@RequestMapping("/test")
	public ModelAndView test(@CookieValue(value = SESSION_ID, required = false, defaultValue = "") String cookie, HttpServletResponse response) {
		System.out.println("cookie: {" + cookie + "}");

		if (StringUtils.isEmpty(cookie)) {
			return new ModelAndView("404");

		} else {
			ModelAndView mav = new ModelAndView("greeting");
			mav.addObject("name", "worldddd");
			return mav;
		}
	}

	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("greeting");
		mav.addObject("name", "worldddd");
		return mav;
	}
*/
}
