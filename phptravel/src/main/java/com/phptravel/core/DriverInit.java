package com.phptravel.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInit {

	public static WebDriver driver;
	public static Browser browser;
	public static WebDriverWait wait;
	
	static WebDriver getDriver() {
		return driver;
	}
	
	static void setDriver(WebDriver driver, WebDriverWait wait) {
		DriverInit.driver=driver;
		DriverInit.wait=wait;
		browser=new Browser();
		browser.setBrowser(getDriver());
	}
}
