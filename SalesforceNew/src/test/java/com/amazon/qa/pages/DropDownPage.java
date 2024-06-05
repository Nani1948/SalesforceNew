package com.amazon.qa.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.basepage.BasePage3;
import com.salesforce.qa.utilty.PropertiesUtliyClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPage extends BasePage3{
	public DropDownPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//input[@aria-describedby='midmarketFromCurrency-current-selection']")
    public static WebElement clickOnArrowDropdown;
    
    @FindBy(xpath = "(//span[@class='dark-text'])[1]")
    public static  WebElement clickOnFromdropdown;
    @FindBy(xpath="(//div[@class='sc-18e7c3da-4 gSGrCl'])[2]")
    public static WebElement clickOnToArrowDropdown;
//
    @FindBy(css= "li[id='midmarketToCurrency-option-6'] span[class='description']")
    public static  WebElement clickOnTodropdown;

    @FindBy(xpath = "//button[normalize-space()='Convert']")
    public static WebElement clickOnConvertButton;

   public void selectUSFromDropDown() {
	clickElement(clickOnArrowDropdown); 
    moveToElementAction(clickOnFromdropdown);
   }

   public void selectINRFromDropDown(String text) {
	   clickElement(driver, clickOnToArrowDropdown, text); 
	 
	   Actions actions = new Actions(driver);

	   // Perform key press actions to scroll down, you can adjust the number of times you want to press the down arrow key
	   for (int i = 0; i < 6; i++) {
		   //moveToElementAction(clickOnTodropdown);
	       actions.sendKeys(Keys.ARROW_DOWN).click().build().perform();
	       
	   }
	   
   }

   public void selectINRFromDropDown() {
	   clickElement(clickOnToArrowDropdown); 
	 
	   Actions actions = new Actions(driver);

	  /* // Perform key press actions to scroll down, you can adjust the number of times you want to press the down arrow key
	   for (int i = 0; i < 6; i++) {
		   //moveToElementAction(clickOnTodropdown);
	       actions.sendKeys(Keys.ARROW_DOWN).click().build().perform();
	       
	   }*/
	 
	   actions.moveToElement(clickOnTodropdown).click().perform();
	   
   }
   public void clickOnConvert() {

	   clickOnConvertButton.click();
   }
   public void loginToXeApp(String url,WebDriver driver) {
	  	  goToURL(url);
	  	  driver.manage().window().maximize();
	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  	
	    }

 
}
