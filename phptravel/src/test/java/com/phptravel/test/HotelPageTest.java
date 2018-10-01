package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravel.core.DriverAction;
import com.phptravel.core.DriverContext;
import com.phptravel.page.HomePage;
import com.phptravel.page.HotelPage;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class HotelPageTest extends DriverContext{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	HotelPage hotelPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		DriverAction.openBrowser(Constant.URL);
	}
			
	@Test
	public void verifyHotelPageLoadTitle(){		
		landingPage=new LandingPage();		
		loginPage = landingPage.goToLogInPage();
		homePage=loginPage.logInUser(Constant.USERNAME, Constant.PASSWORD);
		homePage.waitHederText();
		hotelPage=homePage.goToHotelPage();
		hotelPage.waitFilterHotel();
		Assert.assertEquals(DriverAction.getTitle().trim(), "Search Results");
	}
	
	@AfterMethod
	public void tearDown(){
		DriverAction.closeBrowser();
	}
}
