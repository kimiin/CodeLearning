package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravel.core.DriverAction;
import com.phptravel.core.DriverInit;
import com.phptravel.page.HomePage;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;
import com.phptravel.page.LoginPageAction;

import utility.Constant;
import utility.TestLog;

public class AppTest {

	LandingPage landingPage=new LandingPage();
	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	
	@BeforeTest
	public void startTC01() {
		TestLog.startTestCase("Selenium_Test_001");	   
		DriverInit.getDriverInit();
		DriverAction.openBrowser(Constant.URL);
	}
		
	@Test
	public void TC_Login()
	{
		landingPage.lnkAccount.click();
		landingPage.lnkLogIn.click();
		LoginPageAction.logIn("user@phptravels.com", "demouser", loginPage);
		Assert.assertTrue(homePage.headerText.getText().trim().contains("Hi, Johny Smith"));
 	 	Assert.assertTrue(DriverAction.getTitle().trim().equals("My Account"));           
        TestLog.endTestCase("Selenium_Test_001");	       
	}
	
	@AfterTest
	public void finishTC01()
	{
		DriverAction.closeBrowser();
	}
}
