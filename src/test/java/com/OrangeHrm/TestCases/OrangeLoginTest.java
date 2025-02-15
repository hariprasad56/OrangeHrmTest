package com.OrangeHrm.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OrangeHrm.PageObjects.OrangeHrmHomePage;
import com.OrangeHrm.PageObjects.OrangeHrmLoginPage;
import com.OrangeHrm.Utilities.ReadDataFromXcellSheet;

public class OrangeLoginTest extends BaseTest {
	
	@Test(dataProvider="userpass",dataProviderClass=ReadDataFromXcellSheet.class)
	public void hrmLoginTest(String un, String ps) throws IOException
	{
		
		OrangeHrmHomePage hp=new OrangeHrmHomePage(driver);
		OrangeHrmLoginPage lp=new OrangeHrmLoginPage(driver);
	    loger.info("Enter the user name");
		lp.setUserTextbox(un);
		loger.info("Enter the password");
		lp.setPassTextbox(ps);
		loger.info("Click on login button");
		lp.setLoginButton();
		BaseTest bt=new BaseTest();
		SoftAssert sa=new SoftAssert();
//		if(bt.alertPresent()==true)
//		{
//			Alert al=driver.switchTo().alert();
//			al.accept();
//		}
//		else
//		{
//			System.out.println("ignore");
//		}
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);

		if(actualTitle.equals("Swag Labs"))
		{
			sa.assertTrue(true);
			loger.info("login test is pass");
		}
		else
		{
			sa.assertTrue(false);
			loger.info("login test is fail");
			bt.screenshot(driver,"hrmLoginTest");
		}
		sa.assertAll();
		loger.info("Click on menu bar");
		hp.setMenuBar();
		loger.info("Click on logout button");
		hp.setlogoutButton();
		String actual1Title=driver.getTitle();
		if(actual1Title.equals("Swag Labs"))
		{
			sa.assertTrue(true);
			loger.info("login1 test is pass");
			
		}
		else
		{
			sa.assertTrue(false);
			loger.info("login1 test is fail");
			bt.screenshot(driver,"hrmLoginTest");
			
		}
		sa.assertAll();
	}		
				
}
