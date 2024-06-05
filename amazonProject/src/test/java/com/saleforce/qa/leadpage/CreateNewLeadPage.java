package com.saleforce.qa.leadpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;


public class CreateNewLeadPage extends BasePage3{
    @FindBy(xpath="//input[@id='name_lastlea2']")WebElement lastName;
    @FindBy(xpath="//input[@id='lea3']")WebElement companyName;
    @FindBy(xpath="//input[@name='save']")WebElement saveButton;
	public CreateNewLeadPage(WebDriver driver) {
		super(driver);
	}
   public void setLastName(String text,String lastNameData) {
	   clearElement(lastName, text);
		enterText(lastName,  lastNameData,  text);
   }
	
   public void setCompanyName(String text,String companyNameData) {
	   clearElement(companyName, text);
		enterText(companyName,  companyNameData,  text);
   }
   public void clickOnSave(String text) {
	   moveToElementAction(driver,  saveButton,  text);
   }
}
