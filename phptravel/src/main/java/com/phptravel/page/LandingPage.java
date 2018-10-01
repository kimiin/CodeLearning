package com.phptravel.page;

import org.openqa.selenium.By;
import com.phptravel.core.DriverContext;

public class LandingPage extends DriverContext{
	
	//private static WebDriver driver;
	
	By lnkAccount=By.xpath("//div[@id='collapse']//li[@id='li_myaccount']");		
	By lnkLogIn=By.xpath("//div[@id='collapse']//li[@id='li_myaccount']//a[contains(@href,'login')]");

	public LandingPage(){
//		driver=DriverInit.getDriver();
	}
	
	public LoginPage goToLogInPage() {
		driver.findElement(lnkAccount).click();
		driver.findElement(lnkLogIn).click();		
		return new LoginPage();
	}

}
