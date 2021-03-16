package com.htc.newMadinson.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.htc.newMadinson.base.BaseTest;
import com.htc.newMadinson.base.GlobalVars;



public class CustomListener implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

		public void onTestSuccess(ITestResult result) {
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest)testClass).getDriver();
		System.out.println(("*** Test execution " + result.getMethod().getMethodName() + " passed..."));
		Util.ScreenShot(driver, result.getMethod().getMethodName(), GlobalVars.passFilePath);
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");	
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest)testClass).getDriver();
		Util.ScreenShot(driver, result.getName(), GlobalVars.failFilePath );
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		System.out.println(result.getThrowable().getStackTrace());
		
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		
	}
	
}	
