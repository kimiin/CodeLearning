package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravel.core.DriverInit;
import com.phptravel.core.TestBase;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class LandingPageTest extends TestBase{
	
	private LandingPage landingPage;
	private LoginPage loginPage;
		
	@BeforeMethod 
	public void setUp() {
		TestBase.initializeBrowser("chrome");
		DriverInit.browser.goToUrl(Constant.URL);		
	}
		
	@Test (priority=1)	
	public void verifyLoginPageLoadTitle(){		
		loginPage=landingPage.goToLogInPage();		
		Assert.assertEquals(DriverInit.browser.getPageName().trim(), "Login");
	}
	
	@AfterMethod 
	public void tearDown(){		
		DriverInit.browser.closeBrowser();
	}
}
