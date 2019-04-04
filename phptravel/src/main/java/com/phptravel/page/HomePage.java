package com.phptravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.TestBase;

public class HomePage extends TestBase{
		
	@FindBy(how = How.XPATH, using = "//div[@class='container']//li[@data-title='hotels']")
	static WebElement lnkHotels;
	@FindBy(how = How.XPATH, using = "//div[@class='container']//h3[contains(text(),'Hi, ')]")
	static WebElement headerText;
	@FindBy(how = How.XPATH, using = "//div[@id='collapse']//a[contains(@class,'dropdown-toggle')]/parent::li[@class='']/a")
	static WebElement lnkAccount;
	@FindBy(how = How.XPATH, using = "//div[@id='collapse']//a[contains(@href,'logout')]")
	static WebElement lnkLogOut;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
		
	public void waitHederText() {
		wait.until(ExpectedConditions.elementToBeClickable(headerText));
	}
	
	public HotelPage goToHotelPage() {
		
		lnkHotels.click();
		return new HotelPage();
	}
	public LoginPage logOutFromHomePage() {
		lnkAccount.click();
		lnkLogOut.click();
		return new LoginPage();
	}
}
