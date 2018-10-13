package com.phptravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravel.core.DriverInit;
import com.phptravel.core.TestBase;
import com.phptravel.page.HomePage;
import com.phptravel.page.HotelPage;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class HomePageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	HotelPage hotelPage;
	
	@BeforeTest
	public void setUp() {
		TestBase.initializeBrowser("chrome");
		DriverInit.browser.goToUrl(Constant.URL);		
	}
		
	@Test
	public void verifyHotelPageLoadTitle(){		
		landingPage=new LandingPage();		
		loginPage = landingPage.goToLogInPage();
		homePage=loginPage.logInUser(Constant.USERNAME, Constant.PASSWORD);
		homePage.waitHederText();
		hotelPage=homePage.goToHotelPage();
		hotelPage.waitFilterHotel();
		Assert.assertEquals(DriverInit.browser.getPageName().trim(), "Search Results");
	}
	
	@AfterTest
	public void tearDown(){
		DriverInit.browser.closeBrowser();
	}
}
