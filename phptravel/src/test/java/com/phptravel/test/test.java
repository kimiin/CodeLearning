package com.phptravel.test;

import org.testng.Assert;

import com.phptravel.core.DriverInit;
import com.phptravel.core.TestBase;
import com.phptravel.page.HomePage;
import com.phptravel.page.HotelPage;
import com.phptravel.page.LandingPage;
import com.phptravel.page.LoginPage;

import utility.Constant;

public class test {

	public static void main(String[] args) {
		
		LandingPage landingPage;
		LoginPage loginPage;
		HomePage homePage;
		HotelPage hotelPage;
			
		//============		
		TestBase.initializeBrowser("chrome");
		DriverInit.browser.goToUrl(Constant.URL);	
	
		landingPage=new LandingPage();		
		loginPage = landingPage.goToLogInPage();
		Assert.assertEquals(DriverInit.browser.getPageName().trim(), "Login");
		
		DriverInit.browser.closeBrowser();
		
		//=============
		TestBase.initializeBrowser("chrome");
		DriverInit.browser.goToUrl(Constant.URL);	
	
		landingPage=new LandingPage();		
		loginPage = landingPage.goToLogInPage();
		homePage=loginPage.logInUser(Constant.USERNAME, Constant.PASSWORD);
		//homePage.waitHederText();
		hotelPage=homePage.goToHotelPage();
		hotelPage.waitFilterHotel();
		Assert.assertEquals(DriverInit.browser.getPageName().trim(), "Search Results");
		
		DriverInit.browser.closeBrowser();
		
		
	}

}
