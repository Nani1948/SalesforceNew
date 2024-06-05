package com.saleforce.qa.opportunitiespage;

import org.openqa.selenium.WebDriver;

import com.salesforce.qa.basepage.BasePage3;



public class StuckOpportunitiesReportPage extends BasePage3{
    
	
	
	
	public StuckOpportunitiesReportPage(WebDriver driver) {
		super(driver);
		
	}
	public String  getTitleOfTheOfStuckOpportunity() {
		return getPageTitle();
	}

}
