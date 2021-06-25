package com.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	
	WebDriver driver;
	
	public static String baseUrl = "http://apps.qa2qe.cognizant.e-box.co.in/CustomerRegistration";
	
	public WebDriver getDriver() {
		
		System.setProperty ("webdriver.firefox.driver", "./Driver/Geckodriver/geckodriver.exe");
		//System.setProperty ("webdriver.chrome.driver", "./Driver/Chromedriver/chromedriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.navigate().to(DriverSetup.baseUrl);
		
		return driver;
		
	}
	

}
