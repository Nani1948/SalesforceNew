package com.salesforce.qa.home.page;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.salesforce.qa.basepage.BasePage3;

import io.reactivex.rxjava3.functions.Action;

public class UserProfilePage extends BasePage3 {
	Actions action=new Actions(driver);
	public UserProfilePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[contains(@class, 'contactInfoLaunch editLink')]")
	WebElement editButton;
	@FindBy(css="#publisherAttachTextPost > span:nth-child(2)")
	WebElement postLink;
	
	//@FindBy(className="chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders")WebElement postText;
	@FindBy(css="#cke_publisherRichTextEditor_arialbl")
	WebElement postText;	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	WebElement shareButton;
	@FindBy(xpath="//*[@id='cke_43_contents']/iframe")
	WebElement frame1;

	//File
	@FindBy(xpath="//*[@id='publisherAttachContentPost']/span[1]")
	WebElement File;
	@FindBy(xpath="//*[@id='chatterUploadFileAction']")WebElement 
	uploadAFileFromComputer;
	@FindBy(id="chatterFile")WebElement choose;

	//AddPhoto
	@FindBy(xpath="//span[@class='profileImage chatter-avatarFull chatter-avatar']")WebElement  profileImage;
	@FindBy(xpath="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/a[1]")WebElement addPhoto;
	@FindBy(xpath="//body[1]/span[1]/form[1]/input[2]")WebElement choose1;
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadBtn' and @value='Save']")WebElement saveButton;
	@FindBy(id="uploadPhotoContentId")WebElement frame2;
	@FindBy(xpath="//*[@id='j_id0:outer']/div[1]/div/div/div/div[6]")WebElement cropPhoto;
	@FindBy(xpath="//*[@id='j_id0:j_id7:save']") WebElement saveButton1;
	

	@FindBy(xpath = "//*[@id=\'userNavLabel\']")public WebElement userProfilePageNameDisplay;

	public void  clickOnEditButton(String text) {
	    // performMouseHoverWithWait(driver, editButton);
		if(waitForElement(driver,  editButton)){
			editButton.click();
			 System.out.println("user is clicked on Edit Button");
		}
	  
	}  
    public void clickOnPostLink(String text) {
    	moveToElementAction(driver,  postLink, text);
    }
    public void enterPostText(WebDriver driver,String text1) {    	
    	// Switch to the iframe if necessary
    	switchToPostTextAreaFrame();

    	// Locate the textarea element inside the iframe
    	postText.click();
    	postText.sendKeys(text1);
    }
    public void clickOnShareButton(String text) {
    	moveToElementAction(driver,  shareButton, text);
    }
   public void switchToPostTextAreaFrame() {
	   switchToframeByWebElement(frame1);
	   System.out.println("SwitchToTextArea");
   }
   public void switchToMainWindow() {
	   switchToDefaultWindow();
	   System.out.println("SwitchToParentWindow");
   }
   public void clickOnFile() {
	   File.click();	   
   }
   public void clickOnUploadLink() {
	   uploadAFileFromComputer.click();
   }
   public boolean isMyProfilePageDisplayed() {
		return userProfilePageNameDisplay.isDisplayed();
	}
 
   
	
   public void uploadAFile(String text) {
    waitForElementToBeVisible(driver, choose , text);
    // Provide the file path for upload
   	String filePath = "C:\\Users\\knand\\Desktop\\360_F_266724172_Iy8gdKgMa7XmrhYYxLCxyhx6J7070Pr8.jpg";
   	choose.sendKeys(filePath);
   	clickOnShareButton(text);
   }
   public void addPhotoToProfile(String text) {
	  action.moveToElement(profileImage).click().build().perform();
	  action.moveToElement(addPhoto).click().build().perform();	  
	  driver.switchTo().frame(frame2);
	  String filePath = "C:\\Users\\knand\\Desktop\\360_F_266724172_Iy8gdKgMa7XmrhYYxLCxyhx6J7070Pr8.jpg";
	  choose1.sendKeys(filePath);
	  waitForElementToBeVisible(driver,saveButton, text);
	  action.moveToElement(saveButton).click().build().perform();	
	  //saveButton1
	  action.moveToElement(saveButton1).click().build().perform();	
   }
   
   
}
