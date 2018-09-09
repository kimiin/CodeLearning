package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestLog;

public class Home_Page {
	
	private static WebElement element=null;
	private static String pageName = "Home Page";
	
	public static WebElement headerText(WebDriver driver, WebDriverWait wait) {		
		By elementLocation=By.xpath("//div[@class='row']//h3[contains(text(),'Hi, Johny Smith')]");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
	
	public static WebElement lnk_Hotels(WebDriver driver, WebDriverWait wait) {
		By elementLocation=By.xpath("//div[@id='collapse']//a[contains(@href,'hotels')]");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}	
	
}
