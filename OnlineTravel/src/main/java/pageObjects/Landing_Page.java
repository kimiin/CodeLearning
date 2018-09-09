package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestLog;

public class Landing_Page {
	
	private static WebElement element=null;
	private static String pageName = "Landing Page";
	
	public static WebElement lnk_MyAccount(WebDriver driver, WebDriverWait wait) {			
		By elementLocation=By.xpath("//div[@id='collapse']//li[@id='li_myaccount']");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
	
	public static WebElement lnk_LogIn(WebDriver driver, WebDriverWait wait) {		
		By elementLocation=By.xpath("//div[@id='collapse']//li[@id='li_myaccount']//a[contains(@href,'login')]");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
}
