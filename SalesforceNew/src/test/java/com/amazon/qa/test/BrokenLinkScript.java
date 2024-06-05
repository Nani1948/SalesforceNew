package com.amazon.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.amazon.qa.pages.BrokenLinkInPage;
import com.aventstack.extentreports.ExtentTest;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.utilty.PropertiesUtliyClass;


public class BrokenLinkScript  extends BaseTest{
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
@Test 
public void  findBrokenLink() {
	ExtentTest test=BaseTest.threadExtentTest.get();
    WebDriver driver=SearchScriptTest.getDriver();
	BrokenLinkInPage brokenLink=new BrokenLinkInPage(driver);
	brokenLink.loginToBrowserStackApp(applicationPro.getProperty("url3"), driver);
	brokenLink.checkBrokenLinks();
	
}
}
