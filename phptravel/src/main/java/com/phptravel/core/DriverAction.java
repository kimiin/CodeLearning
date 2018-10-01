package com.phptravel.core;

import utility.TestLog;

public class DriverAction extends DriverContext{
	
	public static void openBrowser(String url) {
		driver.get(url);	
		TestLog.info("Web application launched");
		driver.manage().window().maximize();
		TestLog.info("Web application is set maximized.");		
	}
	
	public static void closeBrowser() {
		driver.quit();
		TestLog.info("Web application is closed.");
	}
	
	public static String getTitle() {
		String titlePage=driver.getTitle();
		TestLog.info("Web Page Title is got");
		return titlePage;		
	}
}
