package com.salesforce.qa.basepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.salesforce.qa.utilty.Constant4;
import com.salesforce.qa.utilty.PropertiesUtliyClass;
import com.salesforce.qa.utilty.WaitConstant;


public class BasePage3 {
	protected WebDriver driver;
	WebDriverWait wait =null;
	//public static Logger logger = (Logger) LogManager.getLogger();
	public BasePage3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//   ----------------------------Page------------
	public String getPageTitle() {
		String titleOfPage=driver.getTitle();
		System.out.println("Title of Page:"+titleOfPage );			
	
		return titleOfPage;
		
	}
	public void navigateToURL(String url) {
	    driver.get(url);
	    System.out.println(url+"is a launched on the browser");
	}
	public  String getPageSource() {
		String pageofSource=driver.getPageSource();
		System.out.println("Source of page:"+pageofSource);
		
		return pageofSource;
	}
	public  void getCurrentURL() {
		String currentURL=driver.getCurrentUrl();
		System.out.println("Current URL:"+currentURL);
		
	}
	//----------------------------Frame----------------------------
	 
	 public void switchToframe(String text) {
		  driver.switchTo().frame(text);
	 }
	 public void switchToframe(int id) {
		  driver.switchTo().frame(id);
	 }
	 public void switchToframeByWebElement(WebElement element) {
		  driver.switchTo().frame(element);
	 }
	 public void switchToFrameByText(String text) {
		    List<WebElement> frames = driver.findElements(By.tagName("frame"));
		    boolean foundFrame = false;

		    for (WebElement frame : frames) {
		        if (frame.getAttribute("name").equals(text) || frame.getAttribute("id").equals(text)) {
		            driver.switchTo().frame(frame);
		            foundFrame = true;
		            break;
		        }
		    }

		    if (!foundFrame) {
		    	System.out.println("Frame with text '" + text + "' not found");
		    }
		}
	//-------------------------------windowhandle---------------------------
	 public String getCurrentWindowHandle(WebDriver driver) {
		    return driver.getWindowHandle();
		}
	 public Set<String> getAllWindowHandles(WebDriver driver) {
		    return driver.getWindowHandles();
		}
	 public void switchToWindow(WebDriver driver, String windowHandle) {
		    driver.switchTo().window(windowHandle);
		}
	 public void closeCurrentWindow(WebDriver driver) {
		    driver.close();
		}
	 public void switchToDefaultWindow() {
		  driver.switchTo().defaultContent();
	 }
	 //latest window
	 public void switchToNewWindow(WebDriver driver, Set<String> oldWindowHandles) {
		    Set<String> newWindowHandles = driver.getWindowHandles();
		    newWindowHandles.removeAll(oldWindowHandles);
		    String newWindowHandle = newWindowHandles.iterator().next();
		    driver.switchTo().window(newWindowHandle);
		}
	 
