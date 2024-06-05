package com.amazon.qa.normalPackage;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.salesforce.qa.utilty.PropertiesUtliyClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestAnohter {
public WebDriver driver;
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("chrome")String browName) {
		PropertiesUtliyClass prop=new PropertiesUtliyClass();
		Properties applicationPro=prop.loadFile("data.properties");
		String url1=applicationPro.getProperty("url");
		launchBrowser(browName);
		System.out.println(browName+" is launched");
		
		goToURL(url1);
		System.out.println(url1+"is enterd in the searchBar");
	}
	
		public void launchBrowser(String browserName) {
			 switch (browserName) {
		        case "chrome":
		            WebDriverManager.chromedriver().setup();
		            driver = new ChromeDriver();
		            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            break;

		        case "firefox":
		            WebDriverManager.firefoxdriver().setup();
		            driver = new FirefoxDriver();
		            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            break;

		        case "Edge":
		            WebDriverManager.edgedriver().setup();
		            driver = new EdgeDriver();
		            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            break;
		    }
	}
		
		
		public void goToURL(String url) {
		    driver.get(url);
		    System.out.println(url + " is entered");
		}

		
	
		/*----------------close application----------------------------------
		    public void closeApplication() {
		    	driver.close();
		    	System.out.println("Browser is closed");
		    }
		   */
		    
		    
	@AfterMethod
	 public  void quitApplication() {
    //	driver.quit();
    	System.out.println("All browser window is closed");
    }
	}