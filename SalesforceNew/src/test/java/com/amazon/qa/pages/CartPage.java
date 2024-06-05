package com.amazon.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.qa.basepage.BasePage3;

public class CartPage extends BasePage3 {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 
	@FindBy(xpath="//*[@id=\"sw-gtc\"]/span/a")public WebElement clickOnGoToCart;
	@FindBy(xpath="//span[@class='a-truncate-cut'][contains(text(),'Amazon Kindle Paperwhite (16 GB) – Now with a larg')]")public WebElement itemToCart;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")public WebElement clickOnAddToCartButton ;
	
	public void clickOnGoToCartButton(String goToCartText) {
		clickElement(driver, clickOnGoToCart, goToCartText);
	}
	public void verifyTheItemIsAvailableInCart(String itemText) {
		 try {
	            String cartContent = itemToCart.getText();
	            Assert.assertTrue(cartContent.contains(itemText), "Item '" + itemText + "' is not available in the cart");
	            System.out.println("Item '" + itemText + "' is present in the cart");
	        } catch (NoSuchElementException e) {
	            System.out.println("Cart element is not found");
	        } catch (Exception e) {
	            System.out.println("An error occurred while verifying item in the cart: " + e.getMessage());
	        }
	}
	  public void scrollDownToItemOnPage1() {
	    	robotClass();
	    }
	  public void clickOnAddCartButton() {
			switchToNewWindowAndPerformAction(clickOnAddToCartButton);
		}
	
}
