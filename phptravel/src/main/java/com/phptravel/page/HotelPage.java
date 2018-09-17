package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.phptravel.core.DriverInit;

public class HotelPage {
	
	private String xpathFormFilter="//form[@name='fFilters']";
	public WebElement formFilter=DriverInit.getDriver().findElement(By.xpath(xpathFormFilter));
}
