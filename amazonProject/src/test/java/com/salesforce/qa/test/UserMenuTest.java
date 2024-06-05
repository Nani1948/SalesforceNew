package com.salesforce.qa.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.test.SearchScriptTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.home.page.ConfigurationOfMyTabsPage;
import com.salesforce.qa.home.page.DeveloperConsolePage;
import com.salesforce.qa.home.page.EditPage;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.home.page.RemainderPage;
import com.salesforce.qa.home.page.UserProfilePage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.utilty.CommonUtilis;
import com.salesforce.qa.utilty.Constant4;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;
import com.salesforce.qa.home.page.EmailSetting;
@Listeners(TestListerner.class)
public class UserMenuTest extends BaseTest {
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	 @Test(priority = 1)
     public void UserMenuDropDisplay() {
		 ExtentTest test=BaseTest.threadExtentTest.get();
		 WebDriver driver=UserMenuTest.getDriver();
     	String username1=applicationPro.getProperty("valid_username");
     	String password1=applicationPro.getProperty("valid_password");
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

   	 homepage.clickOnUserProfileName();
   	 test.log(Status.INFO, "Click on UserProfile Name");
   	    homepage.getListofUserMenuDropdown(); 
   	 test.log(Status.INFO, "Get Text Of usermenu dropdown");
 	 CommonUtilis.getScreenshot(driver);
     }
     @Test(priority = 2)
     public void selectDeveloperConsole() {
    	ExtentTest test=BaseTest.threadExtentTest.get();
		WebDriver driver=UserMenuTest.getDriver();
     	String username1=applicationPro.getProperty("valid_username");
     	String password1=applicationPro.getProperty("valid_password");
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
 		homepage.clickOnUserProfileName();
 		test.log(Status.INFO, "Click on UserProfile Name");  
 		homepage.getListofUserMenuDropdown(); 
 		test.log(Status.INFO, "Get Text Of usermenu dropdown");
 		DeveloperConsolePage developerConsolePage=new DeveloperConsolePage(driver);
     	developerConsolePage.clickOnDeveloperConsole();
		test.log(Status.INFO, "Click on Developer console");      	
     	CommonUtilis.getScreenshot(driver);
     	developerConsolePage.closeBrowser();
     	test.log(Status.INFO, "Click on Close"); 
     	
     }
     @Test(priority = 3)
     public void   getAllOperationOFMySetting(){
    	 	ExtentTest test=BaseTest.threadExtentTest.get();
    		WebDriver driver=UserMenuTest.getDriver();
         	String username1=applicationPro.getProperty("valid_username");
         	String password1=applicationPro.getProperty("valid_password");
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
     		homepage.clickOnUserProfileName();
     		test.log(Status.INFO, "Click on UserProfile Name");  
     		homepage.getListofUserMenuDropdown(); 
     		test.log(Status.INFO, "Get Text Of usermenu dropdown");
      	 homepage.clickOnMySettings();
      	test.log(Status.INFO, "Click on MySetting");  
      	 homepage.clickOnPersonalInformation();
      	test.log(Status.INFO, "Click on Personal Setting");  
      	 homepage.clickOnLoginHistory();
      	test.log(Status.INFO, "Click on LoginHistory");  
      	 homepage.clickOnDownloadLoginHistory();     
     	test.log(Status.INFO, "Click on Download LoginHistory");  
     }
    
