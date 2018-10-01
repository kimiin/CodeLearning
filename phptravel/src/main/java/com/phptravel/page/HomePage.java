package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.DriverContext;

public class HomePage extends DriverContext{
	
	//private static WebDriver driver;
	
	By lnkHotels=By.xpath("//div[@id='collapse']//a[contains(@href,'hotels')]");
	By headerText=By.xpath("//div[@class='container']//h3[contains(text(),'Hi, ')]");	
	By lnkAccount=By.xpath("//div[@id='collapse']//a[contains(@class,'dropdown-toggle')]/parent::li[@class='']/a");
	By lnkLogOut=By.xpath("//div[@id='collapse']//a[contains(@href,'logout')]");
		
	public HomePage(){
		//driver=DriverInit.getDriver();
	}
		
	public void waitHederText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(headerText));
	}
	
	public HotelPage goToHotelPage() {
		driver.findElement(lnkHotels).click();
		return new HotelPage();
	}
	public LoginPage logOutFromHomePage() {
		driver.findElement(lnkAccount).click();
		driver.findElement(lnkLogOut).click();
		return new LoginPage();
	}
}
