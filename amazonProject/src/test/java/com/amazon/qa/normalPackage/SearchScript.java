package com.amazon.qa.normalPackage;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.AmazonHome;
import com.amazon.qa.pages.SearchResultPage;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
public class SearchScript extends BaseTestAnohter {
	 private PropertiesUtliyClass propUtil = new PropertiesUtliyClass();
	    private Properties applicationPro = null;
	   

	    @Test
	    public void verifyTheItemIsPresentOrNot() {
	    	 
	    	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	    	//get entire properties applicationData.and load the file.
	    	Properties applicationPro=prop.loadFile("data.properties");  
		        
	    	AmazonHome homepage = new AmazonHome(driver);
	        homepage.sendTextToSearchBox(applicationPro.getProperty("Search"));
	        homepage.clickSearchButton(applicationPro.getProperty("clickOnIcon"));
	        SearchResultPage searchPage = new SearchResultPage(driver);
	       /* try {
	            int pixelsData = propUtil.getIntValue("data.properties", "pixelsdata");
	            searchPage.scrollDownToItem(pixelsData);
	        } catch (IOException e) {
	            System.err.println("Error: " + e.getMessage());
	        }*/
	        searchPage.robotClass();
	        searchPage.clickOnKindlePicutre(applicationPro.getProperty("clickOnAmazonChoicePicture"));
	        CartPage cart=new CartPage(driver);
	        //cart.clickOnAddCartButton();
	        cart.clickOnGoToCartButton(applicationPro.getProperty("ClickOnGotoCartButton"));
	        cart.verifyTheItemIsAvailableInCart(applicationPro.getProperty("Item"));
	        
	    }	    }