package com.amazon.qa.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;
import com.salesforce.qa.utilty.PropertiesUtliyClass;

public class AmazonHome extends BasePage3 {

    public AmazonHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath= "//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    @FindBy(xpath="//input[@id='nav-search-submit-button' and @type='submit']")
    private WebElement searchButton;
    @FindBy(xpath="//a[@onclick='window.location.reload()']")
    private WebElement clickOnDifferentImage;
   
    
    public void clickOnDifferntImageLink(String clickOnLink) {
    	moveToElementAction(driver,  clickOnDifferentImage, clickOnLink);
    }
    
    // Method to send text to the search box
    public void sendTextToSearchBox(String searchText) {
       enterText(searchBox, searchText, searchText);
    }

    // Method to click on the search button
    public void clickSearchButton(String clickOnIcon) {
     //  clickElement(driver, searchButton, clickOnIcon);
    	moveToElementAction(driver,  searchButton, clickOnIcon);

}
    public void loginToApp(String url,WebDriver driver) {
      PropertiesUtliyClass prop=new PropertiesUtliyClass();
  	  Properties applicationPro=prop.loadFile("data.properties");
  	  goToURL(applicationPro.getProperty("url"));
  	  driver.manage().window().maximize();
  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  	
    }
}