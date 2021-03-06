package com.phptravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.TestBase;


public class HotelPage extends TestBase {
	
	@FindBy(how=How.XPATH,using="//form[@name='fFilters']")
	static WebElement FormFilter;
	@FindBy(how=How.XPATH,using="//div[@class='container']//ul[contains(@class,'user_menu')]//span[contains(@class,'ink animate')]")
	static WebElement lnkAccount;
	@FindBy(how=How.XPATH,using="//div[@id='collapse']//a[contains(@href,'logout')]")
	static WebElement lnkLogOut;
	
	public HotelPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void waitFilterHotel() {
		wait.until(ExpectedConditions.elementToBeClickable(FormFilter));
	}
	
	public void logOutFromHotelPage() {
		lnkAccount.click();
		lnkLogOut.click();
	}
}
