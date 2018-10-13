package com.phptravel.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.TestLog;

public class TestBase extends Base{
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void initializeBrowser(String browserName) {
		TestLog.info("Init Browser");
		try {
			switch(browserName.trim().toLowerCase()) {
				case BrowserType.CHROME_BROWSER:
					System.setProperty("webdriver.chrome.driver",DriverPath.CHROMEDRIVER_PATH);
					driver=new ChromeDriver();
					wait = new WebDriverWait(driver, Constant.SHORT_WAIT);				
					TestLog.info("New Chrome driver is instantiated");					
					break;
				case BrowserType.FIREFOX_BROWSER:
					System.setProperty("webdriver.gecko.driver",DriverPath.FFDRIVER_PATH);
					driver=new FirefoxDriver();
					wait = new WebDriverWait(driver, Constant.SHORT_WAIT);			
					TestLog.info("New Firefox driver is instantiated");						
					break;
				default:
					TestLog.info("Nothing");			
			}
			DriverInit.setDriver(driver,wait);
			
		} catch(Exception ex) {TestLog.error("Not able to init the browser."+ ex.getMessage());}
		
		
	}	

}
