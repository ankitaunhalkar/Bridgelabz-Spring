package com.bridgelabz.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridgelabz.messaging.MessageReceiver;
import com.bridgelabz.messaging.MessageSender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MessageSender ms;
	
	@Autowired
	MessageReceiver mr;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		ms.sendMessage("Hello!");
		return "home";
	}
	
	@RequestMapping(value = "/receiver", method = RequestMethod.GET)
	public void receiver() {

		try {
		mr.receiveMessage("recieved");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
