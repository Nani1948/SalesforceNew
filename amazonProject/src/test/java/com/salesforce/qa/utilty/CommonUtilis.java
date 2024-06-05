package com.salesforce.qa.utilty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilis {
    public static String getScreenshot(WebDriver driver) {
	String filePath =Constant4.SCREENSHOTS_FOLDER_PATH;
	TakesScreenshot screen = (TakesScreenshot) driver;
	File src = screen.getScreenshotAs(OutputType.FILE);
	File dst = new File(filePath);
	src.renameTo(dst);
	return filePath;
}

    public static String getDateAndTimeStamp() {
   	return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
   }
    public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	}
}
