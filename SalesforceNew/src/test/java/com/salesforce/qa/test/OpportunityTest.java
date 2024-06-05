package com.salesforce.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saleforce.qa.opportunitiespage.OpportunitiesPage;
import com.saleforce.qa.opportunitiespage.OpportunityPipelinePage;
import com.saleforce.qa.opportunitiespage.OpportunityReportPage;
import com.saleforce.qa.opportunitiespage.StuckOpportunitiesReportPage;
import com.salesforce.qa.accountpages.AccountPage;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;

@Listeners(TestListerner.class)
public class OpportunityTest extends BaseTest{
	  PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	  Properties accounttestDataPro=prop.loadFile("accounttestdata.properties");
	  Properties opportunitiestestDataPro=prop.loadFile("opportunitiestestdata.properties");
	  
	  @Test
	  
	  public void opportunitiesDropdown() {
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
			test.info("Home page is displayed");
		    homepage.clickOnOpportunities();;
		    test.log(Status.INFO, "User click On Opportunities Tab");
		    
		    OpportunitiesPage  opportunitiesPage=new OpportunitiesPage (driver);
		    String actualTitleOFOpportunities=opportunitiesPage.getPageTitle();
			String exceptedTitleOfOpportunities=  opportunitiestestDataPro.getProperty("titleofopportunitiespage");		 				
			Assert.assertEquals(actualTitleOFOpportunities, exceptedTitleOfOpportunities);
			test.log(Status.INFO, "Opportunities Page is displayed");
			opportunitiesPage.clickOnDropdownListOfView(opportunitiestestDataPro.getProperty("viewdropdown"));
			test.log(Status.INFO, "User click On View Dropdown");
		    opportunitiesPage.getTextOfDropdownListOFView1();
		    test.log(Status.INFO, "List of Dropdown is displayed");
		    opportunitiesPage.testDropdownListOFView();
		    test.log(Status.INFO, "All options matched expected values.");
			
		   	 
	  }
	  @Test
	  
	  public void createANewOpportunity() {
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
			test.info("Home page is displayed");
		    homepage.clickOnOpportunities();;
		    test.log(Status.INFO, "User click On Opportunities Tab");
		    
		    OpportunitiesPage  opportunitiesPage=new OpportunitiesPage (driver);
		    String actualTitleOFOpportunities=opportunitiesPage.getPageTitle();
			String exceptedTitleOfOpportunities=  opportunitiestestDataPro.getProperty("titleofopportunitiespage");		 				
			Assert.assertEquals(actualTitleOFOpportunities, exceptedTitleOfOpportunities);
			test.log(Status.INFO, "Opportunities Page is displayed");
		    
			
			
			opportunitiesPage.clickOnNew(labelOfDropdownListOfView);
		    OpportunityEditNewOpportunityPage  oppEditNewPage=new OpportunityEditNewOpportunityPage (driver);
		    oppEditNewPage.setOpportunityName(textOfOpportunityNameData,labelOfOpportunityName);
		    oppEditNewPage.setAccountName(textOfAccountNameData,  labelOfAccountName);
		    oppEditNewPage.clickOnCloseDate(labelOfCloseDate);
		    oppEditNewPage.clickOnTodayLink( labelOfToday);
		    oppEditNewPage.selectOptionFromType( selectOptionFromType);
		    oppEditNewPage.selectOptionFromStage(selectOptionFromStage);
		    oppEditNewPage.selectOptionFromLeadSource(selectOptionFromLeadSource);
		    oppEditNewPage.setProbability(textOfProbabilityData, labelOfProbability);
		    oppEditNewPage.setPrimaryCampaignSource(textOfPrimaryCampaignSourceData,  labelOfPrimaryCampaignSource);	    
		    oppEditNewPage.clickOnSaveButton(clickOnButton4);
	  }
	  
