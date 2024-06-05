package com.amazon.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.pages.DropDownPage;
import com.amazon.qa.pages.AmazonHome;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.utilty.CommonUtilis;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;

@Listeners(TestListerner.class)
public class ConvertUSInToDriverTest extends BaseTest {
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	@Test
	  public void convertUSIntoINR() {
		
	     ExtentTest test=BaseTest.threadExtentTest.get();
	     WebDriver driver=SearchScriptTest.getDriver();
	   
	     DropDownPage dropdownPage=new  DropDownPage(driver);
		 dropdownPage.loginToXeApp(applicationPro.getProperty("ur11"),driver);
		 test.log(Status.INFO, "URL Is Launched on the browser");
	     dropdownPage.selectUSFromDropDown();   
	     test.log(Status.INFO, "Select  US-Dollar from Dropdown");
		 	//dropdownPage.selectINRFromDropDown(selectOnINRFromToDropdown);
	     dropdownPage.selectINRFromDropDown();  
		 test.log(Status.INFO, "Select INR from Dropdown");
		 dropdownPage.clickOnConvert();
		 test.log(Status.INFO, "Click On Convert Button");
		 CommonUtilis.getScreenshot(driver);
	}

}
