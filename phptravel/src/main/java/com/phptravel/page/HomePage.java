package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.phptravel.core.DriverInit;

public class HomePage {
	
	private String xpathHeaderText="//div[@class='row']//h3[contains(text(),'Hi, Johny Smith')]";
	public WebElement headerText=DriverInit.getDriver().findElement(By.xpath(xpathHeaderText));
	
	private String xpathLinkHotels="//div[@id='collapse']//a[contains(@href,'hotels')]";
	public WebElement linkHotels=DriverInit.getDriver().findElement(By.xpath(xpathLinkHotels));	
}
