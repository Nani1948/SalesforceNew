package com.salesforce.qa.accountpages;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.salesforce.qa.basepage.BasePage3;
import com.salesforce.qa.home.page.HomePage;
import com.salesforce.qa.loginpages.LoginPage;
import com.salesforce.qa.test.AccountTest;
import com.salesforce.qa.utilty.CommonUtilis;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.WaitConstant;

public class AccountPage extends BasePage3 {

	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(linkText="Close")public WebElement close;
	//AccountTab
		@FindBy(linkText="Accounts")public WebElement  accountTab;
   @FindBy(xpath="//input[@title='New']")public WebElement  newButton;
   @FindBy(xpath="//input[@id='acc2' and @name='acc2']")public WebElement  enteraccountName;
   @FindBy(xpath="//select[@id='acc6']")public WebElement  typeDropdown;   
   @FindBy(xpath="//select[@id='00Nbm000000nGA6']")public WebElement  customerPriorityDropdown;
	@FindBy(xpath="//input[@name='save' and @value=' Save ']") WebElement saveButton;
	//@FindBy(xpath=" //div[@id='acc2_ileinner']")public WebElement accountName;
	////*[@id="acc2_ileinner"]/text()
	@FindBy(xpath="//div[@id='acc2_ileinner']")public WebElement accountName;
	@FindBy(xpath="//div[@id='00Nbm000000nGA6_ileinner']")public WebElement  customerPriorityDropdownText;
	@FindBy(xpath="//*[@id=\"acc6_ileinner\"]")public WebElement  typeDropdownText;
	@FindBy(xpath="//a[text()='Create New View']")public WebElement   createNewViewLink;
	@FindBy(xpath="//input[@id='fname']")WebElement  viewName;
	@FindBy(xpath="//input[@id='devname']")WebElement uniqueName;
	@FindBy(xpath="//input[@name='save' and @data-uidsfdc='3']") WebElement saveButtonOnCreateNewView;
	@FindBy(xpath="//select[@id='00Bbm000004zoDd_listSelect']/option[1]")public WebElement dropdownOFCreateNewView;
	@FindBy(xpath="//input[@value=' Go! ']")WebElement go;
	@FindBy(xpath="//a[contains(text(),'Edit')]") WebElement editButton;
	
	@FindBy(xpath="//select[@id='fcf']")WebElement  dropdownListOfView;
	@FindBy(xpath="//input[@id='fscope1']")WebElement  allAccount;
	@FindBy(xpath="//select[@id='fcol1']")WebElement   selectAccountName;
	@FindBy(xpath="//select[@id='fop1']")WebElement   operator;
	@FindBy(xpath="//input[@id='fval1']")WebElement value;
	@FindBy(xpath="//input[@value=' Save ' and @name='save'][1]")WebElement saveButton1;
	@FindBy(linkText="Merge Accounts")WebElement mergeAccount;
	@FindBy(linkText="Accounts with last activity > 30 days")WebElement accountsIsGreaterThan30Days;
	
	@FindBy(xpath="//select[@title='View:']")WebElement accountViewListDropdown;
	@FindBy(xpath="//select[@id='colselector_select_0']//option[@value='ACCOUNT.LAST_ACTIVITY'][normalize-space()='Last Activity']") WebElement lastActivity;
    @FindBy(xpath="//a[@id='colselector_select_0_right']//img[@title='Add']")WebElement add;
    
    
   // @FindBy
	public void clickOnClose(String text) {
		   moveToElementAction(driver, close,  text);
	}
  public void getPageLoad() {
	  
         waitForPageLoad(); 
  }
   public void clickOnNewButton() {
	   
	   
	  moveToElementAction(newButton);
   }
   public void setTextIntoAccountName(String textdata, String objName) {
	   enterText(enteraccountName, textdata, objName);
   }
   
   
   public void  selectOptionsFromType(String Option)  {
	   
	   selectByVisibleTextFromDropdown(typeDropdown, Option);
	  

   }
   
   public void  selectOptionsFromCustomerPriority(String Option)  {
	   selectByVisibleTextFromDropdown(customerPriorityDropdown, Option);

   }
 
