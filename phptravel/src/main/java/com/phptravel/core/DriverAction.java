package com.phptravel.core;

import utility.TestLog;

public class DriverAction {
	
	public static void openBrowser(String url) {
		DriverInit.getDriver().get(url);	
		TestLog.info("Web application launched");
		DriverInit.getDriver().manage().window().maximize();
		TestLog.info("Web application is set maximized.");		
	}
	
	public static void closeBrowser() {
		DriverInit.getDriver().quit();
		TestLog.info("Web application is closed.");
	}
	
	public static String getTitle() {		
		return DriverInit.getDriver().getTitle();
		//TestLog.info("Web Page Title is got");
	}
}
