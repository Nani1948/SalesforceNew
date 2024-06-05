package com.salesforce.qa.accountpages.accountreportpage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.salesforce.qa.basepage.BasePage3;
import com.salesforce.qa.utilty.WaitConstant;


public class AccountReport extends BasePage3 {
    @FindBy(id="ext-gen148")WebElement dropdownListOfDate;
    @FindBy(xpath="//div[contains(text(),'Created Date')]")WebElement createDate;
    @FindBy(xpath="//img[@id='ext-gen152']")WebElement clickOnFromDateCalendarIcon;
    @FindBy(xpath="//*[@id=\'ext-gen281\']")WebElement todayDate;
    @FindBy(xpath="//button[@id='ext-gen49']")WebElement saveButton;
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")WebElement  reportName;
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']")WebElement    reportUniqueName;
	@FindBy(xpath="(//button[normalize-space()='Save and Run Report'])[1]")WebElement  saveAndRunReport;
	@FindBy(xpath="//div[@id='ext-gen253']")WebElement listofRecordDisplay;
	@FindBy(xpath="//*[@id='ext-gen150']")public WebElement  rangeDropdown;
	@FindBy(xpath="//div[normalize-space()='All Time']")public WebElement allTimeOption;
	
	@FindBy(xpath="//*[@id=\'saveReportDlg\']")public WebElement popupwindow;
    public AccountReport(WebDriver driver) {
		super(driver);
	}
	public void clickOnDropdownDate(String text) {
		 
		moveToElementAction(driver, dropdownListOfDate,  text);
	}
	public void clickOnDropdownRange() {
		 
		moveToElementAction(rangeDropdown);
	}
	public void clickOnDropdownRangeOption() {
		 
		performMouseHoverWithWait(driver,allTimeOption);
	}
	public void clickOnCreateDate(String text) {
		 
		//moveToElementAction(driver, createDate,  text);
		//selectOptionByText( createDate, text);
		moveToElementAction(createDate);
	}
	public void clickOnFromCalendarIcon(String text) {
		waitForElementToBeVisible(driver, clickOnFromDateCalendarIcon, text);
		moveToElementAction(driver, clickOnFromDateCalendarIcon,  text);
	}
	public void clickOnTodayDate(String text) {
		
		moveToElementAction(driver,todayDate,  text);
	}
	public void clickOnSaveButton(String text) {
		moveToElementAction(driver,saveButton,  text);
		
	}
		
	public void setReportName(String reportNameData,String text) {
		clearElement(reportName, text);
		enterText( reportName,reportNameData,  text);
	}
	public void setReportUniqueName() {
		  clickElement(reportUniqueName);
	}//saveAndRunReport
	public void clickOnSaveAndRunReport(String text) {
		//waitForElementToBeVisible(driver, saveAndRunReport, text);
		//performMouseHoverWithWait(driver,saveAndRunReport);
		moveToElementAction(driver,saveAndRunReport,  text);
} 
	
	
	public String getTitleOfAccountReportPage() {
	// TODO Auto-generated method stub
	return getPageTitle();
   }
   public void saveReportPopupWindow() {
	   waitForElementToBeVisible(driver,popupwindow);
   }
	public void verifyListOfAccountDisplayed() {
		

         // Step 3: Wait for the list of records to be visible
         WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
         wait.until(ExpectedConditions.visibilityOf(listofRecordDisplay));

         // Step 4: Verify that the list of records is displayed
         Assert.assertTrue(listofRecordDisplay.isDisplayed(), "List of records is not displayed!");

         // Print out the text of the records list or any other verification
         System.out.println("List of records: " + listofRecordDisplay.getText());
	}
	
	public String waitForTitle(String text) {
		

        // Step 3: Wait for the list of records to be visible
        WebDriverWait wait = new WebDriverWait(driver, WaitConstant.PAGELOAD_WAIT_TIME);
        wait.until(ExpectedConditions.titleContains( text));

       return text;
	}
}