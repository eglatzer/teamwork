package com.ilad.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	WebDriver driver;
	
	//constructor
	public WebDriverFactory(KindOfWebDriver kindOfWebDriver) throws NullPointerException {
		switch(kindOfWebDriver.getValue()) {
			case 0:
				driver = new FirefoxDriver();
				break;
			case 1:
				System.setProperty("webdriver.chrome.driver",
						"/home/developer/Desktop/chromedriver");
				driver = new ChromeDriver();
				break;
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public enum KindOfWebDriver {
		FIREFOX(0), CHROME(1);
		
		private int value;
		
		//Constructor
		private KindOfWebDriver(int value_) {
			value = value_;
		}
		
		//Getter
		private int getValue() {
			return value;
		}
	};
}
