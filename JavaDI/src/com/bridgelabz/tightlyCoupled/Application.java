package com.bridgelabz.tightlyCoupled;

public class Application { 
//	private EmailService email = new EmailService(); //if we want to use advanced email service we have hard code to make changes in this application
	private EmailService email = null;
	public Application(EmailService es) {
		this.email = es;
	}
	public void processMessage(String msg, String rec) {
		this.email.sendEmail(msg, rec);
	}
}
