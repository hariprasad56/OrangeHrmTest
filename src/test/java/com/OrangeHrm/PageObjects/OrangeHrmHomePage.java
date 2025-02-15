package com.OrangeHrm.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHrm.TestCases.BaseTest;

public class OrangeHrmHomePage {
	public WebDriver driver;
	public BaseTest bt;
	public OrangeHrmHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement addToCartButton;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logoutButton;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement cartButton;
	@FindBy(xpath="//button[text()='Open Menu']")private WebElement mBar;
	@FindBy(xpath="//button[@id='checkout']")private WebElement checkoutButton;
	@FindBy(xpath="//button[@id='continue-shopping']")private WebElement continueButton;
	
	public void setAddtoCart()
	{
		 bt=new BaseTest();
		bt.wait(addToCartButton, 15);
		addToCartButton.click();
	}
	public void setlogoutButton()
	{
		//bt.wait(logoutButton, 50);
		logoutButton.click();
	}
	public void setCartButton()
	{
		bt.wait(cartButton, 15);
		cartButton.click();
	}
	public void setMenuBar()
	{
		//bt.wait(mBar, 50);
		mBar.click();
	}
	public void seCheckoutButton()
	{
		bt.wait(checkoutButton, 15);
		checkoutButton.click();
	}
	public void setContButton()
	{
		bt.wait(continueButton, 15);
		continueButton.click();
	}
	








}
