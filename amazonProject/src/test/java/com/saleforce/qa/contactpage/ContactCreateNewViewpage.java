package com.saleforce.qa.contactpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;



public class ContactCreateNewViewpage extends BasePage3{
    @FindBy(xpath="//input[@id='fname']")WebElement viewName;
    @FindBy(xpath="//input[@id='devname']")WebElement viewUniqueName;
    @FindBy(xpath="//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")WebElement saveButton;
    @FindBy(xpath="//input[@value='Cancel']")WebElement cancelButton;
    @FindBy(xpath="//div[@class='requiredInput']//div[@class='errorMsg']")WebElement errorOnViewName;
	public ContactCreateNewViewpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void setViewName(String viewNameData,String text) {
		clearElement(viewName, text);
		enterText(viewName,  viewNameData,  text);
	}
	public void setViewUniqueName() {
		clickElement(viewUniqueName);
	}
	public void setViewUniqueName(String viewNameData,String text) {
		clearElement(viewUniqueName, text);
		enterText(viewUniqueName,  viewNameData,  text);
	}
	public void clickOnSaveButton(String text) {
		 moveToElementAction(driver,saveButton,  text);
	}
	public void clickOnCancelButton(String text) {
		 moveToElementAction(driver, cancelButton,  text);
	}
	public String  getTitleOfTheContactHomePage() {
		return getPageTitle();
	}
	public String getTextOfErroMessageOnViewName() {
		return errorOnViewName.getText();
	}
}
