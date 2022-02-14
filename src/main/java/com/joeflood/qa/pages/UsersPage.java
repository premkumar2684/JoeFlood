package com.joeflood.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.util.TestUtil;


public class UsersPage extends TestBase {
	 //Page factory - OR:
	@FindBy(xpath="//span[normalize-space()='User']")
    WebElement UserBtn;
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//span[@class='MuiButton-label']")
	WebElement CreateUser;
	@FindBy(name="firstName")
	WebElement JfiFirstName;
	@FindBy(name="lastName")
	WebElement JfiLastName;
	
	@FindBy(name="password")
	WebElement JfiPassword;
	@FindBy(name="role")
	WebElement JfiRole;
	@FindBy(name="status")
	WebElement JfiStatus;
	@FindBy(name="addressLine1")
	WebElement JfiAddress1;
	@FindBy(name="phone")
	WebElement JfiPhone;
	@FindBy(name="email")
	WebElement JfiEmail;
	@FindBy(name="city")
	WebElement JfiCity;
	@FindBy(name="state")
	WebElement JfiState;
	@FindBy(name="zipCode")
	WebElement JfiZipcode;
	@FindBy(xpath="//*[contains(text(),'save')]")
	WebElement Save;
	
	@FindBy(id="simple-tab-1")
	WebElement AgencyTab;
	@FindBy(name="agencylegalname")
	WebElement agencyLegalName;
	@FindBy(name="agencyDba")
	WebElement agencyDba;
	@FindBy(id="streetAddres1")
	WebElement streetAddres1;
	@FindBy(id="phone")
    WebElement phone;
	@FindBy(id="city")
    WebElement city;
	@FindBy(xpath="//input[@name='state']")
    WebElement state;
	@FindBy(id="zipCode")
    WebElement zipCode;
	@FindBy(id="firstName")
    WebElement firstName;
	@FindBy(id="password")
    WebElement password;
	@FindBy(id="confirmPassword")
    WebElement confirmPassword;
	@FindBy(name="principal[0].principalTitle")
    WebElement principal1Title;
	@FindBy(name="principal[0].streetAddres1")
    WebElement agencyStreetAddres1;
	@FindBy(name="principal[0].phone")
    WebElement agencyPhone;
	@FindBy(name="principal[0].email")
    WebElement email;
	@FindBy(name="principal[0].city")
    WebElement agencyCity;
	@FindBy(xpath="//input[@name='principal[0].selectState']")
    WebElement selectState;
	@FindBy(name="principal[0].zipCode")
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
	@FindBy(xpath="//button[@type='submit']")
	WebElement nextBtn;
	//span[normalize-space()='Next']
	@FindBy(id="streetAddres1")
    WebElement StreetAddres1;
	@FindBy(id="phone")
    WebElement Phone;
	@FindBy(id="email")
    WebElement AccountingEmail;
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
	
	@FindBy(id="simple-tab-2")
	WebElement AgentTab;
	@FindBy(name="firstName")
	WebElement agentFirstName;
	@FindBy(name="password")
	WebElement agentPassword;
	@FindBy(name="addressLine1")
	WebElement agentAddress1;
	@FindBy(xpath="//input[@name='agency']")
	WebElement selectAgency;	
	@FindBy(name="phone")
	WebElement agentPhone;
	@FindBy(name="email")
	WebElement agentEmail;
	@FindBy(name="city")
	WebElement agentCity;
	@FindBy(name="state")
	WebElement agentState;
	@FindBy(name="zipCode")
	WebElement agentZipcode;
	@FindBy(className="//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']")
	WebElement userDels;
	@FindBy(xpath="//*[contains(text(),'delete')]")
	WebElement userDelete;
	@FindBy(xpath="//*[contains(text(),'Yes')]")
	WebElement confirmDelete;
	@FindBy(xpath="//input[@name='status']")
	WebElement agencyStatus;
	@FindBy(xpath="//div[normalize-space()='5']")
	WebElement w9detailsTab;
	
	@FindBy(className="MuiSnackbarContent-message")
	WebElement ConfirmMessage;
	
	
	
	
	LoginPage loginPage;
    HomePage homePage;
    UsersPage dashboardPage;
	
	
	public UsersPage() {
        PageFactory.initElements(driver, this);
    }
	
