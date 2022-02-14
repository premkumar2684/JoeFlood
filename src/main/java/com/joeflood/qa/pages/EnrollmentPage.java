package com.joeflood.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.util.TestUtil;


public class EnrollmentPage extends TestBase {
	
	 //Page factory - OR:
    @FindBy(xpath="//*[contains(text(),'Sign Up Now')]")
	WebElement SignUpNow;
	@FindBy(id="agencyLegalName")
	WebElement agencyLegalName;
	@FindBy(id="agencyDba")
	WebElement agencyDba;
	@FindBy(id="streetAddres1")
	WebElement streetAddres1;
	@FindBy(id="phone")
    WebElement phone;
	@FindBy(id="city")
    WebElement city;
	@FindBy(xpath="//input[@name='StateOne']")
    WebElement state;
	@FindBy(id="zipCode")
    WebElement zipCode;
	@FindBy(id="firstName")
    WebElement firstName;
	@FindBy(id="createPassword")
    WebElement password;
	@FindBy(id="confirmPassword")
    WebElement confirmPassword;
	@FindBy(id="principalTitle")
    WebElement principalTitle;
	@FindBy(id="agencyStreetAddres1")
    WebElement agencyStreetAddres1;
	@FindBy(id="agencyPhone")
    WebElement agencyPhone;
	@FindBy(id="email")
    WebElement email;
	@FindBy(id="agencyCity")
    WebElement agencyCity;
	@FindBy(xpath="//input[@name='agencyState']")
    WebElement selectState;
	@FindBy(id="agencyZipCode")
    WebElement agencyZipCode;
	@FindBy(xpath="//*[contains(text(),'Sign up')]")
	WebElement signupBtn;
	@FindBy(xpath="//input[@name='otp']")
	WebElement signupOtp;
	@FindBy(xpath="//*[contains(text(),'Verify')]")
	WebElement signupOtpVerify;
	//@FindBy(xpath="//input[@name='sameAsMailingAdd' and @value='YES']")
	@FindBy(xpath="//*[contains(text(),'Yes')]")
	WebElement sameAsMailingAddBtn;
	//@FindBy(xpath="//*[contains(text(),'Next')]")
	
	@FindBy(xpath="//span[@class='MuiButton-label']")
	WebElement nextBtn;
	@FindBy(id="streetAddres1")
    WebElement StreetAddres1;
	@FindBy(id="phone")
    WebElement Phone;
	@FindBy(id="city")
    WebElement City;
	@FindBy(xpath="//input[@name='selectState']")
    WebElement State;
	@FindBy(id="zipCode")
    WebElement ZipCode;
	//W9 section
	@FindBy(xpath="//fieldset[@name='declarationFile']")
	WebElement declarationFile;
	@FindBy(xpath="//fieldset[@name='w9files']")
	WebElement W9File;
	@FindBy(xpath="//div[4]//fieldset[1]//div[1]//div[1]//p[1]")
	WebElement LicenceFile;
	//@FindBy(xpath="//input[@name='isCurrentW9*']")

	@FindBy(xpath="//*[contains(text(),'is Current W9')]")
	WebElement isCurrentW9;
	@FindBy(xpath="//img[@src='/static/media/progressView.cc0f27cb.svg']")
	WebElement agencyVerificationImg;
	
	

	@FindBy(xpath="//*[name()='path' and contains(@d,'M10.09 15.')]")
	WebElement ExitBtnfromEnrollment;
	
	
	LoginPage loginPage;
    HomePage homePage;
    EnrollmentPage dashboardPage;
	
	
	public EnrollmentPage() {
        PageFactory.initElements(driver, this);
    }
	
	 public String verifyEnrollmentPageTitleTest() {	
		 	SignUpNow.click();
	        return driver.getTitle();
	    }
	
