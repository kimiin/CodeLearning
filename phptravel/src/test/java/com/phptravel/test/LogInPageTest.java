package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.phptravel.core.DriverAction;
import com.phptravel.core.DriverContext;
import com.phptravel.page.HomePage;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class LogInPageTest extends DriverContext{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@DataProvider(name="UserProvider")
    public Object[][] getDataFromDataprovider(){
		return new Object[][] { {"hoangthuyvi.1991@gmail.com", "123456789"}, {"user@phptravels.com", "demouser"}};
    }
	
	@BeforeTest
	public void setUp() {
		initialization();
		DriverAction.openBrowser(Constant.URL);
	}
		
	@Test (dataProvider="UserProvider")
	public void verifyLoginSuccessfully(String user, String pwd){		
		if(!DriverAction.getTitle().trim().equals("Login")) {
			landingPage=new LandingPage();		
			loginPage = landingPage.goToLogInPage();
		}
		homePage=loginPage.logInUser(user, pwd);	
		homePage.waitHederText();
		Assert.assertEquals(DriverAction.getTitle().trim(), "My Account");
		if(DriverAction.getTitle().trim().equals("My Account")) {
			loginPage=homePage.logOutFromHomePage();
			loginPage.waitLoginForm();
		}
	}
	
	@AfterTest
	public void tearDown(){
		DriverAction.closeBrowser();
	}
}
