package com.phptravel.page;

public class LoginPageAction {
	
	public static void logIn(String user, String pwd, LoginPage loginPage) 
	{
		loginPage.txtUser.sendKeys(user);
		loginPage.txtPwd.sendKeys(pwd);
		loginPage.btnLogin.click();
	}
}
