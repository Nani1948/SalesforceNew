package com.salesforce.qa.home.page;

import org.openqa.selenium.WebDriver;

import com.salesforce.qa.basepage.BasePage3;

public class RemainderPage extends BasePage3 {

	public RemainderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getTitleOfPage() {
		return driver.getTitle();
	}

}
