package sandbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.TestBase;


public class HotelPage extends TestBase {
	
	//private static WebDriver driver;
	
//	By FormFilter=By.xpath("//form[@name='fFilters']");
//	By lnkAccount=By.xpath("//div[@class='container']//ul[contains(@class,'user_menu')]//span[contains(@class,'ink animate')]");
//	By lnkLogOut=By.xpath("//div[@id='collapse']//a[contains(@href,'logout')]");
	@FindBy(how=How.XPATH,using="//form[@name='fFilters']")
	static WebElement FormFilter;
	@FindBy(how=How.XPATH,using="//div[@class='container']//ul[contains(@class,'user_menu')]//span[contains(@class,'ink animate')]")
	static WebElement lnkAccount;
	@FindBy(how=How.XPATH,using="//div[@id='collapse']//a[contains(@href,'logout')]")
	static WebElement lnkLogOut;
	
	public HotelPage(){
		//driver=DriverInit.getDriver();
		//PageFactory.initElements(driver, HotelPage.class);
	}
	
	public void waitFilterHotel() {
		wait.until(ExpectedConditions.elementToBeClickable(FormFilter));
	}
	
	public void logOutFromHotelPage() {
		lnkAccount.click();
		lnkLogOut.click();
	}
}
