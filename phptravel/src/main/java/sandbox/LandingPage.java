package sandbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.phptravel.core.TestBase;

public class LandingPage extends TestBase{
	
	//private static WebDriver driver;
	
//	By lnkAccount=By.xpath("//div[@id='collapse']//li[@id='li_myaccount']");		
//	By lnkLogIn=By.xpath("//div[@id='collapse']//li[@id='li_myaccount']//a[contains(@href,'login')]");
	@FindBy(how=How.XPATH,using="//div[@id='collapse']//li[@id='li_myaccount']")
	static WebElement lnkAccount;
	@FindBy(how=How.XPATH,using="//div[@id='collapse']//li[@id='li_myaccount']//a[contains(@href,'login')]")
	static WebElement lnkLogIn;
	
	
	public LandingPage(){
//		driver=DriverInit.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage goToLogInPage() {
//		driver.findElement(lnkAccount).click();
//		driver.findElement(lnkLogIn).click();	
		lnkAccount.click();
		lnkLogIn.click();
		return new LoginPage();
	}

}
