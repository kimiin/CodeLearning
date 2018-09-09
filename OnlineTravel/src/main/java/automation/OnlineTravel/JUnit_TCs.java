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

public class JUnit_TCs {
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	@Before
	public void beforeMethod() throws Exception{
        
        System.setProperty("webdriver.chrome.driver",Constant.CHROMEDRIVER_PATH);
 		driver = new ChromeDriver();
 		TestLog.info("New driver instantiated");
 		
 		wait=new WebDriverWait(driver, Constant.SHORT_WAIT);
 		TestLog.info("WebDriverWait applied on the driver for 10 seconds");
 		
 	    driver.get(Constant.URL);
 	    TestLog.info("Web application launched");
 	    
 	 	driver.manage().window().maximize(); 
 	 	TestLog.info("Web application is set maximized.");
	}
	
	@Test
	public void TC01_Login() {
		
		TestLog.startTestCase("Selenium_Test_001");      
		ExcelUtils.openTestData(Constant.PATH_TESTDATA + Constant.FILE_TESTDATA+".xlsx", Constant.SHEETNAME); 
	    TestLog.info(" Excel sheet opened");
        LogIn_Action.Executes(driver,wait);
        Assert.assertTrue(Home_Page.headerText(driver,wait).getText().trim().contains("Hi, Johny Smith"));
 	 	Assert.assertTrue(driver.getTitle().trim().equals("My Account"));
 	 	ExcelUtils.setCellData("Pass", 1, 3);
        TestLog.info("Write results to excel file.");       
        TestLog.endTestCase("Selenium_Test_001");	       
	}
	
	@Test
	public void TC02_AccessToHotelsPage() {
			
		TestLog.startTestCase("Selenium_Test_002");
		ExcelUtils.openTestData(Constant.PATH_TESTDATA + Constant.FILE_TESTDATA+".xlsx", Constant.SHEETNAME); 	  
        LogIn_Action.Executes(driver,wait);	
	    Home_Page.lnk_Hotels(driver,wait).click(); 
	    Home_Page.lnk_Hotels(driver,wait).click(); 
	    Hotel_Page.formFilter(driver, wait);
	    Assert.assertTrue(driver.getTitle().trim().equals("Search Results"));
	    ExcelUtils.setCellData("Pass", 2, 3);
	    TestLog.endTestCase("Selenium_Test_002");	   
	}
	
	@After
	public void afterMethod() {	 
		  driver.quit();
	 }
}
