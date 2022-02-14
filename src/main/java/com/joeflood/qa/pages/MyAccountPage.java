package com.joeflood.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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


public class MyAccountPage extends TestBase {
	
	@FindBy(xpath="//div[@class='MuiAvatar-root MuiAvatar-circular makeStyles-avatar-56 MuiAvatar-colorDefault']//*[name()='svg']//*[name()='path' and contains(@d,'M12 12c2.2')]")
    WebElement LogoutBtn;
	@FindBy(xpath="//*[contains(text(),'My Account')]")
	WebElement myAccount;
	@FindBy(xpath="//*[contains(text(),'Change Password')]")
	WebElement changePassword;
	@FindBy(name="oldPassword")
	WebElement oldPassword;
	@FindBy(name="createPassword")
	WebElement createPassword;
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	@FindBy(xpath="//*[contains(text(),'Save')]")
    WebElement saveBtn;
	
	LoginPage loginPage;
    HomePage homePage;
    MyAccountPage dashboardPage;
	
	
	public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }
	
	 public String verifyAccountsPageTitleTest() {	
		 	//myAccount.click();
	        return driver.getTitle();
	    }
	
	 public void changePassword(String pwd,String newpwd) throws InterruptedException {	
		 	LogoutBtn.click();
		 	myAccount.click();
		 	JavascriptExecutor js = ((JavascriptExecutor) driver);
		 	js.executeScript("arguments[0].click();", changePassword);
		 	//changePassword.click();
		 	Thread.sleep(5000);
		 //	WebDriverWait wait = new WebDriverWait(driver, 20);
		 //	wait.until(ExpectedConditions.visibilityOf(oldPassword));
		 	
		 	oldPassword.sendKeys(pwd);
		 	createPassword.sendKeys(newpwd);
		 	confirmPassword.sendKeys(newpwd);
		 	saveBtn.click();
	        
	    }
	 	

	   
}
