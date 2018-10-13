package sandbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.TestBase;

public class HomePage extends TestBase{
	
	//private static WebDriver driver;
	
//	By lnkHotels=By.xpath("//div[@id='collapse']//a[contains(@href,'hotels')]");
//	By headerText=By.xpath("//div[@class='container']//h3[contains(text(),'Hi, ')]");	
//	By lnkAccount=By.xpath("//div[@id='collapse']//a[contains(@class,'dropdown-toggle')]/parent::li[@class='']/a");
//	By lnkLogOut=By.xpath("//div[@id='collapse']//a[contains(@href,'logout')]");
		
	@FindBy(how = How.XPATH, using = "//div[@id='collapse']//a[contains(@href,'hotels')]")
	static WebElement lnkHotels;
	@FindBy(how = How.XPATH, using = "//div[@class='container']//h3[contains(text(),'Hi, ')]")
	static WebElement headerText;
	@FindBy(how = How.XPATH, using = "//div[@id='collapse']//a[contains(@class,'dropdown-toggle')]/parent::li[@class='']/a")
	static WebElement lnkAccount;
	@FindBy(how = How.XPATH, using = "//div[@id='collapse']//a[contains(@href,'logout')]")
	static WebElement lnkLogOut;
	
	public HomePage(){
		//driver=DriverInit.getDriver();
		PageFactory.initElements(driver, this);
	}
		
	public void waitHederText() {
		wait.until(ExpectedConditions.elementToBeClickable(headerText));
	}
	
	public HotelPage goToHotelPage() {
		//driver.findElement(lnkHotels).click();
		lnkHotels.click();
		return new HotelPage();
	}
	public LoginPage logOutFromHomePage() {
//		driver.findElement(lnkAccount).click();
//		driver.findElement(lnkLogOut).click();
		lnkAccount.click();
		lnkLogOut.click();
		return new LoginPage();
	}
}
