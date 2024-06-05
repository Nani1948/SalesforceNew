package com.salesforce.qa.test;

import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saleforce.qa.contactpage.ContactCreateNewViewpage;
import com.saleforce.qa.contactpage.ContactEditNewContactPage;
import com.saleforce.qa.contactpage.ContactPage;
import com.salesforce.qa.basetest.BaseTest;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.TestListerner;

@Listeners(TestListerner.class)
public class ContactTest extends BaseTest{
	  PropertiesUtliyClass prop=new PropertiesUtliyClass();
	  Properties applicationPro=prop.loadFile("data.properties");
	  Properties leadTestDataPro=prop.loadFile("leadtestdata.properties");
	  Properties contactTestDataPro=prop.loadFile("contacttestdata.properties");
	//contact
	    //1.Create new contact
		@Test
		public void createNewContact() {
			
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		//1.Create new contact
		      	contactPage.clickOnNewButton(contactTestDataPro.getProperty("newbutton"));
		      	test.log(Status.INFO, "User click on new button"); 
		      	String actualTitleOFConEditNewPage=contactPage.getTitleOfTheContactEditNewContact(); 
		      	String exceptedTitleOFConEditNewPage= contactTestDataPro.getProperty("titleofpagecontacteditnewcontact");
		      	Assert.assertEquals(actualTitleOFConEditNewPage, exceptedTitleOFConEditNewPage);
		    	test.log(Status.INFO, "Contact edit page is displayed"); 
		    	
		    	contactPage.setLastName(contactTestDataPro.getProperty("textoflastname"),contactTestDataPro.getProperty("labeloflastname"));
		    	test.log(Status.INFO, "User enter lastname"); 
		    	contactPage.setAccountName(contactTestDataPro.getProperty("textofaccountname"),contactTestDataPro.getProperty("labelofaccountname"));
		    	test.log(Status.INFO, "User enter account name");
		    	contactPage.clickOnSave();
		      	test.log(Status.INFO, "User click on save button");
	      	    
		      	String exceptedTitleOFContactNamePage=contactTestDataPro.getProperty("titleofnewaccountpageprefix")+" "+contactTestDataPro.getProperty("textoflastname")+" "+contactTestDataPro.getProperty("titleofnewaccountpagesufix");
		      	String actualTitleOFContactNamePage=contactPage.getTitleOfTheContactName();
			    Assert.assertEquals(actualTitleOFContactNamePage, exceptedTitleOFContactNamePage);	 
			    test.log(Status.INFO, "New Contact Page is displayed");
		    
		}
		//2.Create new view in the Contact Page
		@Test
		public void   CreateNewviewInTheContact() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		contactPage.clickOnCreateNewView(contactTestDataPro.getProperty("createnewviewlink"));
		 		test.log(Status.INFO, "Create new view  is displayed"); 
		 		ContactCreateNewViewpage  createNewViewPage=new ContactCreateNewViewpage(driver);
		 		createNewViewPage.setViewName(contactTestDataPro.getProperty("textofviewname"), contactTestDataPro.getProperty("labelofviewname"));
		 		test.log(Status.INFO, "User enter  view name"); 
		 		createNewViewPage.setViewUniqueName();
		 		test.log(Status.INFO, "User click on view unique name"); 
		      	createNewViewPage.clickOnSaveButton(contactTestDataPro.getProperty("savebutton"));
		    	test.log(Status.INFO, "User click on  save button"); 
	      	
	      	
	      	
		}
	    //3.Check recently created contact in the Contact Page
		@Test
	    public void  displayListOfRecentlyCreated() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
	      	    
		 		String textOfDropdown=contactTestDataPro.getProperty("textofdropdown");
	      	    contactPage.selectOptionRecentlyCreated(textOfDropdown);
	      	    test.log(Status.INFO, "Select Option from Recently Contacts");
	      	    
	      	   
	      	 
	      	    String expectedTextOFDropdown=contactTestDataPro.getProperty("textofdropdown");
	      	    String actualTextOfDropdown=  contactPage.getTextOFDropdown();
	      	    Assert.assertEquals(actualTextOfDropdown,expectedTextOFDropdown);	 
			    test.log(Status.INFO, "Dropdown Text is matched");
	      	   
	      	    	
	    }
		//4.Check 'My contacts' view in the Contact Page
	    @Test
	    public void displayListOfMyContact() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		
		      	
	      	    //contactPage.selectOptionFromDropdown(expectedTextOFDropdown);
		      	//contactPage.getListOfAllDropdownOptions();
		      	test.log(Status.INFO, "List of Options must be displayed"); 
		      	String expectedTextOFDropdown=contactTestDataPro.getProperty("viewdropdownoption");
	      		contactPage.selectOptionMyContacts(expectedTextOFDropdown);
	      		
	      	    //String actualTextOfDropdown=  contactPage.selectOptionFromViewDropdown1();
	      	  test.log(Status.INFO, "Select option from view dropdown "); 
	      	  
	      	String actualTextOfDropdown=contactPage.getStoredDefaultViewOfDropdown();
	      	    Assert.assertEquals(actualTextOfDropdown,expectedTextOFDropdown);	 
			    test.log(Status.INFO, "Dropdown Text is matched");
	    
	    }
	    
	    //5.View a contact in the contact Page
	    @Test
	    public void  viewAContactInContactPage() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		contactPage.getTextContactName();
		 		String nameofContact=contactPage.getTextContactName();
		 		
		 		test.log(Status.INFO, "User get text of contact name"); 
	    	    contactPage.clickOnContactName();
	    	    test.log(Status.INFO, "User click on contact name link under name field");
	    	    String expectedTitleOfContactNamePage=contactTestDataPro.getProperty("titleofnewaccountpageprefix")+" "+nameofContact +" "+contactTestDataPro.getProperty("titleofnewaccountpagesufix");
	    	    String actualTitleOfContactNamePage=contactPage.getPageTitle();
	    	    Assert.assertEquals(actualTitleOfContactNamePage,expectedTitleOfContactNamePage);	 
			    test.log(Status.INFO, "Contact NamePage  is displayed");
	    	    
	    	    
	    	    
	      	
	    }
	    //6.Check the Cancel button works fine in Create New View
	    
	    @Test
	    public void isCancelButtonWorkingFineInCreateNewView() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		contactPage.clickOnCreateNewView(contactTestDataPro.getProperty("createnewviewlink"));
		 		test.log(Status.INFO, "Create new view  is displayed"); 
	    	ContactCreateNewViewpage  createNewViewPage=new ContactCreateNewViewpage(driver);
	     	createNewViewPage.setViewName(contactTestDataPro.getProperty("textofviewname1"), contactTestDataPro.getProperty("labelofviewname"));
	 		test.log(Status.INFO, "User enter  view name"); 
    	    createNewViewPage.setViewUniqueName(contactTestDataPro.getProperty("textOfviewuniquename"),contactTestDataPro.getProperty("labelofviewuniquename"));
	 		test.log(Status.INFO, "User enter  view unique  name"); 
    	    createNewViewPage.clickOnCancelButton(contactTestDataPro.getProperty("cancelbutton"));
	    	test.log(Status.INFO, "User click on  cancel button");
	    	 String exceptedTitleOfContactHomePage=contactTestDataPro.getProperty("titleofcontactpage");
	     	String actualTitleOfContactHomePage=createNewViewPage.getTitleOfTheContactHomePage();
	     	Assert.assertEquals(actualTitleOfContactHomePage, exceptedTitleOfContactHomePage);
	     	 test.log(Status.INFO, "Title of Page is matched with text");
	     	
	    }
	    //7.Check the Error message if, the required information is not entered while creating a New view in Contacts
	    @Test
	    
	    public void testErrorMessageOnCreateNewView() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		contactPage.clickOnCreateNewView(contactTestDataPro.getProperty("createnewviewlink"));
		 		test.log(Status.INFO, "Create new view  is displayed"); 
	    	    ContactCreateNewViewpage  createNewViewPage=new ContactCreateNewViewpage(driver);
	    		
	    	    createNewViewPage.setViewUniqueName(contactTestDataPro.getProperty("textOfviewuniquename"),contactTestDataPro.getProperty("labelofviewuniquename"));
		 		test.log(Status.INFO, "User enter  view unique  name"); 
		 		createNewViewPage.clickOnSaveButton(contactTestDataPro.getProperty("savebutton"));
		    	test.log(Status.INFO, "User click on  save button"); 
	    	    String exceptedErrorMessage1=contactTestDataPro.getProperty("errormessageofviewname");
	    	    String actualErrorMessage1=createNewViewPage.getTextOfErroMessageOnViewName();
	    	    Assert.assertEquals( actualErrorMessage1, exceptedErrorMessage1);
	    	    test.log(Status.INFO, "Error Message is displayed");
	    }
	    //8.Check the Save and New button works in New Contact page
	    @Test    
	    public void checkSaveAndNewButtonWorking() {
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
				//contacttab
		 	    homepage.clickOnContact(contactTestDataPro.getProperty("contacttab"));
		 		test.log(Status.INFO, "Contact Page is displayed"); 
		 		ContactPage contactPage=new ContactPage(driver);
		 		//1.Create new contact
		      	contactPage.clickOnNewButton(contactTestDataPro.getProperty("newbutton"));
		      	test.log(Status.INFO, "User click on new button"); 
		      	String actualTitleOFConEditNewPage=contactPage.getTitleOfTheContactEditNewContact(); 
		      	String exceptedTitleOFConEditNewPage= contactTestDataPro.getProperty("titleofpagecontacteditnewcontact");
		      	Assert.assertEquals(actualTitleOFConEditNewPage, exceptedTitleOFConEditNewPage);
		    	test.log(Status.INFO, "Contact edit page is displayed"); 
	      	    ContactEditNewContactPage  editNewConPage=new ContactEditNewContactPage(driver);
	      		editNewConPage.setLastName(contactTestDataPro.getProperty("textoflastname1"),contactTestDataPro.getProperty("labeloflastname1"));
		    	test.log(Status.INFO, "User enter lastname"); 
		    	editNewConPage.setAccountName(contactTestDataPro.getProperty("textofaccountname1"),contactTestDataPro.getProperty("labelofaccountname1"));
		    	test.log(Status.INFO, "User enter account name");
		    	editNewConPage.clickOnSaveAndNew(contactTestDataPro.getProperty("save&new"));
		      	test.log(Status.INFO, "User click on save & new button");
	      	    
		      	String exceptedTitleOFContactNamePage=contactTestDataPro.getProperty("titleofcontactnewcontactpage");
		      	String actualTitleOFContactNamePage=editNewConPage.getTitleOfContactEdit();
			    Assert.assertEquals(actualTitleOFContactNamePage, exceptedTitleOFContactNamePage);	 
			    test.log(Status.INFO, "New Contact Page is displayed");
			   
	      	
	     
	    }
	
	

}
