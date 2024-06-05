package com.salesforce.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saleforce.qa.leadpage.CreateNewLeadPage;
import com.saleforce.qa.leadpage.LeadPage;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.utilty.Constant4;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;

@Listeners(TestListerner.class)
public class LeadTest extends BaseTest{
	 PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	  Properties accounttestDataPro=prop.loadFile("accounttestdata.properties");
	  Properties opportunitiestestDataPro=prop.loadFile("opportunitiestestdata.properties");
	  Properties leadTestDataPro=prop.loadFile("leadtestdata.properties");
	  //1.check leads tab link 
	  @Test
	  public void  testLeadTabLink(){
		   ExtentTest test=BaseTest.threadExtentTest.get();
	       WebDriver driver=AccountTest.getDriver();
	       String username1=applicationPro.getProperty("valid_username");
		   String password1=applicationPro.getProperty("valid_password");
			 
			//enter username and password then click on login button
			LoginPage loginPage=new LoginPage(driver);
			loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
			test.log(Status.INFO, "Url is a launched on browser");
			loginPage.enterUsername(username1);
			test.log(Status.INFO, "Enter username");
			loginPage.enterPassword(password1);
			test.log(Status.INFO, "Enter Password");
			loginPage.clickOnLoginButton();	
			test.log(Status.INFO, "Click on Login");
			
			HomePage homepage=new HomePage(driver);
		    String exceptedTitle=applicationPro.getProperty("title_of_Home_Page");			
			String actualTitle=homepage.getTitleOfHomePage();					
			Assert.assertEquals(exceptedTitle, actualTitle);
			test.log(Status.INFO, "Home Page is displayed");  		
			homepage.clickOnLead();
			test.log(Status.INFO, "User click on Lead Tab");  
			
			LeadPage leadPage=new LeadPage(driver);
			String exceptedTitleOFLeadPage=leadTestDataPro.getProperty("titleofleadpage");			
			String actualTitleOfLeadPage=leadPage.getTitleOfLeadPage();					
			Assert.assertEquals(actualTitleOfLeadPage,exceptedTitleOFLeadPage);
			test.log(Status.INFO, "Lead Page is displayed"); 
			
			
			
	  		
	  		
	  		
		} 
		//2.Validate 'View' drop down list contents
		@Test
		 public void leadsSelectView() {
			 ExtentTest test=BaseTest.threadExtentTest.get();
		       WebDriver driver=AccountTest.getDriver();
		       String username1=applicationPro.getProperty("valid_username");
			   String password1=applicationPro.getProperty("valid_password");
				 
				//enter username and password then click on login button
				LoginPage loginPage=new LoginPage(driver);
				loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
				test.log(Status.INFO, "Url is a launched on browser");
				loginPage.enterUsername(username1);
				test.log(Status.INFO, "Enter username");
				loginPage.enterPassword(password1);
				test.log(Status.INFO, "Enter Password");
				loginPage.clickOnLoginButton();	
				test.log(Status.INFO, "Click on Login");
				
				HomePage homepage=new HomePage(driver);
			    String exceptedTitle=applicationPro.getProperty("title_of_Home_Page");			
				String actualTitle=homepage.getTitleOfHomePage();					
				Assert.assertEquals(exceptedTitle, actualTitle);
				test.log(Status.INFO, "Home Page is displayed");  		
				homepage.clickOnLead();
				test.log(Status.INFO, "User click on Lead Tab");  
				
				LeadPage leadPage=new LeadPage(driver);
				String exceptedTitleOFLeadPage=leadTestDataPro.getProperty("titleofleadpage");			
				String actualTitleOfLeadPage=leadPage.getTitleOfLeadPage();					
				Assert.assertEquals(actualTitleOfLeadPage,exceptedTitleOFLeadPage);
				test.log(Status.INFO, "Lead Page is displayed"); 
	  		//2.Validate 'View' drop down list contents
	  		leadPage.getListOfAllDropdownOptions();	
	  		test.log(Status.INFO, "Dropdownn list is displayed"); 
		}
		//3.TC22-defaultView
		@Test
		 public void testGoButton() {
			ExtentTest test=BaseTest.threadExtentTest.get();
		       WebDriver driver=AccountTest.getDriver();
		       String username1=applicationPro.getProperty("valid_username");
			   String password1=applicationPro.getProperty("valid_password");
				 
				//enter username and password then click on login button
				LoginPage loginPage=new LoginPage(driver);
				loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
				test.log(Status.INFO, "Url is a launched on browser");
				loginPage.enterUsername(username1);
				test.log(Status.INFO, "Enter username");
				loginPage.enterPassword(password1);
				test.log(Status.INFO, "Enter Password");
				loginPage.clickOnLoginButton();	
				test.log(Status.INFO, "Click on Login");
				
				HomePage homepage=new HomePage(driver);
			    String exceptedTitle=applicationPro.getProperty("title_of_Home_Page");			
				String actualTitle=homepage.getTitleOfHomePage();					
				Assert.assertEquals(exceptedTitle, actualTitle);
				test.log(Status.INFO, "Home Page is displayed");  		
				homepage.clickOnLead();
				test.log(Status.INFO, "User click on Lead Tab");  
				
				LeadPage leadPage=new LeadPage(driver);
				String exceptedTitleOFLeadPage=leadTestDataPro.getProperty("titleofleadpage");			
				String actualTitleOfLeadPage=leadPage.getTitleOfLeadPage();					
				Assert.assertEquals(actualTitleOfLeadPage,exceptedTitleOFLeadPage);
				test.log(Status.INFO, "Lead Page is displayed"); 
		  	  //leadPage.clickOnClose(clickOnButton3);
				String exceptedTextOfView=leadPage.getStoredDefaultView();
		  		leadPage.clickOnGo(leadTestDataPro.getProperty("gobutton"));
		  		test.log(Status.INFO, "User click on Go Button"); 
		  		String actualTextOfView=leadPage.getStoredDefaultViewOFGo();
		  		
		  		Assert.assertEquals(actualTextOfView,exceptedTextOfView);
		  		test.log(Status.INFO, "Text is matching with excepted value"); 
		  		

		}
	  	//	4.List item "Todays Leads" work
		@Test
		public void listItemOfTodayLeads() {
			ExtentTest test=BaseTest.threadExtentTest.get();
		       WebDriver driver=AccountTest.getDriver();
		       String username1=applicationPro.getProperty("valid_username");
			   String password1=applicationPro.getProperty("valid_password");
				 
				//enter username and password then click on login button
				LoginPage loginPage=new LoginPage(driver);
				loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
				test.log(Status.INFO, "Url is a launched on browser");
				loginPage.enterUsername(username1);
				test.log(Status.INFO, "Enter username");
				loginPage.enterPassword(password1);
				test.log(Status.INFO, "Enter Password");
				loginPage.clickOnLoginButton();	
				test.log(Status.INFO, "Click on Login");
				
				HomePage homepage=new HomePage(driver);
			    String exceptedTitle=applicationPro.getProperty("title_of_Home_Page");			
				String actualTitle=homepage.getTitleOfHomePage();					
				Assert.assertEquals(exceptedTitle, actualTitle);
				test.log(Status.INFO, "Home Page is displayed");  		
				homepage.clickOnLead();
				test.log(Status.INFO, "User click on Lead Tab");  
				
				LeadPage leadPage=new LeadPage(driver);
				String exceptedTitleOFLeadPage=leadTestDataPro.getProperty("titleofleadpage");			
				String actualTitleOfLeadPage=leadPage.getTitleOfLeadPage();					
				Assert.assertEquals(actualTitleOfLeadPage,exceptedTitleOFLeadPage);
				test.log(Status.INFO, "Lead Page is displayed"); 
	  		leadPage.getListOfAllDropdownOptions();
	  		leadPage.selectTodayLeads(leadTestDataPro.getProperty("selectOptionsFromDropdown"));
	  		test.log(Status.INFO, "Select options from View Dropdown"); 
		}
	  		//5.Check "New" button on Leads Home
	  		@Test
	  	public void  checkNewButtononLeadHome() {
	  			
	  			
	  			ExtentTest test=BaseTest.threadExtentTest.get();
			       WebDriver driver=AccountTest.getDriver();
			       String username1=applicationPro.getProperty("valid_username");
				   String password1=applicationPro.getProperty("valid_password");
					 
					//enter username and password then click on login button
					LoginPage loginPage=new LoginPage(driver);
					loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
					test.log(Status.INFO, "Url is a launched on browser");
					loginPage.enterUsername(username1);
					test.log(Status.INFO, "Enter username");
					loginPage.enterPassword(password1);
					test.log(Status.INFO, "Enter Password");
					loginPage.clickOnLoginButton();	
					test.log(Status.INFO, "Click on Login");
					
					HomePage homepage=new HomePage(driver);
				    String exceptedTitle=applicationPro.getProperty("title_of_Home_Page");			
					String actualTitle=homepage.getTitleOfHomePage();					
					Assert.assertEquals(exceptedTitle, actualTitle);
					test.log(Status.INFO, "Home Page is displayed");  		
					homepage.clickOnLead();
					test.log(Status.INFO, "User click on Lead Tab");  
					
					LeadPage leadPage=new LeadPage(driver);
					String exceptedTitleOFLeadPage=leadTestDataPro.getProperty("titleofleadpage");			
					String actualTitleOfLeadPage=leadPage.getTitleOfLeadPage();					
					Assert.assertEquals(actualTitleOfLeadPage,exceptedTitleOFLeadPage);
					test.log(Status.INFO, "Lead Page is displayed"); 
	  	  		    leadPage.clickOnNew(leadTestDataPro.getProperty("newbutton"));
	  	  		    test.log(Status.INFO, "User click on new button"); 
	  	  		    
	  	  		    CreateNewLeadPage newLeadPage=new CreateNewLeadPage(driver);
	  	  		    newLeadPage.setLastName(leadTestDataPro.getProperty("textOfname"), leadTestDataPro.getProperty("labeloflastname"));
	  	  		   test.log(Status.INFO, "User enter lastname in lastname field"); 
	  	  		   newLeadPage.setCompanyName(leadTestDataPro.getProperty("textOfcompanyname"), leadTestDataPro.getProperty("labelofcompanyname"));
	  	  		   test.log(Status.INFO, "User enter company name  in company name field"); 
	  	  		   newLeadPage.clickOnSave(leadTestDataPro.getProperty("savebutton"));
	  	  		   test.log(Status.INFO, "User click on save button"); 
		}
}
