package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestLog;

public class LogIn_Page {

	private static WebElement element=null;
	private static String pageName = "LogIn Page";
	
	public static WebElement txt_Email(WebDriver driver, WebDriverWait wait) {		
		By elementLocation=By.xpath("//form[@id='loginfrm']//input[@name='username']");	
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
	
	public static WebElement txt_Password(WebDriver driver, WebDriverWait wait) {
		By elementLocation=By.xpath("//form[@id='loginfrm']//input[@name='password']");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
	
	public static WebElement btn_LogIn(WebDriver driver, WebDriverWait wait) {
		By elementLocation=By.xpath("//form[@id='loginfrm']//button[@type='submit']");
		element = wait.until(ExpectedConditions.elementToBeClickable(elementLocation));		
		TestLog.info("The element: "+element.toString()+" of " +pageName +" is found");
		return element;
	}
}
