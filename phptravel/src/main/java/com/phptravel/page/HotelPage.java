package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.DriverContext;

public class HotelPage extends DriverContext {
	
	//private static WebDriver driver;
	
	By FormFilter=By.xpath("//form[@name='fFilters']");
	By lnkAccount=By.xpath("//div[@class='container']//ul[contains(@class,'user_menu')]//span[contains(@class,'ink animate')]");
	By lnkLogOut=By.xpath("//div[@id='collapse']//a[contains(@href,'logout')]");
	
	
	public HotelPage(){
		//driver=DriverInit.getDriver();
	}
	
	public void waitFilterHotel() {
		wait.until(ExpectedConditions.presenceOfElementLocated(FormFilter));
	}
	
	public void logOutFromHotelPage() {
		driver.findElement(lnkAccount);
		driver.findElement(lnkLogOut);
	}
}
