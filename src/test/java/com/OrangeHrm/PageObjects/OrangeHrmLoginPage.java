package com.OrangeHrm.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHrm.TestCases.BaseTest;

public class OrangeHrmLoginPage {
	public WebDriver driver;
	public BaseTest bt;
	public OrangeHrmLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='user-name']")private WebElement userTextbox;
	@FindBy(xpath="//input[@id='password']")private WebElement passTextbox;
	@FindBy(xpath="//input[@id='login-button']")private WebElement loginButton;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")private WebElement forgotPassword;
	
	public void setUserTextbox(String uName)
	{
		 bt=new BaseTest();
		 bt.wait(userTextbox,20);
		userTextbox.sendKeys(uName);
	}
	public void setPassTextbox(String pTextbox)
	{
		 bt.wait(passTextbox,20);
		passTextbox.sendKeys(pTextbox);
	}
	public void setLoginButton()
	{
		 bt.wait(loginButton,10);
		loginButton.click();
	}
	public void setForgotLink()
	{
		 bt.wait(forgotPassword,10);
		forgotPassword.click();
	}

}
