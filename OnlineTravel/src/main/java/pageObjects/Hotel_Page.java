package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestLog;

public class Hotel_Page {
	
	private static WebElement element=null;
	private static String pageName = "Home Page";
	
	public static WebElement formFilter(WebDriver driver, WebDriverWait wait) {		
		By elementLocation=By.xpath("//form[@name='fFilters']");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
}
