package com.salesforce.qa.utilty;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollUtils {
	 private WebDriver driver;
	    private WebDriverWait wait;

	    public ScrollUtils(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    }

	  

		public void scrollDown(int pixels) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0," + pixels + ")");
	    }

	    public void scrollUp(int pixels) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,-" + pixels + ")");
	    }

	    public void scrollToBottom() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }

	    public void scrollToTop() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 0)");
	    }

	    public void waitForScrollToComplete(int pixels) {
	        wait.until(ExpectedConditions.jsReturnsValue("return window.scrollY >= " + pixels));
	    }
}
