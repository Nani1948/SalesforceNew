package com.saleforce.qa.leadpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.qa.basepage.BasePage3;



public class LeadPage extends BasePage3{
    @FindBy(linkText="Leads")WebElement leadTab;
    @FindBy(linkText="Close")WebElement close;
    @FindBy(xpath = "//select[@id='fcf' and @name ='fcf']")public WebElement dropdownElement;
	@FindBy(xpath="//input[@value=' Go! ']")WebElement go;
    @FindBy(xpath="//input[@name='new']")WebElement newButton;
	@FindBy(xpath="//select[@id='fcf']")WebElement viewDropdown;
	@FindBy(xpath="//select[@name='fcf' and @title='View:']")WebElement viewDropdownOnGo;
	public LeadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   public void clickOnLead(String text) {
	   moveToElementAction(driver, leadTab,  text);
   }
   public void clickOnClose(String text) {
	   moveToElementAction(driver, close,  text);
   }
   
  

   public void getListOfAllDropdownOptions() {
       Select dropdown = new Select(dropdownElement);
       for (WebElement option : dropdown.getOptions()) {
           String optionText = option.getText();
           System.out.println("Dropdown Option: " + optionText);
       }
       //dropdown.selectByVisibleText(text);
   }
   public void selectTodayLeads(String text) {
	   selectByVisibleTextOfElement(dropdownElement,text);
   }
   public void clickOnGo(String text) {
	   moveToElementAction(driver,go,  text);
   }
   public void clickOnNew(String text) {
	   moveToElementAction(driver,newButton,  text);
   }
   public String getTitleOfLeadPage() {
	   return driver.getTitle();
   }
   public String getStoredDefaultView() {
    // Replace with actual ID of the view dropdown
       String defaultView =  dropdownElement.getText().trim();
       return defaultView;
   }
  
   public String getStoredDefaultViewOFGo() {
	    // Replace with actual ID of the view dropdown
	       String defaultView =  viewDropdownOnGo.getText().trim();
	       return defaultView;
	   }
}
