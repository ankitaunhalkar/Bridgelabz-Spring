package com.bridgelabz.tightlyCoupled;

public class LegacyTest {
	public static void main(String[] args) {
		// Application app = new Application();
		Application app = new Application(new EmailService());// Bad Choice cause we have to create object of
																// emailService every time and client application have to create emailService object
		app.processMessage("Hello", "Madhuri");
	}
}
