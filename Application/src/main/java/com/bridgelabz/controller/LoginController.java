package com.bridgelabz.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);	
		return "login";
	}
	
	@RequestMapping(value = "/loginProcess")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
