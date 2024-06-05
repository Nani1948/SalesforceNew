package com.salesforce.qa.home.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;


public class ConfigurationOfMyTabsPage extends BasePage3{
	
	
	@FindBy(linkText="Display & Layout")WebElement  displayAndLayout;
	@FindBy(xpath="//a[@id='CustomizeTabs_font']")WebElement customizeMyTabs;
	@FindBy(xpath="//select[@id='p4']")private List<WebElement> ListOfCustomApp;
	@FindBy(tagName="select")WebElement dropdownListOfCustomApp;
	@FindBy(xpath="//select[@id='p4' and @name='p4']")WebElement salesforceChatterOptions;
	@FindBy(xpath="//select[@id='duel_select_1']")WebElement reportFromSelectedTabs;
	@FindBy(xpath="//select[@id='duel_select_0']/option[@value='report']")WebElement reportsOnAvailableTabs;
	@FindBy(xpath="//img[@title='Remove']")WebElement removeButton;
    @FindBy(xpath="//img[@title='Add']")WebElement  addButton;
    @FindBy(xpath="//input[@name='save']")WebElement Save;
	//Sales
	@FindBy(xpath="//select[@id='p4' and @name='p4']")WebElement salesOptions;
	//Marketing 
	@FindBy(xpath="//select[@id='p4' and @name='p4']")WebElement marketingServiceOptions;
	//PageDropdown
	@FindBy(xpath="//div[@id='tsid-arrow']")WebElement PagesDropdown;
	@FindBy(xpath=" //a[contains(text(),'Reports')]")WebElement reportTabs;
	//close Popup();
	@FindBy(xpath="//a[contains(text(),'Close')]")WebElement close;	
	//Pages
	@FindBy(linkText="Sales")WebElement salesPage;
	///a[normalize-space()='Salesforce Chatter']
	@FindBy(css="#tsidLabel")WebElement salesforceChatterPage;
	@FindBy(linkText="Marketing CRM Classic")WebElement marketingPage;
	@FindBy(xpath="//ul[@id='tabBar']//li") private List<WebElement> tabElements;
	@FindBy(xpath="a//[@title='Reports Tab']")WebElement report; 
	public ConfigurationOfMyTabsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void clickOnDisplayAndLayOut() {
	    	moveToElementAction(driver,   displayAndLayout,"  Display And Layout");
	    }
    public void clickOnCustomizeMyTabs() {
	    	moveToElementAction(driver,  customizeMyTabs,"CustomizeMyTabs");
	    }
    public void clickOnDropdownListOfCustomApp() {
    	moveToElementAction(driver,   dropdownListOfCustomApp,"CustomApp");
    }
    public  void getListofOfCustomApp() {
      	 List<WebElement> selectOptions= new ArrayList<>();

   	        for (WebElement listOfOptions : ListOfCustomApp) {
   	        	selectOptions.add(listOfOptions );
   	            getText(listOfOptions);
   	        }
      }
    public void selectSalesforceChatter(String text) {
    	//selectByVisibleTextOfElement(salesforceChatterOptions, text);
    	selectOptionByPartialText(salesforceChatterOptions, text);
    	
    }
    public void selectSales(String text) {
    	selectOptionByPartialText(salesOptions,text);
    }
    public void selectMarketing(String text) {
    	selectOptionByPartialText(marketingServiceOptions,text);
    }
    public void selectReportsFromAvailableTabs(String  text) {
    	//moveToElementAction(driver, reports,"Reports");
     	selectOptionByPartialText(reportsOnAvailableTabs, text);
    }
   public void selectReportFromSelectedTabs(String text) {
	   selectOptionByPartialText(reportFromSelectedTabs, text);
   }
   public void clickOnRemove() {
	   moveToElementAction(driver,  removeButton,"Remove");
   }
   public void clickOnAdd() {
	   moveToElementAction(driver,  addButton,"Add");
   }
   public void clickOnSave() {
   	moveToElementAction(driver,Save,"Save");
   }


public void clickOnPageMenuDropdown() {
	//PagesDropdown
	moveToElementAction(driver,PagesDropdown,"Pages Menu Dropdown");
}


public void clickOnSalesforceChatterFromPagesDropDown(String text) {		
	moveToElementAction(driver,  salesforceChatterPage,text);
}
public void clickOnSalesFromPagesDropDown(String text) {
	

	moveToElementAction(driver,  salesPage,text);
}
public void clickOnMarketingFromPagesDropDown(String text) {
	
	
	moveToElementAction(driver,  marketingPage,text);
}
public String  getTextOfReport(String text) {
	List<WebElement> allTabs=new ArrayList<>();
  for(WebElement tabElement:tabElements) {
	  allTabs.add(tabElement);
	  String tabText=tabElement.getText();
	  if(tabText.equals(text)) {
		 System.out.println(text+"is visible on the  homepage");
		  return tabText;
		
	  }
	 
  }
  return null;
}
public void clickOnClose(String text) {
	clickElement(driver, close, text);
}

}
