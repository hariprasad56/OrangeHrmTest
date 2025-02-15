package com.OrangeHrm.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OrangeHrm.Utilities.ReadDataFromPropertiesFile;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public static WebDriver driver;
public static SimpleDateFormat sdf;
public static Date date;
public static String dformat;
public static String reportName;
  public Logger loger;
ReadDataFromPropertiesFile rd=new ReadDataFromPropertiesFile();
String usName=rd.getUserName();
String usPass=rd.getPassword();
@Parameters("browser")
@BeforeClass()
public void setup(String browser)
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable notifications");
	options.setBinary("C:\\Users\\bobbi\\Downloads\\chrome-win64 (2)\\chrome-win64");
	if(browser.equals("chrome"))
	{
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\bobbi\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64");
        driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	loger =LogManager.getLogger(this.getClass());
     loger.info("Enter the url");
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
}
public void wait(final WebElement ele,long time)
{
	try {
		Wait<WebDriver>myWait=new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(20))
		.pollingEvery(Duration.ofSeconds(5))
		.ignoring(NoSuchElementException.class);
		myWait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver)
			{
				return ele;
			}
		});
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
public String screenshot(WebDriver driver,String tname) throws IOException
{
	TakesScreenshot sh=(TakesScreenshot)driver;
	File sc=sh.getScreenshotAs(OutputType.FILE);
	sdf=new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
	date=new Date();
	dformat=sdf.format(date);
	reportName=tname+"_"+dformat+".png";
	String path=System.getProperty("user.dir")+"/Screenshots/"+reportName;
	File destination=new File(path);
	Files.copy(sc, destination);
	
	return path;
}
public boolean alertPresent()
{
	try {
	driver.switchTo().alert();
	return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}
@AfterClass()
public void tearDown()
{
	driver.quit();
}
}
