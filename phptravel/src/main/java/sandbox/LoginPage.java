package sandbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.TestBase;

public class LoginPage extends TestBase{
	
	//private static WebDriver driver;
//	By frmLogin=By.xpath("//form[@id='loginfrm']");
//	By txtUser=By.xpath("//form[@id='loginfrm']//input[@name='username']");
//	By txtPwd=By.xpath("//form[@id='loginfrm']//input[@name='password']");
//	By btnLogin=By.xpath("//form[@id='loginfrm']//button[@type='submit']");
	
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']")
	static WebElement frmLogin;
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']//input[@name='username']")
	static WebElement txtUser;
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']//input[@name='password']")
	static WebElement txtPwd;
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']//button[@type='submit']")
	static WebElement btnLogin;
	
	
	public LoginPage(){
		//driver=DriverInit.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public HomePage logInUser(String user, String pwd){
//		driver.findElement(txtUser).clear();
//		driver.findElement(txtUser).sendKeys(user);
//		driver.findElement(txtPwd).clear();
//		driver.findElement(txtPwd).sendKeys(pwd);
//		driver.findElement(btnLogin).click();
		//txtUser.clear();
		txtUser.sendKeys(user);
		//txtPwd.clear();
		txtPwd.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}
	public void waitLoginForm() {
		wait.until(ExpectedConditions.elementToBeClickable(frmLogin));
	}

}
