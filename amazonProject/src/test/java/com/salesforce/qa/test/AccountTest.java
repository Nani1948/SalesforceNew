package com.salesforce.qa.test;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.salesforce.qa.accountpages.AccountPage;
import com.salesforce.qa.accountpages.accountreportpage.AccountReport;
import com.salesforce.qa.accountpages.mergereportpage.MergeAccount;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.home.page.UserProfilePage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.utilty.CommonUtilis;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;
import com.salesforce.qa.utilty.WaitConstant;

@Listeners(TestListerner.class)
public class AccountTest extends BaseTest{
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	  Properties accounttestDataPro=prop.loadFile("accounttestdata.properties");
	  
	  @Test
	  public void createAccount() {
		  try {
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
			    homepage.clickOnAccount();
			    test.log(Status.INFO, "User click On Account Tab");
			    
			    AccountPage accountPage=new AccountPage(driver);
			
			  // accountPage.getPageLoad();
			   // accountPage.clickOnClose(accounttestDataPro.getProperty("closebutton"));
			   
			   String actualTitleOFAccount=accountPage.getTitleOfAccountPage();
			   String exceptedTitleOfAccount= accounttestDataPro.getProperty("titleofaccountpage");
			   //System.out.println("Excepted Title:"+exceptedTitleOfAccount);
			   /*WebDriverWait  wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT);
			   wait.until(ExpectedConditions.titleIs(exceptedTitleOfAccount));*/
			    	
				//Assert.assertTrue(accountPage.getTitleOfHomePage(),exceptedTitleOfAccount);		
				
			   Assert.assertEquals(actualTitleOFAccount, exceptedTitleOfAccount);

				test.log(Status.INFO, "Account Page is displayed");			    			    
			    accountPage.clickOnNewButton();
			    test.log(Status.INFO, "User click On New Button");
			    
			    String actualTitleOfNewAccountPage=accountPage.getPageTitle();
			    String exceptedTitleOfNewAccountPage=accounttestDataPro.getProperty("titleofnewaccountpage");			    
			    Assert.assertEquals(actualTitleOfNewAccountPage,exceptedTitleOfNewAccountPage);
			    test.log(Status.INFO, " New account edit Page is displayed ");
			    
			    
			    accountPage.setTextIntoAccountName(accounttestDataPro.getProperty("enteraccountname"), accounttestDataPro.getProperty("accountname"));
			    test.log(Status.INFO, "User enter account name");
			    accountPage.selectOptionsFromType(accounttestDataPro.getProperty("typeoption"));
			    test.log(Status.INFO, "User select option from Type");
			    accountPage.selectOptionsFromCustomerPriority(accounttestDataPro.getProperty("customerpriorityoption"));
			    test.log(Status.INFO, "User select option from customer priority");
			    accountPage.clickOnSave(accounttestDataPro.getProperty("savebutton"));
			    test.log(Status.INFO, "User click On Save Button");
			 
			    // Retrieve the account name from the page
		      //  String accountName = accountPage.getAccountNameText();
		     //   System.out.println("Account Name: " + accountName);
		     
		       

		        // Retrieve the actual page title
		        String actualTitleOFAccountNamePage = accountPage.getTitleOfNewAccountPage();
		        System.out.println("Actual Page Title: " + actualTitleOFAccountNamePage);
		        
		        String exceptedTitleOfAccountPage=accounttestDataPro.getProperty("titleofnewaccountpageprefix")+" "+accounttestDataPro.getProperty("enteraccountname")+" "+accounttestDataPro.getProperty("titleofnewaccountpagesufix");
		    //    String  indexOfAccountName=accounttestDataPro.getProperty("accountnameindex");
		      //  int  indexValue=Integer.parseInt(indexOfAccountName);
             
		        // Verify that the page title contains the account name
		        Assert.assertEquals(actualTitleOFAccountNamePage,(exceptedTitleOfAccountPage));
		        test.log(Status.INFO, "Account name is displayed in the title page");
		        //Verify the account name is displayed on the account page
		        String accountName = accountPage.getAccountNameText();
			    System.out.println("Account Name: " + accountName);
		        Assert.assertTrue(accounttestDataPro.getProperty("enteraccountname").contains(accountName),"Account Name doesnt match on the page");
		        test.log(Status.INFO, "Account Name is displayed on the page");
		        
		        //Verify the type option is displayed on the account page 
		        String actualTypeOption = accountPage.getTypeOptionText() ;
		        Assert.assertEquals(accounttestDataPro.getProperty("typeoption"),actualTypeOption );
		        test.log(Status.INFO, "Type option is displayed on the page");
		        //Verify the Customer priority option is displayed on the account page 
		        
		        String actualCustomerPriorityOption = accountPage.getCustomerPriorityOptionText();
		        Assert.assertEquals(accounttestDataPro.getProperty("customerpriorityoption"),  actualCustomerPriorityOption);
		        test.log(Status.INFO, "Customer priority option is displayed on the page");
		        
		        
			    
		  }
			    catch (Exception e) {
		            // Log the error
		            logger.error("An error occurred during test execution: " + e.getMessage());

		            // Take a screenshot for debugging
		            CommonUtilis.getScreenshot(getDriver());

		            // Fail the test
		            Assert.fail("Test execution failed: " + e.getMessage());
		        }
				
	  }
	  
