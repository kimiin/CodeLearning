package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.phptravel.core.DriverInit;

public class LandingPage {
	
	private String xpathLinkAccount="//div[@id='collapse']//li[@id='li_myaccount']";
	public WebElement lnkAccount=DriverInit.getDriver().findElement(By.xpath(xpathLinkAccount));
	
	private String xpathLinkLogIn="//div[@id='collapse']//li[@id='li_myaccount']";
	public WebElement lnkLogIn=DriverInit.getDriver().findElement(By.xpath(xpathLinkLogIn));

}
