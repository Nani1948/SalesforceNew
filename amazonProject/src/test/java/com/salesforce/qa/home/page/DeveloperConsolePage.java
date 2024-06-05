package com.salesforce.qa.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;


public class DeveloperConsolePage extends BasePage3 {
   @FindBy(xpath="//a[@class='debugLogLink menuButtonMenuLink']")WebElement developerConsole;
	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
		
	}
	public void clickOnDeveloperConsole() {
		moveToElementAction(driver, developerConsole,"Developer Console");
		System.out.println("Developer console is opened");
	}
	public void closeBrowser() {
		closeCurrentWindow(driver);
	}
}
