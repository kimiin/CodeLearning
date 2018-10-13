package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.phptravel.core.DriverInit;
import com.phptravel.core.TestBase;
import com.phptravel.page.HomePage;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class LogInPageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@DataProvider(name="UserProvider")
    public Object[][] getDataFromDataprovider(){
		return new Object[][] {{"user@phptravels.com", "demouser"}};
    }
	
	@BeforeTest
	public void setUp() {
		TestBase.initializeBrowser("chrome");
		DriverInit.browser.goToUrl(Constant.URL);	
	}
		
	@Test (dataProvider="UserProvider")
	public void verifyLoginSuccessfully(String user, String pwd){		
		
		landingPage = new LandingPage();
		loginPage = landingPage.goToLogInPage();	
		homePage=loginPage.logInUser(user, pwd);	
		homePage.waitHederText();
	    Assert.assertEquals(DriverInit.browser.getPageName().trim(), "My Account");	
	}
	
	@AfterTest
	public void tearDown(){
		DriverInit.browser.closeBrowser();
	}
}
