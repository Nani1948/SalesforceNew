package com.amazon.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.DropDownPage;
import com.amazon.qa.pages.AmazonHome;
import com.amazon.qa.pages.SearchResultPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.utilty.CommonUtilis;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;

@Listeners(TestListerner.class)
public class SearchScriptTest extends BaseTest{
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	
	  
	  

	  
	  @Test
	  public void launchTheAmazonURL() {
		     ExtentTest test=BaseTest.threadExtentTest.get();
		     WebDriver driver=SearchScriptTest.getDriver();
		     AmazonHome homepage = new AmazonHome(driver);
		     homepage.loginToApp(applicationPro.getProperty("url"),driver);
		    test.log(Status.INFO, "URL Is Launched on the browser");
		
		    homepage.clickOnDifferntImageLink(applicationPro.getProperty("clickOnLink"));
		    test.log(Status.INFO, "Click on Try Different Image Link");
	
	        homepage.sendTextToSearchBox(applicationPro.getProperty("Search"));
	        test.log(Status.INFO, "Enter Kindle in the SearchBox");
	        homepage.clickSearchButton(applicationPro.getProperty("clickOnIcon"));
	        test.log(Status.INFO, "Click on Search Icon");
			 
	        SearchResultPage searchPage = new SearchResultPage(driver);
	       /* try {
	            int pixelsData = propUtil.getIntValue("data.properties", "pixelsdata");
	            searchPage.scrollDownToItem(pixelsData);
	        } catch (IOException e) {
	            System.err.println("Error: " + e.getMessage());
	        }*/
	        //searchPage.robotClass();
	        searchPage.clickOnKindlePicutre(applicationPro.getProperty("clickOnAmazonChoicePicture"));
	        test.log(Status.INFO, "Click on Kindle Picture");
		   
	        searchPage.robotClass();
	        test.log(Status.INFO, "Scroll Page Down");
	        searchPage.clickOnAddCartButton1(applicationPro.getProperty("ClickOnAddtoCartButton"));
	        test.log(Status.INFO, "Click on Add To Cart");
	       
	        CartPage cart=new CartPage(driver);
	        //cart.scrollDownToItemOnPage1();
	        //cart.clickOnAddCartButton();
	        cart.clickOnGoToCartButton(applicationPro.getProperty("ClickOnGotoCartButton"));
	        test.log(Status.INFO, "Click on GotoCart Button");
		     
	        cart.verifyTheItemIsAvailableInCart(applicationPro.getProperty("Item"));
	        test.log(Status.INFO, "Item is available in the cart");
	        CommonUtilis.getScreenshot(driver);
	        //test.log(Status.PASS, "Verify The Item is avaibale in the cart");
	        
	  }
	  
}



