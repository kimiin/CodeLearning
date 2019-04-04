package com.phptravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.phptravel.core.TestBase;

public class LandingPage extends TestBase{
	
	@FindBy(how=How.XPATH,using="//div[@class='container']//li[@id='li_myaccount']")
	static WebElement lnkAccount;
	@FindBy(how=How.XPATH,using="//div[@class='container']//li[@id='li_myaccount']//a[contains(@href,'login')]")
	static WebElement lnkLogIn;
	
	
	public LandingPage(){	
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage goToLogInPage() {
		lnkAccount.click();
		lnkLogIn.click();
		return new LoginPage();
	}

}