	 public String verifyUsersPageTitleMethod() {	
		 	//UserBtn.click();
	        return driver.getTitle();
	    }
	
	 public void CreateJFIUserMethod(String firstName, String Password, String jFIRole, String jFIStatus,String streetAddres1,String JfiUserPhoneNo,String jFIEmail,String jFICity,String jFIState,String jFIZipcode) throws InterruptedException {	
		 	UserBtn.click();
		 	CreateUser.click();
		 	JfiFirstName.sendKeys(firstName);
		 	JfiPassword.sendKeys(Password);
		 	JfiRole.sendKeys(jFIRole,Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
		 	JfiStatus.sendKeys(jFIStatus,Keys.ARROW_DOWN,Keys.ENTER);
		 	JfiAddress1.sendKeys(streetAddres1);
		 	JfiPhone.sendKeys(JfiUserPhoneNo);
		 	JfiEmail.sendKeys(jFIEmail);
		 	JfiCity.sendKeys(jFICity);
		 	JfiState.sendKeys(jFIState,Keys.ARROW_DOWN,Keys.ENTER);
		 	JfiZipcode.sendKeys(jFIZipcode,Keys.BACK_SPACE);
		 	Save.click();
		 	Thread.sleep(2000);
		 	
		 	
	    }
	 
	 public void editJFIUserMethod() throws InterruptedException {	
		 	UserBtn.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
		 	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(JfiStatus));
		 	//JfiLastName.clear();
		 	//JfiLastName.sendKeys("prem");
		 	//JfiLastName.sendKeys(Keys.ENTER);
		 /*	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(JfiStatus));*/
		 	Thread.sleep(5000);
		 	JfiStatus.click();
		 	JfiStatus.sendKeys("INACTIVE",Keys.ARROW_DOWN,Keys.ENTER);
		 	// JavascriptExecutor js = (JavascriptExecutor) driver;
		     //js.executeScript("arguments[0].click();", Save);
		 	Save.click();
		 	Thread.sleep(2000);
		 	
	    }
	 public String deleteJFIUserMethod() {	
		 	UserBtn.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(2).click();
			}
		 	//userDelete.click();
		 	 Actions act = new Actions(driver);
		 	act.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		   
		 	//confirmDelete.click();
		 	String expectedText=ConfirmMessage.getText();
		 	return expectedText;
		 	
	    }
	 
	 
	 public void CreateAgentMethod() throws InterruptedException {	
		 WebDriverWait wait = new WebDriverWait(driver, 20); 
		 Actions act = new Actions(driver);
		 	UserBtn.click();
		 	AgentTab.click();
		 	CreateUser.click();
		 	agentFirstName.sendKeys("testAgent");
		 	agentPassword.sendKeys("Test@123");	
		 	selectAgency.click();
		 	selectAgency.sendKeys("TF properties");
		 	Thread.sleep(2000);		 	
		    act.sendKeys(Keys.DOWN).perform();
		    act.sendKeys(Keys.ENTER).perform();		 	
		 	wait.until(ExpectedConditions.visibilityOf(agentAddress1));
		 	agentAddress1.sendKeys("123 street");
		 	agentPhone.sendKeys("9767878804");
		 	agentEmail.sendKeys("Test@test.com");
		 	agentCity.sendKeys("Florida City");
		 	agentState.sendKeys("Florida",Keys.ARROW_DOWN,Keys.ENTER);
		 	agentZipcode.sendKeys("32003"); 	
		 	Save.click();
		 	Thread.sleep(2000);
	    }
	 
	 public void editAgentMethod() throws InterruptedException {	
		 Actions act = new Actions(driver);
		 	UserBtn.click();
		 	Thread.sleep(5000);
		 	AgentTab.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
		 	Thread.sleep(5000);
		 	selectAgency.click();
		 	selectAgency.sendKeys("TF properties");
		 	Thread.sleep(2000);		 	
		    act.sendKeys(Keys.DOWN).perform();
		    act.sendKeys(Keys.ENTER).perform();	
		    Thread.sleep(2000);
		 	Save.click();
		 	
	    }
	 public String deleteAgentMethod() {	
		 	UserBtn.click();
		 	AgentTab.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(2).click();
			}
		 	//userDelete.click();
		 	//confirmDelete.click();
		 	Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		 	String expectedText=ConfirmMessage.getText();
		 	return expectedText;
		 	
	    }
	 
	 public String deleteAgencyMethod() {	
		 	UserBtn.click();
		 	AgencyTab.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(2).click();
			}
		 	//userDelete.click();
		 	Actions act = new Actions(driver);
		 	act.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		 	//confirmDelete.click();
		 	String expectedText=ConfirmMessage.getText();
		 	return expectedText;
		 	
	    }
	
	 public void createAgencyMethod() throws AWTException {	
		 //
		 	UserBtn.click();
		 	AgencyTab.click();
		 	CreateUser.click();
		 	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(agencyLegalName));
		 	agencyLegalName.sendKeys("Joeflood123");
		 	agencyDba.sendKeys("Joeflood123");
		 	streetAddres1.sendKeys("1 Mansfield Pl");
		 	phone.sendKeys("9898981316");
		 	city.sendKeys("Florida city"); 	 	
		 	state.sendKeys("Florida",Keys.ARROW_DOWN, Keys.ENTER);
		  	zipCode.sendKeys("32000");
		  	nextBtn.click();
		   	wait.until(ExpectedConditions.visibilityOf(firstName));
		 	firstName.sendKeys("JSmith");
		 	principal1Title.sendKeys("Mr");
		 	password.sendKeys("Jfi@123");		 	 	
		 	agencyStreetAddres1.sendKeys("test 123");		 		
		 	agencyPhone.sendKeys("9898981316");
		 	email.sendKeys("test@ttf.com");
		 	agencyCity.sendKeys("Florida City");
		 	selectState.sendKeys("Florida",Keys.ARROW_DOWN, Keys.ENTER);
		 	agencyZipCode.sendKeys("32322");
		 	nextBtn.click();
		  	//Mailing section
		 	//wait.until(ExpectedConditions.visibilityOf(sameAsMailingAddBtn));
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//input[@name='sameAsMailingAdd']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(0).click();
			}
		 	//sameAsMailingAddBtn.click();
		 	nextBtn.click();
		 	//Accounting Section
		 	wait.until(ExpectedConditions.visibilityOf(firstName));
		 	firstName.sendKeys("JSmith");
		 	StreetAddres1.sendKeys("test 123");
		 	Phone.sendKeys("9898981316");
		 	AccountingEmail.sendKeys("test@tf.com");
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
		    
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,350)", "");
		    wait.until(ExpectedConditions.visibilityOf(isCurrentW9));
		    isCurrentW9.click();
		    nextBtn.click();
		   
		 	
	        
	    }

	 public void editAgencyMethod() throws InterruptedException {	
		 	UserBtn.click();
		 	AgencyTab.click();
		 	List<WebElement> listOfElements = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']"));
		 	if(listOfElements.size()>0)
			{
				listOfElements.get(1).click();
			}
		 	WebDriverWait wait = new WebDriverWait(driver, 20); 
		 	wait.until(ExpectedConditions.visibilityOf(agencyLegalName));
		 	//state.sendKeys("Alaska",Keys.ARROW_DOWN, Keys.ENTER);
		 	Thread.sleep(5000);
		 	agencyStatus.click();
		 	agencyStatus.sendKeys("INACTIVE",Keys.ARROW_DOWN,Keys.ENTER);
		 	//agentZipcode.sendKeys("32004"); 
		 	nextBtn.click();
		 	//wait.until(ExpectedConditions.visibilityOf(w9detailsTab));
		 	Thread.sleep(2000);
		 	w9detailsTab.click();
		 	//JavascriptExecutor js = (JavascriptExecutor) driver;
		 	//js.executeScript("arguments[0].scrollIntoView();", nextBtn);
		 	//wait.until(ExpectedConditions.visibilityOf(w9detailsTab));
		 	Thread.sleep(2000);
		 	nextBtn.click();
		 	/*wait.until(ExpectedConditions.visibilityOf(firstName));
		 	nextBtn.click();
		 	wait.until(ExpectedConditions.visibilityOf(W9File));
		 	nextBtn.click();*/
		 	
	    }
	 	

	   
}
