package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;
import com.bridgelabz.service.UserServices;

@Controller
public class RegisterController {
	@Autowired
	private UserServices userServices;
	
	public RegisterController(UserServices userServices) {
		this.userServices = userServices;
	}

	@RequestMapping("register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	@RequestMapping("registerProcess")
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user ) {
		ModelAndView mav = new ModelAndView("login");
		int status = userServices.register(user);
		if(status==1) {
			mav.addObject("result", "Successfully Registered! Login Here");
		}else {
			mav.addObject("result", "Sorry! Registertion Failed! Re-try Again!");
		}
		return mav;
	}
}
