package automation.OnlineTravel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import appActions.LogIn_Action;
import pageObjects.Home_Page;
import pageObjects.Hotel_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.TestLog;

public class POM_TC {

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",Constant.CHROMEDRIVER_PATH);
 		driver = new ChromeDriver();
 		TestLog.info("New driver instantiated");
 		
 		wait=new WebDriverWait(driver, Constant.SHORT_WAIT);
 		TestLog.info("WebDriverWait applied on the driver for 10 seconds");
 		
 	    driver.get(Constant.URL);
 	    TestLog.info("Web application launched");
 	    
 	 	driver.manage().window().maximize(); 
 	 	TestLog.info("Web application is set maximized.");		 
 	 	
 	 	TestLog.startTestCase("Selenium_Test_001");      
 	 	LogIn_Action.Execute(driver,wait,Constant.USERNAME,Constant.PASSWORD);	 
 	 	if(Home_Page.headerText(driver,wait).getText().trim().contains("Hi, Johny Smith"))
 	 	{
 	 		System.out.println("TC01 is Passed.");
 	 	}
 	 	else
 	 		System.out.println("TC01 is Failed.");
 	 	//Assert.assertTrue(Home_Page.headerText(driver,wait).getText().trim().contains("Hi, Johny Smith"));
 	 	//Assert.assertTrue(driver.getTitle().trim().equals("My Account"));
 	 	TestLog.endTestCase("Selenium_Test_001");	
	   
 	 	TestLog.startTestCase("Selenium_Test_002");      
	    Home_Page.lnk_Hotels(driver,wait).click(); 
	    Home_Page.lnk_Hotels(driver,wait).click(); 
	    Hotel_Page.formFilter(driver, wait);
	    if(driver.getTitle().trim().equals("Search Results"))
 	 	{
 	 		System.out.println("TC02 is Passed.");
 	 	}
 	 	else
 	 		System.out.println("TC02 is Failed.");
	    //Assert.assertTrue(driver.getTitle().trim().equals("Search Results"));
	    TestLog.endTestCase("Selenium_Test_002");	
 	 
 	 	driver.quit();
	}

}
