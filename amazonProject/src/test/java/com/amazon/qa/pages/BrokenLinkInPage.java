package com.amazon.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;



public class BrokenLinkInPage extends BasePage3 {

	public BrokenLinkInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   
	//1.Use <a> tag to fetch all the links present on a web page

	@FindBy(tagName="a")
	public  List<WebElement> links;
	
	public void checkBrokenLinks() {
	for(WebElement link :links) {
		String url=link.getAttribute("href");
		verifyLink(url);
	}
	}
	public void loginToBrowserStackApp(String url,WebDriver driver) {
	  	  goToURL(url);
	  	  driver.manage().window().maximize();
	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  	
	    }
	
	
}
