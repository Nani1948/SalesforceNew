package com.salesforce.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.test.SearchScriptTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.loginpages.ForgotYourPasswordPage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.utilty.CommonUtilis;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;
@Listeners(TestListerner.class)
public class LoginTest extends BaseTest{
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	  @Test
	  public void login_to_Salesforce_Application()  {
		
	     ExtentTest test=BaseTest.threadExtentTest.get();
	     WebDriver driver=LoginTest.getDriver();
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
			Assert.assertEquals( actualTitle,exceptedTitle);	
			CommonUtilis.getScreenshot(driver);
			test.log(Status.INFO, "Verify the title page of homepage is correct or not");
      }
	  
	  
	     @Test  
	     public void  Login_Error_Message() {
	    	 ExtentTest test=BaseTest.threadExtentTest.get();
	    	 WebDriver driver=LoginTest.getDriver();
	    	String username1=applicationPro.getProperty("valid_username");
	    	String password1=applicationPro.getProperty("valid_password");
	    	LoginPage loginPage=new LoginPage(driver);
			loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
			test.log(Status.INFO, "Url is a launched on browser");
			loginPage.enterUsername(username1);
			test.log(Status.INFO, "Enter username");
			loginPage.clearPassword(password1);
			test.log(Status.INFO, "Clear password");
			loginPage.clickOnLoginButton();	
			test.log(Status.INFO, "Click on Login");
			 String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_valid_username_and_No_Password");
	    	 String actualErrorMessage=loginPage.getErrorMessageOnLoginPage();
	    	 Assert.assertEquals(actualErrorMessage,exceptedErrorMessage);
	    	 CommonUtilis.getScreenshot(driver);
			test.log(Status.INFO, "Verify the error message");
		}	
	     @Test
	     public void Check_Remember_Me() {
	    	 ExtentTest test=BaseTest.threadExtentTest.get();
	    	 WebDriver driver=LoginTest.getDriver();
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
	    	 String exceptedUsernameText=applicationPro.getProperty("valid_username");
	    	 String actualUserNameText=loginPage.getTextOfUsername();
	    	 Assert.assertEquals(actualUserNameText,exceptedUsernameText);
	    	 CommonUtilis.getScreenshot(driver);
	    	 test.log(Status.INFO, "Verify if the username is same or not");
	     }
	       @Test
	     public void forgot_Password_4A() {
	    	   ExtentTest test=BaseTest.threadExtentTest.get();
	    	   WebDriver driver=LoginTest.getDriver();
			  String username1=applicationPro.getProperty("valid_username");
			  LoginPage loginPage=new LoginPage(driver);
				 loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
				 test.log(Status.INFO, "Url is a launched on browser");
			  loginPage.clickOnForgotPassword();
			  test.log(Status.INFO, "Click On ForgotPassword");
			  ForgotYourPasswordPage forgotYourPasswordPage=new ForgotYourPasswordPage(driver);
			 
			  String exceptedTitleofforgotPasswordPage=applicationPro.getProperty("title_of_ForgotPasswordPage");
			  String actualTitleofforgotPasswordPage=forgotYourPasswordPage.getTitleOfForgotPasswordPage1();
			  Assert.assertEquals(actualTitleofforgotPasswordPage,exceptedTitleofforgotPasswordPage);
			  test.log(Status.INFO, "Verify if the title of the page is same or not");
			  forgotYourPasswordPage.enterUsernameOnForgotPasswordLink(username1);
			  test.log(Status.INFO, "enter username");
			  forgotYourPasswordPage.clickOnContinueButton();
			  CommonUtilis.getScreenshot(driver);
		      test.log(Status.INFO, "Click On Continue Button");
		     
			  
	      }      

	       @Test
	     public void forgot_Password_4B() {
	    	 ExtentTest test=BaseTest.threadExtentTest.get();
	    	 WebDriver driver=LoginTest.getDriver();
	       	String username2=applicationPro.getProperty("invalid_username");
	       	String password2=applicationPro.getProperty("invalid_password");
	       	LoginPage loginPage=new LoginPage(driver);
			loginPage.loginToApp(applicationPro.getProperty("url4"), driver);
			test.log(Status.INFO, "Url is a launched on browser");
			 loginPage.enterUsername(username2);
			 test.log(Status.INFO, "Enter username");
	   		loginPage.enterPassword(password2);
	   	 test.log(Status.INFO, "Enter Password");
	   		loginPage.clickOnLoginButton();
	   	 test.log(Status.INFO, "Click on Login");
	   		String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_Invalid_Username_and_Invalid_Password");
	   		String actualErrorMessage=loginPage.getErrorMessageOnLoginPage();
	   	    Assert.assertEquals(actualErrorMessage,exceptedErrorMessage);
	   	 test.log(Status.INFO, "Verify if the errormessage is same or not");
	    	   
	     }
}