   public void clickOnSave(String text) {
		 moveToElementAction(driver, saveButton,  text);
   }
   /*
    * return title of account page
    * */
   public String getTitleOfAccountPage() {
	// TODO Auto-generated method stub
	return getPageTitle();
   }
  
 

   
// Method to check if the account name is displayed on the page
   public String getAccountNameText() {
       // Replace "accountNameLocator" with the actual locator for the account name element
	   String accountNameFull = accountName.getText();
	   String accountName = accountNameFull.split(" \\[")[0].trim(); // Split by " [" and take the first part
	   System.out.println("Account Name: " + accountName);

              return accountName;
   }
   public String getTypeOptionText() {
	   return typeDropdownText.getText();
   }
   public String getCustomerPriorityOptionText() {
	   return customerPriorityDropdownText.getText();
   }
   public String getIntValueOfAccountNameIndex(Properties accounttestDataPro2,String text) throws IOException {
	   return getIntValue( accounttestDataPro2, text);
	   
   }
  public String getTitleOfNewAccountPage() {
	  return driver.getTitle();
  }
  public void clickOnCreateNewView(String text) {
	  moveToElementAction(driver, createNewViewLink,  text);
  }
  public void setViewName(String viewNameData,String text) {
		enterText(viewName,viewNameData,  text);
	}
  
  public void clickUniqueName() {
	  clickElement( uniqueName);
		
	}
  public void updateViewName(String viewNameData,String text) {
	  Actions action=new Actions(driver);
		action.moveToElement(viewName).sendKeys(Keys.BACK_SPACE).build().perform();
		enterText(viewName,viewNameData,  text);
	}
	
	
	public void UpdateUniqueName() {
		 
		uniqueName.clear();	
		viewName.click();
		Actions action=new Actions(driver);
		action.moveToElement(uniqueName).click().build().perform();
		
		
		
	}
	 public void clickOnSaveButtonOnCreateNewView(String text) {
		 moveToElementAction(driver, saveButtonOnCreateNewView,  text);
   }
	 public List<String> getTextOfDropdownOFCreateNewView(String  expectedOptions) {
		 // Step 1: Wait for the dropdown to be populated and visible
	        WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD); // Adjust the timeout as needed
	        WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(dropdownOFCreateNewView));

	        // Step 2: Retrieve the options from the dropdown
	        dropdown.click();
	        List<WebElement> dropdownOptions = dropdown.findElements(By.tagName("option"));
	        List<String> actualOptions = dropdownOptions.stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	        return actualOptions;
	 }
	 public void SelectTextOptionOFDropdownCreateNewView(String text) {
		 selectOptionByText( dropdownOFCreateNewView, text);
	 }
	 public void selectFromViewDropdown(String text) {
			selectByVisibleTextOfElement(dropdownListOfView, text);
		}
		public void clickOnEdit(String text) {
			 moveToElementAction(driver,editButton,  text);
		}
		public void selectDropdownOptionsFromViewList(String option) {
			moveToElementAction(accountViewListDropdown);
			 isOptionSelectedInDropdown(accountViewListDropdown, option);
		}
		public void clickOnAllAccount(String text) {
			 moveToElementAction(driver, allAccount,  text);
		}
		public void  selectEqualFromOperator(String text) {
			selectByVisibleTextOfElement( operator, text);
		}
		public void  selectAccountNameFromField(String text) {
			//selectAccountName.click();
			selectByVisibleTextOfElement(selectAccountName, text);
		}
		public void setValue(String valueData,String text) {
			enterText(value,valueData,  text);
		}
		
		public void selectOptionsfromAvailableField(String pixels,String option) {
			scrollDown(pixels);
			moveToElementAction(lastActivity);
			 isOptionSelectedInDropdown(lastActivity, option);
		}
		public void clickOnAdd() {
			moveToElementAction(add);
		}
		
		
		public void clickOnAccountsIsGreaterThan30Days(String text,String pixels) {
			scrollDown(pixels);
			moveToElementAction(driver, accountsIsGreaterThan30Days,  text);
		}
		public void clickOnMergeAccount(String text) {
			 
			moveToElementAction(driver, mergeAccount,  text);
		}
		
		
}