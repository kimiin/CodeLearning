package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravel.core.DriverAction;
import com.phptravel.core.DriverContext;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class LandingPageTest extends DriverContext{
	
	private LandingPage landingPage;
	private LoginPage loginPage;
		
	@BeforeMethod 
	public void setUp() {
		initialization();
		DriverAction.openBrowser(Constant.URL);
	}
		
	@Test (priority=1)	
	public void verifyLoginPageLoadTitle(){		
		landingPage=new LandingPage();		
		loginPage = landingPage.goToLogInPage();
		Assert.assertEquals(DriverAction.getTitle().trim(), "Login");
	}
	
	@AfterMethod 
	public void tearDown(){		
		DriverAction.closeBrowser();
	}
}
