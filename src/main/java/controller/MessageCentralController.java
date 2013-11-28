/**
 * @author Jason A Smith <jas7553>
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle all things related to users creating and viewing posts in Message
 * Central.
 */
//@Controller
public class MessageCentralController {

	private static final String SESSION_ID = "SESSION_ID";

	// Pre-populate Message Central with some posts
	private static List<String> messages = new ArrayList<String>();

	{
		messages.add("From {0}: Hello everyone!");
		messages.add("From {1}: Hi, {0} =)");
		messages.add("From {0}: I think this new social media site is really going to catch on");
		messages.add("From {1}: +1");
	}

	// Home page for Message Central. Display all the existing messages.
	@RequestMapping("/messagecentral")
	public ModelAndView index(HttpServletResponse response,
							  @CookieValue(value = SESSION_ID,
							  			   required = false,
							  			   defaultValue = "") String cookie)
							  throws IOException {

		if (StringUtils.isEmpty(cookie)) {
			System.out.println("empty cookie, redirecting...");
			response.sendRedirect("/");
		} else {
			// user already has a cookie, let them through
		}

		ModelAndView mav = new ModelAndView("messagecentral");

		mav.addObject("messages", messages);
		return mav;
	}

	// Allow the user to post a new message. The new message is sent via a
	// request parameter.
	@RequestMapping(value = "/addmessage")
	public ModelAndView addmessage(HttpServletResponse response,
								   @CookieValue(value = SESSION_ID,
								   				required = false,
								   				defaultValue = "") String cookie,
								   @RequestParam(value = "message",
								   				 required = false,
								   				 defaultValue = "") String newMessage)
								   throws IOException {

		if (StringUtils.isEmpty(cookie)) {
			System.out.println("empty cookie, redirecting...");
			response.sendRedirect("/");
		} else {
			// user already has a cookie, let them through
		}

		ModelAndView mav = new ModelAndView("messagecentral");

		if (!StringUtils.isEmpty(newMessage)) {
			messages.add("From {" + cookie + "}: " + newMessage);
		}

		mav.addObject("messages", messages);
		return mav;
	}

	// Detail-view for a message. The user can see a single message at a time,
	// rather than all the messages at once.
	@RequestMapping(value = "/viewmessage", method = RequestMethod.GET)
	public ModelAndView viewmessage(HttpServletResponse response,
									@CookieValue(value = SESSION_ID,
												 required = false,
												 defaultValue = "") String cookie,
									@RequestParam(value = "message_id",
												  required = false,
												  defaultValue = "0") String messageId)
									throws IOException {

		if (StringUtils.isEmpty(cookie)) {
			System.out.println("empty cookie, redirecting...");
			response.sendRedirect("/");
		} else {
			// user already has a cookie, let them through
		}

		ModelAndView mav = new ModelAndView("messagecentral");

		int id = Integer.parseInt(messageId);

		if (id < 0 || id > messages.size() - 1) {
			response.sendError(400, "Message " + id + " does not exist");
		}

		List<String> message = new ArrayList<String>();
		message.add(messages.get(id));
		mav.addObject("messages", message);
		return mav;
	}
}
