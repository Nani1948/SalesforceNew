package com.saleforce.qa.opportunitiespage;

import org.openqa.selenium.WebDriver;

import com.salesforce.qa.basepage.BasePage3;


public class OpportunityPipelinePage extends BasePage3{

	public OpportunityPipelinePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String  getTitleOfTheOfOpportunityPipeline() {
		return getPageTitle();
	}

}
