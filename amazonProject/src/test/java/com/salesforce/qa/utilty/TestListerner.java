package com.salesforce.qa.utilty;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import com.automation.utility.ExtentReportUtility2;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.salesforce.qa.basetest.BaseTest;

public class TestListerner implements ITestListener {

	@Override
	public void onTestStart(ITestResult name) {
		  BaseTest.test=BaseTest.extent.createTest(name.getName());
	        BaseTest.threadExtentTest.set(BaseTest.test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		BaseTest.threadExtentTest.get().pass(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtilis.getScreenshot(BaseTest.getDriver()));
		BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED "+result.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
		
	}



	

 

  
  
}