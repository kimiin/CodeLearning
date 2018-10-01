package com.phptravel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.DriverContext;

public class LoginPage extends DriverContext{
	
	//private static WebDriver driver;
	By frmLogin=By.xpath("//form[@id='loginfrm']");
	By txtUser=By.xpath("//form[@id='loginfrm']//input[@name='username']");
	By txtPwd=By.xpath("//form[@id='loginfrm']//input[@name='password']");
	By btnLogin=By.xpath("//form[@id='loginfrm']//button[@type='submit']");
	
	public LoginPage(){
		//driver=DriverInit.getDriver();
	}
	
	public HomePage logInUser(String user, String pwd){
		driver.findElement(txtUser).clear();
		driver.findElement(txtUser).sendKeys(user);
		driver.findElement(txtPwd).clear();
		driver.findElement(txtPwd).sendKeys(pwd);
		driver.findElement(btnLogin).click();
		return new HomePage();
	}
	public void waitLoginForm() {
		wait.until(ExpectedConditions.presenceOfElementLocated(frmLogin));
	}

}
