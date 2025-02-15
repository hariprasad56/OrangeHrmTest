package com.OrangeHrm.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener{
	public static ExtentSparkReporter esr;
	public static ExtentReports er;
	public ExtentTest test;
	public String tName;
	public String repName;
	public String repName1;
	
  public void onStart(ITestContext testContext)
  {
	  SimpleDateFormat sdf  =new SimpleDateFormat("dd-MM-YYYY,HH-mm-ss");
	  Date dt=new Date();
	  String dateFormat=sdf.format(dt);
	  repName=testContext.getName()+dateFormat+".html";
	  repName1=testContext.getName()+dateFormat+".png";
	    esr=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports1/"+repName);
        er =new ExtentReports();
        er.attachReporter(esr);
        esr.config().setDocumentTitle("OrangeHRM");
		esr.config().setReportName("Test Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a'('zzz')'");
		er.setSystemInfo("Host name", "Localhost");
		er.setSystemInfo("Environment", "QA");
		er.setSystemInfo("user", "Hari");
	  
  }
  public void onSucess(ITestResult result)
  {
	    tName=result.getName();
	    test=er.createTest(tName);
	    test.log(Status.INFO, "actual out put is matched with excepted out put");
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tName+"-Test Case Pass",ExtentColor.GREEN));
  }
  public void onFailure(ITestResult result)
  {
	  tName=result.getName();
	  test=er.createTest(tName);
	  test.assignCategory(result.getMethod().getGroups());
	  test.createNode(result.getName());
	  test.log(Status.FAIL, MarkupHelper.createLabel(tName+"-Test Case Failed", ExtentColor.RED));
	  test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed", ExtentColor.RED));
	  String path=System.getProperty("user.dir")+"/Screenshots/"+repName1;
	  File fi=new File(path);
	  if(fi.exists())
	  {
		test.fail("Test case is fail:"+test.addScreenCaptureFromPath(path));
	  }
	   
  }
  public void onSkip(ITestResult result)
  {
	  tName=result.getName();
	  test=er.createTest(tName);
	  test.assignCategory(result.getMethod().getGroups());
	  test.createNode(result.getName());
	  test.log(Status.SKIP,MarkupHelper.createLabel(tName+"-Test case Failed",ExtentColor.ORANGE));
	  
  }
  public void onFinish(ITestContext testContext)
  {
	  er.flush();
	  
  }
}