	  @Test
	  public void  testOpportunityPipelineReport() {
	    	
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
			test.info("Home page is displayed");
		    homepage.clickOnOpportunities();;
		    test.log(Status.INFO, "User click On Opportunities Tab");
		    
		    OpportunitiesPage  opportunitiesPage=new OpportunitiesPage (driver);
		    String actualTitleOFOpportunities=opportunitiesPage.getPageTitle();
			String exceptedTitleOfOpportunities=  opportunitiestestDataPro.getProperty("titleofopportunitiespage");		 				
			Assert.assertEquals(actualTitleOFOpportunities, exceptedTitleOfOpportunities);
			test.log(Status.INFO, "Opportunities Page is displayed");
	       opportunitiesPage.clickOnOpportunityPipeline(opportunitiestestDataPro.getProperty("opportunitiespipelinelink"));		 				
	   	test.log(Status.INFO, "Opportunities Pipeline is displayed");
	       
	       String exceptedTitleOfPageOfOPPPipe=opportunitiestestDataPro.getProperty("titleOfpageopportunitypipeline");
	       OpportunityPipelinePage oppPipelinePage=new OpportunityPipelinePage(driver);
	       String actualTitleOfThePage=oppPipelinePage.getTitleOfTheOfOpportunityPipeline();
	       Assert.assertEquals(actualTitleOfThePage, exceptedTitleOfPageOfOPPPipe);
	       test.log(Status.INFO, "Opportunities pipeline is displayed");
	       
}
	    @Test
	public void  testStuckOpportunitiesReport() {
	    	
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
				test.info("Home page is displayed");
			    homepage.clickOnOpportunities();;
			    test.log(Status.INFO, "User click On Opportunities Tab");
			    
			    OpportunitiesPage  opportunitiesPage=new OpportunitiesPage (driver);
			    String actualTitleOFOpportunities=opportunitiesPage.getPageTitle();
				String exceptedTitleOfOpportunities=  opportunitiestestDataPro.getProperty("titleofopportunitiespage");		 				
				Assert.assertEquals(actualTitleOFOpportunities, exceptedTitleOfOpportunities);
				test.log(Status.INFO, "Opportunities Page is displayed");			
			
			   	opportunitiesPage.clickOnStuckOpportunities(opportunitiestestDataPro.getProperty("stuckopportunitieslink"));
			 	test.log(Status.INFO, "User click on Stuck Opportunities");
			     String exceptedTitleOfPageOfStuckOpp=opportunitiestestDataPro.getProperty("titleOfpagestuckopportunities");
			     StuckOpportunitiesReportPage stuckOppPage=new StuckOpportunitiesReportPage(driver);
			     String actuatTitleOfPageOfStuckOpp=stuckOppPage.getTitleOfTheOfStuckOpportunity();
			     Assert.assertEquals(actuatTitleOfPageOfStuckOpp, exceptedTitleOfPageOfStuckOpp);
			     test.log(Status.INFO, "Stuck Opportunities is displayed");
			       
				
	        
	   
	}
	 //5.Test Quarterly Summary Report
	    @Test
  public void  testQuartelySummaryReport() {
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
				test.info("Home page is displayed");
			    homepage.clickOnOpportunities();;
			    test.log(Status.INFO, "User click On Opportunities Tab");
			    
			    OpportunitiesPage  opportunitiesPage=new OpportunitiesPage (driver);
			    String actualTitleOFOpportunities=opportunitiesPage.getPageTitle();
				String exceptedTitleOfOpportunities=  opportunitiestestDataPro.getProperty("titleofopportunitiespage");		 				
				Assert.assertEquals(actualTitleOFOpportunities, exceptedTitleOfOpportunities);
				test.log(Status.INFO, "Opportunities Page is displayed");					
				
		    opportunitiesPage.selectOptionFromInterval(opportunitiestestDataPro.getProperty("selectOptionFromInterval"));
			test.log(Status.INFO, "User select options from Interval");	
		    opportunitiesPage.selectOptionFromInclude(opportunitiestestDataPro.getProperty("selectOptionFromInclude"));
		    test.log(Status.INFO, "User select options from Include");	
		    opportunitiesPage.clickOnRunReport(opportunitiestestDataPro.getProperty("runreportbutton"));
		    test.log(Status.INFO, "User click on Run Report button");	
		    OpportunityReportPage oppReportPage=new OpportunityReportPage(driver);
		    String exceptedTitleOfPageOfOPPReport=opportunitiestestDataPro.getProperty("titleofopportunityreport");
		    String actualTitleOFOppReport=oppReportPage.getTitleOfTheOpportunityReport();
		    Assert.assertEquals(actualTitleOFOppReport, exceptedTitleOfPageOfOPPReport);	
	  
		    test.log(Status.INFO, "Opportunities Report Page is displayed");
	
	
	}
	  
	  
}