	  @Test
	  public void  createNewView() {
		  try {
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
			    homepage.clickOnAccount();
			    test.log(Status.INFO, "User click On Account Tab");
			    
			    AccountPage accountPage=new AccountPage(driver);
			
			  // accountPage.getPageLoad();
			   // accountPage.clickOnClose(accounttestDataPro.getProperty("closebutton"));
			   
			   String actualTitleOFAccount=accountPage.getTitleOfAccountPage();
			   String exceptedTitleOfAccount= accounttestDataPro.getProperty("titleofaccountpage");
			 	
				
			   Assert.assertEquals(actualTitleOFAccount, exceptedTitleOfAccount);

				test.log(Status.INFO, "Account Page is displayed");		
				
				 accountPage.clickOnCreateNewView( accounttestDataPro.getProperty("createnewviewlink"));
				 test.log(Status.INFO, "User click on createnewview hyperlink");	
				  String actualTitleOFCreateNewViewPage=accountPage.getTitleOfAccountPage();
				  String exceptedTitleOfCreateNewViewPage= accounttestDataPro.getProperty("titleofcreatenewviewpage");
				  Assert.assertEquals(actualTitleOFCreateNewViewPage, exceptedTitleOfCreateNewViewPage);
				  test.log(Status.INFO, "CreateNewView is displayed");	
				  accountPage.setViewName(accounttestDataPro.getProperty("accountviewname"),accounttestDataPro.getProperty("viewname"));
				  test.log(Status.INFO, "User enter viewname");	
				  accountPage.clickUniqueName();
				  test.log(Status.INFO, "User click on unique name");	
				
				  accountPage.clickOnSaveButtonOnCreateNewView(accounttestDataPro.getProperty("savebutton"));

				  test.log(Status.INFO, "User click on save button");
				String  expectedOptionsFromDropdownOfCreateNewView=accounttestDataPro.getProperty("accountviewname");
				List< String> actualOptionsFromDropdownOfCreateNewView=accountPage.getTextOfDropdownOFCreateNewView(expectedOptionsFromDropdownOfCreateNewView);
				//  accountPage.SelectTextOptionOFDropdownCreateNewView(accounttestDataPro.getProperty("accountviewname"));
				 Assert.assertTrue(actualOptionsFromDropdownOfCreateNewView.contains(actualOptionsFromDropdownOfCreateNewView),"Options doesn't match with accountviewname");
				 
				  test.log(Status.INFO, "Newely added View should be displayed in the account view list");
		  }
		  catch (Exception e) {
	            // Log the error
	            logger.error("An error occurred during test execution: " + e.getMessage());

	            // Take a screenshot for debugging
	            CommonUtilis.getScreenshot(getDriver());

	            // Fail the test
	            Assert.fail("Test execution failed: " + e.getMessage());
	        }
	  }
	  
	  
	  @Test
	  public void editView() {
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
		    homepage.clickOnAccount();
		    test.log(Status.INFO, "User click On Account Tab");
		    
		    AccountPage accountPage=new AccountPage(driver);
		   
		   String actualTitleOFAccount=accountPage.getTitleOfAccountPage();
		   String exceptedTitleOfAccount= accounttestDataPro.getProperty("titleofaccountpage");		 			
		   Assert.assertEquals(actualTitleOFAccount, exceptedTitleOfAccount);
		   test.log(Status.INFO, "Account Page is displayed");
		  
		   accountPage.selectDropdownOptionsFromViewList(accounttestDataPro.getProperty("listofViewName"));
		   test.log(Status.INFO, "View Name is selected from dropdown");
		   accountPage.clickOnEdit(accounttestDataPro.getProperty("editbutton"));
		   test.log(Status.INFO, "User click on edit button");
		   accountPage.updateViewName(accounttestDataPro.getProperty("changeviewname"),accounttestDataPro.getProperty("viewname"));
		   test.log(Status.INFO, "User update view name on the view name field");
		   accountPage.UpdateUniqueName();
		   test.log(Status.INFO, "User update  uniquename on the view name field");
		   accountPage.selectAccountNameFromField(accounttestDataPro.getProperty("accountname"));
		   test.log(Status.INFO, "User select account name options from  field dropfdown");
		   accountPage.selectEqualFromOperator(accounttestDataPro.getProperty("operator"));
		   test.log(Status.INFO, "User select contains options from  operator dropfdown");
		   accountPage.setValue(accounttestDataPro.getProperty("value"),accounttestDataPro.getProperty("valuetext"));
		   test.log(Status.INFO, "User enter text in value field");
		   //pixelsavailableField
		   accountPage.selectOptionsfromAvailableField(accounttestDataPro.getProperty("pixel"),accounttestDataPro.getProperty("availablefield") );
		   test.log(Status.INFO, "User select LastActivity Options from Available fields");
		   accountPage.clickOnAdd();
		   test.log(Status.INFO, "User click on Add button");
		   		
	  
	  }
	  @Test
	  public void mergeAccount() {
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
		    homepage.clickOnAccount();
		    test.log(Status.INFO, "User click On Account Tab");
		    
		    AccountPage accountPage=new AccountPage(driver);
		   
		   String actualTitleOFAccount=accountPage.getTitleOfAccountPage();
		   String exceptedTitleOfAccount= accounttestDataPro.getProperty("titleofaccountpage");		 			
		   Assert.assertEquals(actualTitleOFAccount, exceptedTitleOfAccount);
		   test.log(Status.INFO, "Account Page is displayed");
		   
		   
		   
		   
		   
		   
		   
		   accountPage.clickOnMergeAccount(accounttestDataPro.getProperty("mergeaccount"));
		   test.log(Status.INFO, "User click on Merge Accounts link");
		   MergeAccount mergeAccountPage=new MergeAccount(driver);
		   mergeAccountPage.setAccountNameInSearchBox(accounttestDataPro.getProperty("searchbox"),accounttestDataPro.getProperty("searchboxlabel"));
		   test.log(Status.INFO, "User enter the data in searchbox");
		   mergeAccountPage.clickOnFindAccount(accounttestDataPro.getProperty("findaccountsButton"));
		   test.log(Status.INFO, "User click on find accounts button");
		   mergeAccountPage.clickOnFirstCheckBox();
		   test.log(Status.INFO, "User click on first checkbox");
		   mergeAccountPage.clickOnSecondCheckBox();
		   test.log(Status.INFO, "User click on secondcheckbox");
		   mergeAccountPage.clickOnNext(accounttestDataPro.getProperty("nextbutton"));
		   test.log(Status.INFO, "User click on next button");
		   mergeAccountPage.clickOnMerge(accounttestDataPro.getProperty("mergebutton"));
		   test.log(Status.INFO, "User click on merge button");
		   test.log(Status.INFO, "Popup window is dispalyed");
		   
		   mergeAccountPage.clickOnPopup(accounttestDataPro.getProperty("recentlyviewed"));
		   test.log(Status.INFO, "User click on ok button");
		   test.log(Status.INFO, "Select Recently View Option from dropdown");
		   
		  String textOfAccountName= mergeAccountPage.getDataFirstRowInTable();
		   logger.info(textOfAccountName);
		   
	  }
	  @Test
	  public void createAccountReport() {
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
		    homepage.clickOnAccount();
		    test.log(Status.INFO, "User click On Account Tab");
		    
		    AccountPage accountPage=new AccountPage(driver);
		   
		   String actualTitleOFAccount=accountPage.getTitleOfAccountPage();
		   String exceptedTitleOfAccount= accounttestDataPro.getProperty("titleofaccountpage");		 			
		   Assert.assertEquals(actualTitleOFAccount, exceptedTitleOfAccount);
		   test.log(Status.INFO, "Account Page is displayed");
		   
		   accountPage.clickOnAccountsIsGreaterThan30Days(accounttestDataPro.getProperty("lastactivity>30dayslink"),accounttestDataPro.getProperty("pixel"));
		   test.log(Status.INFO, "User click on accounts with last activity > 30 days");
		   
		   String actualTitleOfUnsavedAccountReport=accountPage.getTitleOfAccountPage();
		   String exceptedTitleOfUnsavedAccountReport= accounttestDataPro.getProperty("titleofunsavedreport");		 			
		   Assert.assertEquals(actualTitleOfUnsavedAccountReport, exceptedTitleOfUnsavedAccountReport);
		   test.log(Status.INFO, "UnSaved Report Page is displayed");
		   
		  // selectoptionsfromdate
		   
		   AccountReport accountReportPage=new AccountReport(driver);
		   accountReportPage.clickOnDropdownDate(accounttestDataPro.getProperty("clickondate"));
		   test.log(Status.INFO, "User click on date field");
		   accountReportPage.clickOnCreateDate(accounttestDataPro.getProperty("selectoptionsfromdate"));
		   test.log(Status.INFO, "User click on Create Date");
		   accountReportPage.clickOnDropdownRange();
		   test.log(Status.INFO, "User click on range dropdown");
		   accountReportPage.clickOnDropdownRangeOption();
		   test.log(Status.INFO, "User click on All Time");
		   
		   accountReportPage.clickOnFromCalendarIcon(accounttestDataPro.getProperty("calendaricon"));
		   test.log(Status.INFO, "User click on From Calendar Icon");
		   accountReportPage.clickOnTodayDate(accounttestDataPro.getProperty("todayButton"));
		   test.log(Status.INFO, "User click on today button");
		   
		   accountReportPage.verifyListOfAccountDisplayed();
		   test.log(Status.INFO, "List of account is displayed");
		   accountReportPage.clickOnSaveButton(accounttestDataPro.getProperty("savebutton"));
		   test.log(Status.INFO, "User click on save button");
	
		   accountReportPage.saveReportPopupWindow();
		   test.log(Status.INFO, "Popup window is displayed");

		   
		   accountReportPage.setReportName(accounttestDataPro.getProperty("reportname"),accounttestDataPro.getProperty("labelreportname"));
		   test.log(Status.INFO, "User enter report name");
		   accountReportPage.setReportUniqueName();
		   test.log(Status.INFO, "User click on unique report name");
		   
		   accountReportPage.clickOnSaveAndRunReport(accounttestDataPro.getProperty("saveandrunreportButton"));  
		   test.log(Status.INFO, "User click on save and run report button");
		   
		   String exceptedTitleOfSavedReport=accounttestDataPro.getProperty("reportname")+" "+accounttestDataPro.getProperty("reportnameprefix");
		   String actualTitleofSaveReport= accountReportPage.waitForTitle(exceptedTitleOfSavedReport);;
		   Assert.assertEquals(actualTitleofSaveReport,exceptedTitleOfSavedReport);
		   test.log(Status.INFO, "Report page with details and <report name>is displayed.");
		   
		  
		  
	  }
}
