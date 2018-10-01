package com.phptravel.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Constant;
import utility.TestLog;

public class DriverInit {

	private static DriverInit instance;
	private static WebDriver driver;
	
	private DriverInit(){
		System.setProperty("webdriver.chrome.driver",Constant.CHROMEDRIVER_PATH);
		driver=new ChromeDriver();
		TestLog.info("New Chrome driver is instantiated");
	}
	
	public static synchronized DriverInit getDriverInit() {
		instance=new DriverInit();	
		return instance;
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
		
}
