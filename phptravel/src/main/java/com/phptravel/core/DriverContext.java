package com.phptravel.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.TestLog;

public class DriverContext {
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver",Constant.CHROMEDRIVER_PATH);
		driver=new ChromeDriver();
		TestLog.info("New Chrome driver is instantiated");
		wait = new WebDriverWait(driver, Constant.SHORT_WAIT);
	}
}
