package com.phptravel.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import utility.Constant;
import utility.TestLog;

public class Browser {

	//private BrowserType browserName;
	private WebDriver driver;
	
	public void setBrowser(WebDriver driver){
		this.driver=driver;
	}
	public void goToUrl(String url) {
		driver.get(url);	
		configBrowser();
		//TestLog.info("The URL is launched");		
	}
	public void navigateToUrl(String url) {
		driver.navigate().to(url);	
	}
	public void configBrowser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Constant.SHORT_WAIT, TimeUnit.SECONDS);		 
		//TestLog.info("Complete configure browser");		
	}	
	public void closeBrowser() {
		driver.quit();
		//TestLog.info("Web application is closed.");
	}	
	public String getPageName() {
		String titlePage=driver.getTitle();
		//TestLog.info("Web Page Title is got");
		return titlePage;		
	}
}
