package com.saleforce.qa.opportunitiespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;



public class OpportunityEditNewOpportunityPage extends BasePage3{
    @FindBy(xpath="//*[@id='opp3']")WebElement  opportunityName;
    @FindBy(xpath="//input[@id='opp4']")WebElement accountName;
    @FindBy(xpath="//input[@id='opp9']")WebElement closeDate;
    @FindBy(xpath="//a[@class='calToday']")WebElement  todayLink;
    @FindBy(xpath="//select[@id='opp5']")WebElement   type;
    @FindBy(xpath="//select[@id='opp11']")WebElement  stage;
    @FindBy(xpath="//select[@id='opp6']")WebElement leadSource;
    @FindBy(xpath="//input[@id='opp12']")WebElement  probability;
    @FindBy(xpath="//input[@id='opp17']")WebElement primaryCampaignSource;
    @FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")WebElement saveButton;
	public OpportunityEditNewOpportunityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public void setOpportunityName(String opportunityNameData, String text) {
    	clearElement(opportunityName, text);
		enterText(opportunityName,opportunityNameData,text);
    }
    public void setAccountName(String accountNameData, String text) {
    	clearElement(accountName, text);
		enterText(accountName,accountNameData,text);
    }
    public void clickOnCloseDate(String text) {
		moveToElementAction(driver, closeDate,text);
	}
    
    public void clickOnTodayLink(String text) {
		moveToElementAction(driver, todayLink,text);
	}
    public void selectOptionFromType(String text) {
    	moveToElementAction(driver, type,text);
    	selectByVisibleTextOfElement(type, text);
    }
    public void selectOptionFromStage(String text) {
    	moveToElementAction(driver, stage,text);
    	selectByVisibleTextOfElement(stage, text);
    }
    public void selectOptionFromLeadSource(String text) {
    	moveToElementAction(driver, leadSource,text);
    	selectByVisibleTextOfElement(leadSource, text);
    }
    
    public void setProbability(String probabilityData, String text) {
    	clearElement(probability, text);
		enterText(probability,probabilityData,text);
    }
    public void setPrimaryCampaignSource(String primaryCampaignSourceData, String text) {
    	clearElement(primaryCampaignSource, text);
		enterText(primaryCampaignSource,primaryCampaignSourceData,text);
    }
    
    public void clickOnSaveButton(String text) {
		moveToElementAction(driver, saveButton,text);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