	 public void switchToNewWindowAndPerformAction(WebElement element) {
		    String mainWindowHandle = driver.getWindowHandle();
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String windowHandle : windowHandles) {
		        if (!windowHandle.equals(mainWindowHandle)) {
		            driver.switchTo().window(windowHandle);
		            // Perform action on element in new window
		            robotClass();
		            waitForElement(driver, element);
		            
		          // Example action
		            break;
		        }
		    }
		}
	//------------------------------Navigation---------------------
	public void refreshPage() {
		driver.navigate().refresh();
		
	}
	public void navigatedToPreviousPage() {
		driver.navigate().back();
		
	}
	public void navigatedToNextPage() {
		driver.navigate().forward();
		
	}
    public static void changeFocusToWindowByTitle(WebDriver driver, String windowTitle) {
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            driver.switchTo().window(windowHandle);
            if (windowTitle.equalsIgnoreCase(driver.getTitle())) {
               System.out.println("Focus has been changed to the window: " + driver.getTitle());
                break;
            }
        }
    }

 public static void closeWindow(WebDriver driver, String windowTitle) {
        Set<String> handles = driver.getWindowHandles(); ;
        for (String handle: handles ) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
            	 System.out.println("Close window: " + windowTitle);
                driver.close();
                break;
            }
        }
    }
	  //-------------------------------Action -------------------------------
	  public  void moveToElementAction(WebDriver driver,WebElement element,String objectName) {
	  Actions action=new Actions(driver);
	  action.moveToElement(element).click().build().perform();
	  //log.info("cursor moved to WebElement "+objectName);
	  System.out.println("user is a clicked on"+objectName);
	  
	  }
	  public  void moveToElementAction(WebDriver driver,WebElement element) {
		  Actions action=new Actions(driver);
		  action.moveToElement(element).click().build().perform();
		  //log.info("cursor moved to WebElement "+objectName);
	
		  
		  }
	  public void enterTextOFTextArea(WebDriver driver, WebElement element,String text) {
		     element.click();
		 	 Actions action=new Actions(driver);
		 	 action.sendKeys(text).build().perform();
	  }
	  public void clickElement(WebDriver driver, WebElement element, String objectName) {
		    Actions action = new Actions(driver);
		    action.moveToElement(element).click().build().perform();
		    System.out.println("user is a clicked on"+objectName);
		}
	  public  void doubleClickElement(WebDriver driver, WebElement element,String objectName) {
	      Actions actions = new Actions(driver);
	      actions.doubleClick(element).build().perform();
	    
	     System.out.println("Double click performed on "+objectName);
	  }
	  public  void contextClickElement(WebDriver driver, WebElement element,String objectName) {
	      Actions actions = new Actions(driver);
	      actions.contextClick(element).build().perform();
	      System.out.println("right click performed on "+objectName);
	  }
	  public  void dragAndDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
	      Actions actions = new Actions(driver);
	      actions.dragAndDrop(sourceElement, targetElement).perform();
	      System.out.println("Drag a file from" +sourceElement+"to" + targetElement);
	  }
	//---------------------------------Select-----------------------------------
	public void addOptionToDropdown(WebElement dropdownElement, String optionText) {
	    Select select = new Select(dropdownElement);
	    select.selectByVisibleText(optionText);
	}

	public void removeOptionFromDropdown(WebElement dropdownElement, String optionText) {
		
		
	    Select select = new Select(dropdownElement);
	    select.deselectByVisibleText(optionText);
	}

	public boolean isOptionSelectedInDropdown(WebElement dropdownElement, String optionText) {
	    Select select = new Select(dropdownElement);
	    List<WebElement> selectedOptions = select.getAllSelectedOptions();
	    for (WebElement option : selectedOptions) {
	        if (option.getText().equals(optionText)) {
	            return true;
	        }
	    }
	    return false;
	}
	 public void  selectOptionFromDropdownByText(WebElement element,String text) {
	       Select dropdown = new Select( element);
	       for (WebElement option : dropdown.getOptions()) {
	           String optionText = option.getText();
	           System.out.println("Dropdown Option: " + optionText);
	       }
	       dropdown.selectByVisibleText(text);
	   }
	public boolean selectOptionByText(WebElement dropdownElement, String text) {
		
	    Select select = new Select(dropdownElement);

	    List<WebElement> options = select.getOptions();
	    for (WebElement option : options) {
	        if (option.getText().contains(text)) {
	            select.deselectByVisibleText(option.getText());	         
	            System.out.println("Selected the option by visible text:" + text);
	            select.selectByVisibleText(option.getText());         
	            System.out.println("Selected the option by visible text:" + text);
	            return true;
	        }
	    }
	  
	    System.out.println("Selected the option by visible text: " + text);
	    return false;
	}

	public boolean selectOptionByPartialText(WebElement dropdownElement, String partialText) {
	    Select select = new Select(dropdownElement);

	    List<WebElement> options = select.getOptions();
	    for (WebElement option : options) {
	        if (option.getText().contains(partialText)) {

	            select.selectByVisibleText(option.getText());
	           
	            System.out.println("Selected the option by visible text:" + partialText);
	            return true;
	        }
	    }
	    System.out.println("Selected the option by visible text: " + partialText);
	    
	    return false;

	}

	public void selectByIndexOfElement(String xpath, int value) {
	    Select select = new Select(driver.findElement(By.xpath(xpath)));
	    select.selectByIndex(value);
	    System.out.println("select the options by the index");
	}
    public void selectByVisibleTextFromDropdown(WebElement element, String data) {
    	
    	Select select= new Select(element);
    	select.selectByVisibleText(data);
    }
	public void selectByValueOfElement(WebElement element, String value) {
	    Select select = new Select(element);
	    select.selectByValue(value);
	    System.out.println("Selected the option by value: " + value);
	}

	public void selectByVisibleTextOfElement(WebElement element, String value) {
		element.click();
	    Select dropdown= new Select(element);
	    dropdown.selectByVisibleText(value);
	    // Get the selected option and verify its text
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedOptionText = selectedOption.getText();
        System.out.println("Selected option: " + selectedOptionText);

        // Initialize a boolean flag for verification
        boolean verificationPassed = selectedOptionText.equals(value);

        // Output the verification result
        if (verificationPassed) {
            System.out.println("Verification passed: Selected option matches expected text.");
        } else {
            System.out.println("Verification failed: Selected option does not match expected text.");
        }
	    
	    
	    
	    
	    
	    
	}

	// ----------------------------Alert-----------------------------------------
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		 System.out.println("switched To Alert");
		return alert;
	}
	 
	 // Method to switch to an alert and accept it
    public void switchToAlertAndAccept() {
        Alert alert = driver.switchTo().alert();
        System.out.println("Switched to Alert");
        alert.accept();
        System.out.println("Alert is accepted");
    }

    // Method to switch to an alert and dismiss it
    public void switchToAlertAndDismiss() {
        Alert alert = driver.switchTo().alert();
        System.out.println("Switched to Alert");
        alert.dismiss();
        System.out.println("Alert is dismissed");
    }

    // Method to switch to an alert, get its text, and accept it
    public String switchToAlertAndGetTextAndAccept() {
        Alert alert = driver.switchTo().alert();
        System.out.println("Switched to Alert");
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
        System.out.println("Alert is accepted");
        return alertText;
    }

    // Method to switch to an alert, enter text in its prompt, and accept it
    public void switchToAlertEnterTextAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        System.out.println("Switched to Alert");
        alert.sendKeys(text);
        System.out.println("Entered text in the alert prompt: " + text);
        alert.accept();
        System.out.println("Alert is accepted");
    }
    // Method to switch to an alert and get its text
    public String switchToAlertAndGetText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // Method to check if an alert is present
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to wait for an alert to be present
    public boolean waitForAlert(Duration timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

  

	 //----------------------------RadioButton---------------------------------
	 public void selectRadioButton(WebElement element,String text) {
	     
	       if (!element.isSelected()) {
	           element.click();
	           System.out.println("Selected the radio button with element " + text);   
	       }
	   }

	   public void deselectRadioButton(WebElement element,String text) {
	      
	       if (element.isSelected()) {
	       	element.click();
	          System.out.println("Deselected the radio button with element: " +  text);
	       }
	   }
	 //-------------------------List WebElement-------------
	 public WebElement findElementByText(List<WebElement> elements, String targetText) {
		    for (WebElement element : elements) {
		        if (element.getText().equals(targetText)) {
		            return element;
		        }
		    }
		    return null; // Return null if the element is not found
		}

		//--------------------------Text-------------------------------------------------
	 public void enterTextToSearchBox(WebElement element,String data,String objectName) {
			if(element.isDisplayed()) {
				 //if (data!= null && !data.isEmpty()) {
				//clearElement(element,objectName);
				element.sendKeys(data,Keys.ENTER);
			
				 System.out.println(objectName+ "is entered ");
			 
		    //}
			}
			else {
				
				 System.out.println(objectName+ " element is not displayed");
			}
			
			
		}
		public void enterText(WebElement element,String data,String objectName) {
			if(element.isDisplayed()) {
				 //if (data!= null && !data.isEmpty()) {
				clearElement(element,objectName);
				element.sendKeys(data);
			
				 System.out.println(objectName+ "is entered ");
			 
		    //}
			}
			else {
				
				 System.out.println(objectName+ " element is not displayed");
			}
			
			
		}
		public void clearElement(WebElement element,String objectName) {
			if(element.isDisplayed()) {
				element.clear();
				 System.out.println("Text is cleared in"+objectName);
				
			}
			else {
				 System.out.println("Text is not cleared in"+objectName);
				;
			}
		}
		 public void clickElement(WebElement element) {
		        element.click();
		    }
		  public void moveToElementAction(WebElement element) {
		        Actions action = new Actions(driver);
		        action.moveToElement(element).click().build().perform();
		    }
	   public  String getText(WebElement element) {
		   try {
		        if (element.isDisplayed()) {
		            String text = element.getText();
		            System.out.println("Text is printed: " + text);
		            return text;
		        } else {
		        	 System.out.println("Element is not displayed");
		        }
		    } catch (NoSuchElementException e) {
		    	 System.out.println("Element not found");
		    } catch (Exception e) {
		    	 System.out.println("An error occurred while retrieving text");
		    }
		    return null;
		}
	   public  boolean isTextPresent(WebElement element ,String expectedText) {
		   String actualText=element.getText();
		   try {
			   if(element.isDisplayed()) {
				   
				   System.out.println("Actual text: " + actualText);
		           System.out.println("Expected text: " + expectedText);
		        boolean isPresent=actualText.contains(expectedText);
				if(isPresent) {
					 System.out.println("Text is visble");
				}
				else {
					 System.out.println("Text is not visible");
				}
			   
				return isPresent;
			    } 
		   
		       else {
		    	   System.out.println("Element is not displayed");
			     }
		   
	         } catch (NoSuchElementException e) {
	        	 System.out.println("Element not found");
	       } catch (Exception e) {
	    	   System.out.println("Actual text: " + actualText);
	    	   System.out.println("An error occurred while checking text presence");
	   }
	   
	   return false;
	}
			    
	  public  boolean waitForTextToBePresent(WebElement element, String expectedText) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT);
		        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
		        
		        System.out.println("Expected text is present within the element");
		        return true;
		    } catch (TimeoutException e) {
		        System.out.println("Expected text is not present within the element within the timeout period");
		    } catch (NoSuchElementException e) {
		        System.out.println("Element not found");
		    } catch (Exception e) {
		        System.out.println("An error occurred while waiting for text presence");
		    }
		    
		    return false;
		}	  
		public void clickOnLink(String  xpath) {
			WebElement  element=driver.findElement(By.xpath(xpath));
			 element.click();
			 System.out.println("Click on WebElement link");
		}
		public void isDisplayed(WebElement element) {
			  try {
				   if(element.isDisplayed()) {
					   System.out.println("Element is displayed");  
				   }  
			       else {
			    	   System.out.println("Element is not displayed");
				     }
			   
		         } catch (NoSuchElementException e) {
		       System.out.println("Element not found");
		       } catch (Exception e) {
		       System.out.println("An error occurred while checking text presence");
		   }
		   
		
		}
		public  void scrollDown(String pixels) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0," + pixels + ")");
	    }
		public  void robotClass() {
			Robot robot=null;
			try {
				robot = new Robot();
			    // Simulate keyboard events using Robot
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        robot.keyPress(KeyEvent.VK_T);
		        robot.keyRelease(KeyEvent.VK_CONTROL);
		        robot.keyRelease(KeyEvent.VK_T);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void verifyLink(String url) {
			try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			if (httpURLConnection.getResponseCode() == 200) {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
			}
			}
			 
   public static boolean waitForElement(WebDriver driver, WebElement element) {
	boolean isElementClickable = false;
	WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT);
	try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isElementClickable = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return isElementClickable;
}

     public static boolean waitForElement(WebDriver driver, WebElement element, Duration time) {
	boolean isElementClickable = false;
	WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT);
	try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isElementClickable = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return isElementClickable;
}

   public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
	boolean isElementInvisible = false;
	WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
	try {
		wait.until(ExpectedConditions.invisibilityOf(element));
		isElementInvisible = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return isElementInvisible;
}
   public boolean isChecked(WebElement checkedbox, boolean  notSelectCheckBox) {
		 
	   boolean isCheckedBox=checkedbox.isSelected();
	   
	     if(isCheckedBox!=notSelectCheckBox) {
	    	 checkedbox.click(); 
	     
		   if (notSelectCheckBox) {
	           System.out.println("checkedbox is selected");
	        } else {
	        	System.out.println("Checkedbox is not selected");
	        }
	     }
		   else {
			   System.out.println("Checkbox is already in the checked state");
		   }
	        return isCheckedBox;
	   
   }
   public static void mouseHover(WebDriver driver, WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
}

    public static String getScreenshot(WebDriver driver) {
	String filePath =Constant4.SCREENSHOTS_FOLDER_PATH;
	TakesScreenshot screen = (TakesScreenshot) driver;
	File src = screen.getScreenshotAs(OutputType.FILE);
	File dst = new File(filePath);
	src.renameTo(dst);
	return filePath;
}
    public void performMouseHoverWithWait(WebDriver driver, WebElement element) {
        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Wait for the element to be visible before performing the mouse hover action
        WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.visibilityOf(element));

        // Perform mouse hover action on the element
        actions.moveToElement(element).click().build().perform();
    
        System.out.println("Waiting for an webelement and Perform click action on the webelement");
    }

    public void waitForPageLoad() {
 	   driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
    }
    public void implicitWaitMethod() {
 	   driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
    }
    public   void waitForElementToBeVisible(WebDriver driver, WebElement element, String objectName) {
        WebDriverWait wait = new WebDriverWait(driver,  WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println("waiting for an webelement"+objectName+" for visiblity");
    }

    public   void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,  WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.visibilityOf(element));
     
    }public  void waitForElementToClickable(WebDriver driver, By locator,String objectName) {
        WebDriverWait wait = new WebDriverWait(driver,  WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        System.out.println("waiting for an webelement"+objectName+" to be clickable");
    }
    
    public  void waitForTextToBePresent(WebDriver driver, WebElement element,String message) {
        WebDriverWait wait = new WebDriverWait(driver,  WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.textToBePresentInElement(element, message));
        System.out.println("waiting for an text to be present");
    }
    public  void   waitUntilAlertIsPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("waiting for an alert to be present");
    }
    
    
    public void waitForElementToBeInvisible(WebDriver driver, By locator,int timeoutInSeconds,String objectName) {
        WebDriverWait wait = new WebDriverWait(driver,  WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        System.out.println("waiting for an webelement"+objectName+"for its invisibility");
    }
    public static void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int timeoutInSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    
   
    public  WebElement waitForElementVisibility(WebDriver driver, By locator, int timeoutSeconds,String objectName) {
 	    Wait<WebDriver> wait = new FluentWait<>(driver)
 	            .withTimeout(Duration.ofSeconds(timeoutSeconds))
 	            .pollingEvery(Duration.ofSeconds(1))
 	            .ignoring(NoSuchElementException.class);
 	   System.out.println("waiting for an webelement"+objectName+"for its visibility");
 	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 	    
 	}
 public static String getDateAndTimeStamp() {
	return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
}

    public static void sendKeyEvents(WebDriver driver, CharSequence keyEvent) {
	Actions action = new Actions(driver);
	action.sendKeys(keyEvent).sendKeys(keyEvent).build().perform();
}
	public void goToURL(String url) {
	    driver.get(url);
	    System.out.println(url + " is entered");
	}
	public boolean selectOptionFromDropdownList(WebDriver driver,WebElement element,WebElement elementOption,String sOptions) {
		boolean isOptionClicked=false;
		if(!element.isDisplayed()) {
			element.click();
			
		}
		if(elementOption.isDisplayed()) {
			elementOption.click();
			isOptionClicked=true;
			
		}
		else {
			System.out.println("Option " + sOptions + " not found");
		}
		return isOptionClicked;
		
	}



	public void clickOnDropdown(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("The usermenu element is not found");
		}
	}
	public void waitForTitleOfPage() {
		WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT);
		wait.until(ExpectedConditions.titleIs(getPageTitle()));
	  }
	public String  getIntValue(Properties accounttestDataPro1, String key) throws IOException {
	
		// Retrieve the value associated with the key from the provided Properties object
	    String valueAsString = accounttestDataPro1.getProperty(key);

	    // Check if the value is not null
	    if (valueAsString != null) {
	        return valueAsString;
	    } else {
	        // If the key does not exist in the Properties object, throw an exception
	        throw new IllegalArgumentException("Key not found: " + key);
	    }
	}
}