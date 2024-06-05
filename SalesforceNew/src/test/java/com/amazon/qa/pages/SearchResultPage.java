package com.amazon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;
import com.salesforce.qa.utilty.ScrollUtils;

public class SearchResultPage extends BasePage3 {
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath="//img[@alt='Amazon Kindle Paperwhite (16 GB) – Now with a larger display, adjustable warm light, increased battery life, and faster pa...']")private WebElement clickOnPicture ;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")public WebElement clickOnAddToCartButton ;
    
    
    public void clickOnKindlePicutre(String clickOnPictureOfAmazonChoice) {
    	moveToElementAction(driver, clickOnPicture , clickOnPictureOfAmazonChoice);
    }
    public void scrollDownToItem(int data) {
    	ScrollUtils scroll=new ScrollUtils(driver);
    	scroll.waitForScrollToComplete(data);
    	//scrollDown(data);
    }
    public void scrollDownToItemOnPage() {
    	robotClass();
    }
    public void clickOnAddCartButton() {
    	
		switchToNewWindowAndPerformAction(clickOnAddToCartButton);
	}
    
    public void clickOnAddCartButton1(String addToCartText) {
		  clickElement(driver, clickOnAddToCartButton, addToCartText);
		}
}
