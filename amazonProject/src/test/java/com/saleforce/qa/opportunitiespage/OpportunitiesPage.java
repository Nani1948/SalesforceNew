package com.saleforce.qa.opportunitiespage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.qa.basepage.BasePage3;
import com.salesforce.qa.utilty.PropertiesUtliyClass;


public class OpportunitiesPage extends BasePage3{
	
	PropertiesUtliyClass prop=new PropertiesUtliyClass();
	Properties applicationPro=prop.loadFile("data.properties");
	Properties accounttestDataPro=prop.loadFile("accounttestdata.properties");
	Properties opportunitiestestDataPro=prop.loadFile("opportunitiestestdata.properties");
	
	
    @FindBy(xpath="//select[@id='fcf']")WebElement  dropdownListOfView;
    @FindBy(xpath="//select[@id='fcf']")private List<WebElement> dropdownListOfView1;
	@FindBy(xpath="//input[@title='New']")WebElement newButton;
	@FindBy(xpath="//a[normalize-space()='Opportunity Pipeline']")WebElement opportunityPipeline;
	@FindBy(xpath="//a[normalize-space()='Stuck Opportunities']")WebElement stuckOpportunities;
	@FindBy(xpath="//select[@id='quarter_q']")WebElement  interval;
	@FindBy(xpath="//select[@id='open']")WebElement include;
	@FindBy(xpath="//input[@title='Run Report']")WebElement runReport;
    public OpportunitiesPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnDropdownListOfView(String text) {
		moveToElementAction(driver, dropdownListOfView,text);
	}
	public void testDropdownListOFView() {
	    List<WebElement> actualDropdownListOFView = getTextOfDropdownListOFView1();

	   /* List<String> expectedDropdownListOFView = List.of(
	        "All Opportunities",
	        "Closing Next Month",
	        "Closing This Month",
	        "My Opportunities",
	        "New This Week",
	        "Recently Viewed Opportunities",
	        "Won"
	    );*/
	    List<String> expectedDropdownListOFView=List.of(opportunitiestestDataPro.getProperty("view.option").split(","));
	    for (String expectedOption : expectedDropdownListOFView) {
	        boolean optionFound = false;
	        for (WebElement actualElement : actualDropdownListOFView) {
	            String actualOption = actualElement.getText();
	            if (actualOption.contains(expectedOption)) {
	                optionFound = true;
	                break;
	            }
	        }
	        Assert.assertTrue(optionFound, "Dropdown option not found: " + expectedOption);
	    }
	}
	     
	// Method to retrieve the actual dropdown list (replace with your implementation)
	public List<WebElement> getTextOfDropdownListOFView1() {
	    List<WebElement> listOfView = new ArrayList<>();

	    for (WebElement listOfDropdownView : dropdownListOfView1) {
	        String textOfDropdownOfView = listOfDropdownView.getText();
	        listOfView.add(listOfDropdownView);
	        
	    }

	    return listOfView;
	}
	public void clickOnNew(String text) {
		moveToElementAction(driver, newButton,text);
	}
	public void clickOnOpportunityPipeline(String text) {
		moveToElementAction(driver, opportunityPipeline,text);
	}
	public void clickOnStuckOpportunities(String text) {
		moveToElementAction(driver, stuckOpportunities,text);
	}
    public void selectOptionFromInterval(String text) {
		moveToElementAction(driver,interval,text);
	    selectByVisibleTextOfElement(interval, text);
   }
    public void selectOptionFromInclude(String text) {
		moveToElementAction(driver,include,text);
	    selectByVisibleTextOfElement(include, text);
   }
    public void clickOnRunReport(String text) {
		moveToElementAction(driver, runReport,text);
	}  
   
	
}