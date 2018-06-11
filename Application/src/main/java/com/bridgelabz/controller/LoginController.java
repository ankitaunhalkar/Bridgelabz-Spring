package com.bridgelabz.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;
import com.bridgelabz.service.UserServices;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired
	private UserServices userServices;

	public LoginController(UserServices userServices) {
		this.userServices = userServices;
	}

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public Object home(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {

		User user = userServices.login(login);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("User", user.getName());
			return "redirect:load-data";
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("result", "No user Found");
			return mav;
		}
	}

	@RequestMapping(value = "/load-data", method = RequestMethod.GET)
	public ModelAndView load(HttpSession session) {
		
		Object nameObj = session.getAttribute("User");
		
		if (nameObj == null) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("result", "Please log in");
			return mav;
		}
		
		String name = (String) nameObj;
		User user = userServices.getByName(name);
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("username", user.getName());
		mav.addObject("city", user.getCity());
		mav.addObject("email", user.getEmail());
		return mav;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession httpSession = request.getSession(false);
		httpSession.removeAttribute("User");
		httpSession.invalidate();
		return "login";
	}

}
