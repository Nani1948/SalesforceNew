package com.saleforce.qa.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;



public class AllTabsPage extends BasePage3{
    @FindBy(xpath="//input[@title='Customize My Tabs']")WebElement customizedMyTabs;
	public AllTabsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickOnCustomizeMyTabs(String text) {
    	moveToElementAction(driver, customizedMyTabs,text);
    	
  }
	
	
  
}
