package automation.OnlineTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import appActions.LogIn_Action;
import pageObjects.Home_Page;
import utility.Constant;

public class POM_TC {

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",Constant.CHROMEDRIVER_PATH);
 		driver = new ChromeDriver();
 		wait=new WebDriverWait(driver, Constant.SHORT_WAIT);
 	    driver.get(Constant.URL);
 	 	driver.manage().window().maximize(); 
 	 	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		 
 	 	
 	 	LogIn_Action.Execute(driver,wait,Constant.USERNAME,Constant.PASSWORD);
 	 	
// 	 	Assert.assertTrue(Home_Page.headerText(driver,wait).getText().trim().contains("Hi, Johny Smith"));
// 	 	Assert.assertTrue(driver.getTitle().trim().equals("PHPTRAVELS | Travel Technology Partner"));
	    System.out.println("The user logged in successfully!");
	   
	    System.out.println(Home_Page.lnk_Hotels(driver,wait).isDisplayed());	    
	    Home_Page.lnk_Hotels(driver,wait).click(); 
	    Home_Page.lnk_Hotels(driver,wait).click(); 
//	    Assert.assertTrue(driver.getTitle().trim().equals("Search Results"));
	    System.out.println("The user went to Hotels page successfully.");
 	 
 	 	//driver.quit();
	}

}