	 public void agencyEnrollmentMethod(String AgencyLegalName, String AgencyDba, String StreetAddres1, String AgencyPhoneNo,String AgencyCity,String AgencyState,String AgencyZipcode,String PrincipalFirstName,String Principalpassword,String PrincipalConfirmPassword,String PrincipalTitle,String AgencyStreetAddres1,String PrincipalPhone,String principalEmail,String PrincipalCity,String PrincipalState,String PrincipalZipcode,String AccountingFirstName,String AccountingAddress,String AccountingPhone,String AccountingEmail,String AccountingCity,String AccountingState,String AccountingZipcode) throws AWTException {	
		 //
		 	SignUpNow.click();
		 	agencyLegalName.sendKeys(AgencyLegalName);
		 	agencyDba.sendKeys("Joeflood");
		 	streetAddres1.sendKeys("1 Mansfield Pl");
		 	phone.sendKeys("9898981215");
		 	city.sendKeys("Florida city"); 	 	
		 	state.sendKeys("Florida",Keys.ARROW_DOWN, Keys.ENTER);
		  	zipCode.sendKeys("32003");
		 	firstName.sendKeys("Smith	");
		 	password.sendKeys("Jfi@123");
		 	confirmPassword.sendKeys("Jfi@123");
		 	principalTitle.sendKeys("Mr");
		 	agencyStreetAddres1.sendKeys("1 Mansfield Pl");		 		
		 	agencyPhone.sendKeys("9898981215");
		 	email.sendKeys("test@gmmail.com");
		 	agencyCity.sendKeys("Florida City");
		 	selectState.sendKeys("Florida",Keys.ARROW_DOWN, Keys.ENTER);
		 	agencyZipCode.sendKeys("32322");
		 	signupBtn.click();
		  	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(signupOtp));
		 	signupOtp.sendKeys("123456");
		 	signupOtpVerify.click();
		 	//Mailing section
		 	wait.until(ExpectedConditions.visibilityOf(sameAsMailingAddBtn));
		 	sameAsMailingAddBtn.click();
		 	nextBtn.click();
		 	//Accounting Section
		 	wait.until(ExpectedConditions.visibilityOf(firstName));
		 	firstName.sendKeys("Smith");
		 	streetAddres1.sendKeys("1 Mansfield Pl");
		 	Phone.sendKeys("9898981215");
		 	email.sendKeys("test@ttf.com");
		 	City.sendKeys("Florida City");
		 	State.sendKeys("Florida",Keys.ARROW_DOWN, Keys.ENTER);
		 	ZipCode.sendKeys("32322");
		 	nextBtn.click();
		 	
		 	//declarationFile.sendKeys("D:\\JoeFlood\\Upload\\Allowed\\sample.pdf");
		 	Robot rb = new Robot();
		 	
		 	wait.until(ExpectedConditions.visibilityOf(W9File));
		    W9File.click();
		    
		   // StringSelection str1= new StringSelection("D:\\JoeFlood\\Upload\\Allowed\\sample.pdf");
		    //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);
		    StringSelection str1 = new StringSelection("D:\\JoeFlood\\Upload\\Allowed\\sample.pdf");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);
		    rb.delay(250);
		    // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_V);
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		   
		 
		    // for pressing and releasing Enter
		   // sendKeys(Keys.ENTER);
			
		  //Pauses test execution for specified time in milliseconds
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		    
		
		  //W9 deatils section
		 	wait.until(ExpectedConditions.visibilityOf(declarationFile));
		 	declarationFile.click();
		 	 
		    // copying File path to Clipboard
		    StringSelection str = new StringSelection("D:\\JoeFlood\\Upload\\Allowed\\sample1.pdf");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		    rb.delay(250);
		    // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		     rb.keyRelease(KeyEvent.VK_V); 
		     rb.keyRelease(KeyEvent.VK_CONTROL);
		    
		 
		    // for pressing and releasing Enter
		   // sendKeys(Keys.ENTER);
			
		  //Pauses test execution for specified time in milliseconds
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		    
		    
		      wait.until(ExpectedConditions.visibilityOf(LicenceFile));
		    LicenceFile.click();
		    StringSelection str2 = new StringSelection("D:\\JoeFlood\\Upload\\Allowed\\sample2.pdf");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str2, null);
		    // press Contol+V for pasting
		    rb.delay(250);
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V); 
		 
		    // for pressing and releasing Enter
		   // sendKeys(Keys.ENTER);
			
		  //Pauses test execution for specified time in milliseconds
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,350)", "");
		    wait.until(ExpectedConditions.visibilityOf(isCurrentW9));
		    isCurrentW9.click();
		    nextBtn.click();
		    wait.until(ExpectedConditions.visibilityOf(agencyVerificationImg));
		    // Javascript executor to check image
		    Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", agencyVerificationImg);
		    
		    System.out.println(p);
		    ExitBtnfromEnrollment.click();
		 	
	        
	    }

	 	

	   
}