     @Test(priority = 4)
     public void configureOFMyTabs() {
    	 ExtentTest test=BaseTest.threadExtentTest.get();
 		 WebDriver driver=UserMenuTest.getDriver();
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
         String selectOptionsOfSalesforceChatter=applicationPro.getProperty("select_Salesforce_Chatter");
         String selectOptionsOfReports=applicationPro.getProperty("select_Reports");
         String ReportisDisplayed=applicationPro.getProperty("Report_tab");
         String selectOptionsOfSales=applicationPro.getProperty("Select_Sales");
         String selectOptionsOfMarketing=applicationPro.getProperty("Select_Marketing");
     	 String clickOnClose=applicationPro.getProperty("Click_On_Popup");
     	// String selectOptionsOfMarketing=applicationPro.getProperty(clickOnClose)
       //  String clickOnNoThanks=applicationPro.getProperty("Click_On_No_Thanks");
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
      	 homepage.clickOnUserProfileName();
  		test.log(Status.INFO, "Click on UserProfile Name");  
  		homepage.getListofUserMenuDropdown(); 
 		test.log(Status.INFO, "Get Text Of usermenu dropdown");
  	     homepage.clickOnMySettings();
  	     test.log(Status.INFO, "Click on MySetting");        	
      	 ConfigurationOfMyTabsPage   customizedTabs=new ConfigurationOfMyTabsPage(driver);         
         customizedTabs.clickOnDisplayAndLayOut();
         test.log(Status.INFO, "Click on DisplayAndLayOut");
         customizedTabs.clickOnCustomizeMyTabs();
         test.log(Status.INFO, "Click on CustomizeMyTabs");
         customizedTabs.clickOnDropdownListOfCustomApp();
         test.log(Status.INFO, "Click on DropdownListOfCustomApp");
         customizedTabs.getListofOfCustomApp();
         test.log(Status.INFO, "Get Text Of Custom App");
         customizedTabs.selectSalesforceChatter(selectOptionsOfSalesforceChatter);
         test.log(Status.INFO, "Select Salesforce Chatter optiosn rfrom dropdown");
         customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
         test.log(Status.INFO, "Select Reports from dropdown");
         customizedTabs.clickOnRemove();
         test.log(Status.INFO, "Click On Remove");
        // customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         customizedTabs.clickOnAdd();
         test.log(Status.INFO, "Click On Add");
         customizedTabs.clickOnSave();
         test.log(Status.INFO, "Click On Save");
       
         //Sales
        // customizedTabs.clickOnAdd();
        // test.log(Status.INFO, "Click on Add");
         customizedTabs.clickOnDisplayAndLayOut();
         test.log(Status.INFO, "Click on DisplayAndLayOut");
         customizedTabs.clickOnCustomizeMyTabs();
         test.log(Status.INFO, "Click on CustomizeMyTabs");
         customizedTabs.clickOnDropdownListOfCustomApp();
         test.log(Status.INFO, "Click on DropdownListOfCustomApp");
         customizedTabs.getListofOfCustomApp();
         test.log(Status.INFO, "Get Text Of Custom App");
         customizedTabs.selectSales(selectOptionsOfSales);
         test.log(Status.INFO, "Select Sales optiosn rfrom dropdown");
         customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
         test.log(Status.INFO, "Select Reports from dropdown");
         customizedTabs.clickOnRemove();
         test.log(Status.INFO, "Click On Remove");
        // customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         customizedTabs.clickOnAdd();
         test.log(Status.INFO, "Click On Add");
         customizedTabs.clickOnSave();
         test.log(Status.INFO, "Click On Save");
         
  
         //Marketing
        // customizedTabs.clickOnAdd();
        // test.log(Status.INFO, "Click On Add");
         customizedTabs.clickOnDisplayAndLayOut();
         test.log(Status.INFO, "Click on DisplayAndLayOut");
         customizedTabs.clickOnCustomizeMyTabs();
         test.log(Status.INFO, "Click on CustomizeMyTabs");
         customizedTabs.clickOnDropdownListOfCustomApp();
         test.log(Status.INFO, "Click on DropdownListOfCustomApp");
         customizedTabs.getListofOfCustomApp();
         test.log(Status.INFO, "Get Text Of Custom App");
         customizedTabs.selectMarketing(selectOptionsOfMarketing);
         test.log(Status.INFO, "Select Marketing options rfrom dropdown");
         customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
         test.log(Status.INFO, "Select Reports from dropdown");
         customizedTabs.clickOnRemove();
         test.log(Status.INFO, "Click On Remove");
        // customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         customizedTabs.clickOnAdd();
         test.log(Status.INFO, "Click On Add");
         customizedTabs.clickOnSave();
         test.log(Status.INFO, "Click On Save");
        // customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         
       
       //Assertion for Salesforce Chatter
         customizedTabs.clickOnPageMenuDropdown();
     	test.log(Status.INFO, "Click On Page menu dropdown");
         customizedTabs.clickOnSalesforceChatterFromPagesDropDown(selectOptionsOfSalesforceChatter);
         test.log(Status.INFO, "Click On SalesforceChatter");
         //customizedTabs.clickOnClose(clickOnClose);
         //test.log(Status.INFO, "Click On close");
         String ExpectedTabIsAvailable=applicationPro.getProperty(ReportisDisplayed);
         String actualTabIsAvialble=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
         
         Assert.assertEquals(ExpectedTabIsAvailable,actualTabIsAvialble);
         test.log(Status.INFO,"Veify if the report tab is displayed");
         //Assertion for Sales
         customizedTabs.clickOnPageMenuDropdown();
         customizedTabs.clickOnSalesFromPagesDropDown(selectOptionsOfSales);
         //customizedTabs.clickOnClose(clickOnClose);
         String ExpectedTabIsAvailable1=applicationPro.getProperty(ReportisDisplayed);
         String actualTabIsAvialble1=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
         
         Assert.assertEquals(ExpectedTabIsAvailable1,actualTabIsAvialble1);
         test.log(Status.INFO,"Veify if the report tab is displayed");
         
         //Assertion for Marketing
       
         customizedTabs.clickOnPageMenuDropdown();
         customizedTabs.clickOnMarketingFromPagesDropDown(selectOptionsOfMarketing);
       //  customizedTabs.clickOnClose(clickOnClose);
         String ExpectedTabIsAvailable2=applicationPro.getProperty(ReportisDisplayed);
         String actualTabIsAvialble2=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
         
         Assert.assertEquals(ExpectedTabIsAvailable2,actualTabIsAvialble2);
         test.log(Status.INFO,"Veify if the report tab is displayed");
     }
     @Test(priority = 5)
     public void EmailSetting() {
    	 ExtentTest test=BaseTest.threadExtentTest.get();
 		 WebDriver driver=UserMenuTest.getDriver();
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
         String ClickOnCalendarRemainder1=applicationPro.getProperty("ClickOnCalendar&RemainderLink");
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
           	 homepage.clickOnUserProfileName();
       		test.log(Status.INFO, "Click on UserProfile Name");  
       		homepage.getListofUserMenuDropdown(); 
      		test.log(Status.INFO, "Get Text Of usermenu dropdown");
       	     homepage.clickOnMySettings();
       	     test.log(Status.INFO, "Click on MySetting"); 
      	 
      	EmailSetting  emailPage=new EmailSetting(driver);
      	 emailPage.clickOnEmailLink(); 
      	test.log(Status.INFO, "Click on Email Link");
      	 emailPage.clickOnMyEmailSetting();
      	test.log(Status.INFO, "Click on My Email Settings");
      	 String nameOFSender=applicationPro.getProperty("Name");
      	 emailPage.enterSendName(nameOFSender);
      	test.log(Status.INFO, "Enter send name"); 
      	 String emailAddress=applicationPro.getProperty("Email_Address");
      	 emailPage.enterEmail(emailAddress);
      	test.log(Status.INFO, "Enter email"); 
      	 emailPage.isBCCChecked();
      	test.log(Status.INFO, "check BCC"); 
      	 emailPage.clickOnSaveOfEmailSettingPage();
      	test.log(Status.INFO, "Click On Save"); 
      	emailPage.clickOnCalendarRemainder(applicationPro.getProperty("pixelsdata"));
      	test.log(Status.INFO, "Click On Calendar &Remainder "); 
      	emailPage.clickOnActivityRemainder();
      	test.log(Status.INFO, "Click On Activity Remainder "); 
    	emailPage.clickOnOpenTestRemainder();
      	test.log(Status.INFO, "Click On OpenTestRemainder "); 
      	RemainderPage remainderPage=new RemainderPage(driver);
      	String exceptedTitle=applicationPro.getProperty("title_of_page15");
    	String actualTitle=remainderPage.getPageTitle();
    	Assert.assertEquals( actualTitle,exceptedTitle);
      	
     }
     @Test (priority=0)
     public void    selectMyProfileOption()  {
    	 ExtentTest test=BaseTest.threadExtentTest.get();
 		 WebDriver driver=UserMenuTest.getDriver();
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
         String selectOptionFromUserMenu=applicationPro.getProperty("SelectOptionfromUserMenu1");
         String clickOnButton=applicationPro.getProperty("click_On_Button");
         String textOfPostArea=applicationPro.getProperty("Post_Text1");         
         String userNewLastName=applicationPro.getProperty("user.newLastName");
         
        // String textOfFrame=applicationPro.getProperty("Frame1");
         LoginPage loginPage=new LoginPage(driver);
		 loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
		 test.log(Status.INFO, "Url is a launched on browser");
		 loginPage.enterUsername(username1);
		 test.log(Status.INFO, "Enter username");
		 loginPage.enterPassword(password1);
		 test.log(Status.INFO, "Enter Password");
		 loginPage.checkRememberMe();
		 test.log(Status.INFO, "Check Remember Me");
		 loginPage.clickOnLoginButton();	
		 test.log(Status.INFO, "Click on Login");
    		
    	 HomePage homepage=new HomePage(driver);
    	 
    	 homepage.clickOnUserProfileName();
    	 test.log(Status.INFO, "Click on UserProfile Name");
      	 homepage.getListofUserMenuDropdown();
     	test.log(Status.INFO, "Get Text Of usermenu dropdown");
    	 homepage.clickOnMyProfile(selectOptionFromUserMenu); 
    		test.log(Status.INFO, "Click on MY profile");
    		  
         UserProfilePage userProfilePage=new UserProfilePage(driver);
         Assert.assertTrue(userProfilePage.isMyProfilePageDisplayed(), "Failed to load my profile page");
    	 test.info("isMyProfilePageDisplayed successfull");
         //userProfilePage.clickOnEditButton(clickOnButton);
        //  test.log(Status.INFO, "Click on Edit Button");
            EditPage editPage=new EditPage(driver);
         
    		editPage.selectEditContact(driver);
    		Assert.assertTrue(editPage.verifyEditContactIframe(driver), "Failed to verify profile iframe");
    		test.log(Status.INFO, "SwitchToEditFrame");
    		Assert.assertTrue(editPage.verifyLastNameChangeInAboutTab(driver,userNewLastName));
    		test.log(Status.INFO, "Verify LastName is changed");
    		Assert.assertTrue(editPage.verifyCreatePost(driver,textOfPostArea));
    		
    		test.log(Status.INFO, "post is created successfully");
    		Assert.assertTrue(editPage.verifyFileUpload(driver, Constant4.TEST_FILE_PATH));
    		test.log(Status.INFO,"file is uploaded successfully");
    		Assert.assertTrue(editPage.addPhotoToProfile(Constant4.PHOTO_FILE_PATH,applicationPro.getProperty(clickOnButton)));
    		test.log(Status.INFO,"Photo is Upload successfully");
     }
	@Test
     public void LogoutOfTheProfile() {
		ExtentTest test=BaseTest.threadExtentTest.get();
		 WebDriver driver=UserMenuTest.getDriver();
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	 LoginPage loginPage=new LoginPage(driver);
		 loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
		 test.log(Status.INFO, "Url is a launched on browser");
		 loginPage.enterUsername(username1);
		 test.log(Status.INFO, "Enter username");
		 loginPage.enterPassword(password1);
		 test.log(Status.INFO, "Enter Password");
		 loginPage.checkRememberMe();
		 test.log(Status.INFO, "Check Remember Me");
		 loginPage.clickOnLoginButton();	
		 test.log(Status.INFO, "Click on Login");
    		
    	 HomePage homepage=new HomePage(driver);
    	 
    	 homepage.clickOnUserProfileName();
    	 test.log(Status.INFO, "Click on UserProfile Name");
    	 homepage.clickOnLogout();
    	 test.log(Status.INFO, "Click on Logout");
    	String exceptedTitle=applicationPro.getProperty("title_of_page");
    	String actualTitle=loginPage.getTitleOfThePage();
    	Assert.assertEquals( actualTitle,exceptedTitle);
    	test.log(Status.INFO,"verify if the Title of Page is same or not");
     }
	
	

}
