package com.phptravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.phptravel.core.TestBase;

public class LoginPage extends TestBase{
		
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']")
	static WebElement frmLogin;
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']//input[@name='username']")
	static WebElement txtUser;
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']//input[@name='password']")
	static WebElement txtPwd;
	@FindBy(how=How.XPATH,using="//form[@id='loginfrm']//button[@type='submit']")
	static WebElement btnLogin;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public HomePage logInUser(String user, String pwd){
		txtUser.sendKeys(user);
		txtPwd.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}
	public void waitLoginForm() {
		wait.until(ExpectedConditions.elementToBeClickable(frmLogin));
	}

}
