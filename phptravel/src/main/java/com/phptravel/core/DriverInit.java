package com.phptravel.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Constant;
import utility.TestLog;

public class DriverInit {

	private static DriverInit instance=new DriverInit();
	private static WebDriver driver=null;
	
	private DriverInit(){
		System.setProperty("webdriver.chrome.driver",Constant.CHROMEDRIVER_PATH);
		driver=new ChromeDriver();
		TestLog.info("New driver instantiated");
	}
	
	public static synchronized DriverInit getDriverInit() {
		return instance;
	}
	
	public static WebDriver getDriver()
	{
		return DriverInit.driver;
	}
}
