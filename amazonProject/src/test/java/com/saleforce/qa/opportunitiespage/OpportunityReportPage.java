package com.saleforce.qa.opportunitiespage;

import org.openqa.selenium.WebDriver;

import com.salesforce.qa.basepage.BasePage3;



public class OpportunityReportPage extends BasePage3{

	public OpportunityReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String  getTitleOfTheOpportunityReport() {
		return getPageTitle();
	}
}
