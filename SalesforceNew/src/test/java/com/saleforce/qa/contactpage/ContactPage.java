package com.saleforce.qa.contactpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.qa.basepage.BasePage3;



public class ContactPage extends BasePage3 {
	@FindBy(linkText="Close")WebElement close;
	@FindBy(xpath="//input[@title='New']")WebElement newButton;
	@FindBy(xpath="//input[@id='name_lastcon2']")WebElement lastName;
	@FindBy(xpath="//input[@id='con4']")WebElement accountName;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")WebElement saveButton;
	@FindBy(xpath="//a[normalize-space()='Create New View']")WebElement  createNewView;
	@FindBy(xpath="//*[@id='hotlist_mode']")WebElement listOfDropdown;
	@FindBy(xpath="//option[text()='Recently Created']")WebElement recentlyCreated;
	@FindBy(xpath="//option[text()='My Contacts']")WebElement mycontacts;
	//@FindBy(id="hotlist_mode")WebElement selectOptionFromRecentContact;
	@FindBy(xpath="//select[@id='hotlist_mode' and @name='hotlist_mode']")WebElement selectOptionFromRecentContact;
	@FindBy(xpath="//select[@id='fcf']")WebElement dropdownListOfView;
	@FindBy(xpath="//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")WebElement    contactName;
    @FindBy(xpath="//select[@id='00Bbm000002lc7D_listSelect' and @name='fcf']/text()[1]")public WebElement dropdownOptionofView;
    @FindBy(xpath="(//select[@id='00Bbm000002lc7D_listSelect'])[1]")public WebElement dropdownView;
    @FindBy(xpath="//select[contains(@id, '00Bbm000002lc7D_listSelect')]")public WebElement dropdownView1;
    
    @FindBy(xpath="//select[@name='fcf' and  @title='View:']/option[5]")WebElement viewDropdownOnGo;
    //@FindBy(css="class.title")public WebElement dropdownView1;
    public ContactPage(WebDriver driver) {
		super(driver);
	}
	public void clickOnClose(String text) {
		   moveToElementAction(driver, close,  text);
	}
	public void clickOnNewButton(String text) {
		   moveToElementAction(driver, newButton,  text);
	}
	public String  getTitleOfTheContactEditNewContact() {
		return getPageTitle();
	}
	public void setLastName(String lastNameData,String text) {
		clearElement(lastName, text);
		enterText(lastName, lastNameData,  text);
	}
	public void setAccountName(String accountNameData,String text) {
		clearElement(accountName, text);
		enterText(accountName, accountNameData,  text);
	}
	public void clickOnSave() {
		//performMouseHoverWithWait(driver, saveButton);
		moveToElementAction(driver,saveButton);
	}
	public String  getTitleOfTheContactName() {
		return getPageTitle();
	}
	public void clickOnCreateNewView(String text) {
		 moveToElementAction(driver,createNewView,  text);
	}
	public void  selectOptionFromDropdown(String text) {
		waitForElementToBeVisible(driver, listOfDropdown, text);
		moveToElementAction(driver,listOfDropdown,  text);
		//selectByVisibleTextOfElement(listOfDropdown, text);
		selectByVisibleTextOfElement(listOfDropdown, text);
	}
	public String selectOptionFromViewDropdown1() {
		performMouseHoverWithWait(driver,  dropdownView1);
		// dropdownView1.click();
		 mycontacts.click();
		 return mycontacts.getText();
	}
	public void  selectoptionFromViewDropdown(String text,String text1) {
		moveToElementAction(driver,dropdownListOfView,  text);
		selectByVisibleTextOfElement(dropdownListOfView, text1);
	}
	public void clickOnContactName() {
		 moveToElementAction(driver,contactName);
	}
	public String getTextContactName() {
		return contactName.getText();
	}
	public String getTextOFDropdown() {
	    // String textOfDropdown =dropdownListOfView.getText().trim();
		//String textOfDropdown =recentlyCreated.getText().trim();
		//String textOfDropdown =selectOptionFromRecentContact.getText().trim();
	  // Use JavaScript to get the selected option text

         JavascriptExecutor js = (JavascriptExecutor) driver;
         String script = "return arguments[0].options[arguments[0].selectedIndex].text";
   
		return (String) js.executeScript(script,selectOptionFromRecentContact);
		
	}
	  public String getStoredDefaultViewOfDropdown() {
		    // Replace with actual ID of the view dropdown
		       String defaultView =  viewDropdownOnGo.getText().trim();
		       return defaultView;
		   }
	public void closeAlert() {
		switchToAlertAndDismiss();
	}
	 public void  selectOptionMyContacts(String text) {
	       Select dropdown = new Select( dropdownListOfView);
	       for (WebElement option : dropdown.getOptions()) {
	           String optionText = option.getText();
	           System.out.println("Dropdown Option: " + optionText);
	       }
	       dropdown.selectByVisibleText(text);
	   }
	 public void  selectOptionRecentlyCreated(String text) {
		 selectOptionFromDropdownByText(selectOptionFromRecentContact,text);
	   }
	 
	  /* public void selectMyContacts(String text) {
		   //waitForElementToBeVisible(driver, listOfDropdown, text);
			//moveToElementAction(driver,listOfDropdown,  text);
			//selectByVisibleTextOfElement(listOfDropdown, text);
			selectByVisibleTextFromDropdown(listOfDropdown, text);
	   }*/
}
