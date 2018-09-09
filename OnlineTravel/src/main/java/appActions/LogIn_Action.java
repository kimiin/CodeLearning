package appActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Landing_Page;
import pageObjects.LogIn_Page;
import utility.ExcelUtils;
import utility.TestLog;

public class LogIn_Action {

	public static void Execute(WebDriver driver, WebDriverWait wait) 
	{
		Landing_Page.lnk_MyAccount(driver,wait).click();
		Landing_Page.lnk_LogIn(driver,wait).click();		   		
		LogIn_Page.txt_Email(driver,wait).sendKeys("user@phptravels.com");
		LogIn_Page.txt_Password(driver,wait).sendKeys("demouser");
		LogIn_Page.btn_LogIn(driver,wait).click();
	}
	
	public static void Executes(WebDriver driver, WebDriverWait wait) 
	{
		String sUserName = ExcelUtils.getCelData(1, 1);	
		TestLog.info("Username picked from Excel is "+ sUserName );
		String sPassword = ExcelUtils.getCelData(1, 2);
		TestLog.info("Password picked from Excel is "+ sUserName );
		
		Landing_Page.lnk_MyAccount(driver,wait).click();
		TestLog.info("Click action performed on My Account link");
		Landing_Page.lnk_LogIn(driver,wait).click();
		TestLog.info("Click action performed on Login link");
		
		LogIn_Page.txt_Email(driver,wait).sendKeys(sUserName);
		TestLog.info("Username entered in the Email text box");
		LogIn_Page.txt_Password(driver,wait).sendKeys(sPassword);
		TestLog.info("Pasword entered in the Password text box");
		
		LogIn_Page.btn_LogIn(driver,wait).click();
		TestLog.info("Click action performed on Login button");
	}
	
	
	
	public static void Execute(WebDriver driver, WebDriverWait wait, String strUserName, String strPwd) 
	{
		Landing_Page.lnk_MyAccount(driver,wait).click();
		Landing_Page.lnk_LogIn(driver,wait).click();		   		
		LogIn_Page.txt_Email(driver,wait).sendKeys(strUserName);
		LogIn_Page.txt_Password(driver,wait).sendKeys(strPwd);
		LogIn_Page.btn_LogIn(driver,wait).click();
	}
}
