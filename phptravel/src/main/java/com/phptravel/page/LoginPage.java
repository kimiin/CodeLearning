package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.phptravel.core.DriverInit;

public class LoginPage {
		
	private String xpathUser="//form[@id='loginfrm']//input[@name='username']";
	public WebElement txtUser=DriverInit.getDriver().findElement(By.xpath(xpathUser));
	
	private String xpathPwd="//form[@id='loginfrm']//input[@name='password']";
	public WebElement txtPwd=DriverInit.getDriver().findElement(By.xpath(xpathPwd));
	
	private String xpathSubmit="//form[@id='loginfrm']//button[@type='submit']";
	public WebElement btnLogin=DriverInit.getDriver().findElement(By.xpath(xpathSubmit));
	
}
