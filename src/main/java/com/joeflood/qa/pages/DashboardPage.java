package com.joeflood.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.LoginPage;


public class DashboardPage extends TestBase {
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']")
    WebElement LogoutBtn;
	@FindBy(xpath="//*[contains(text(),'Sign out')]")
	WebElement Logout;
	
	
	//Element <button class="MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit" type="button">
	//is not clickable at point (1295,32) because another element
	//<h6 class="MuiTypography-root-803 MuiTypography-subtitle1-814"> obscures it

	public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
	
	 public String verifyDashboardPageTitleTest() {		 
	        return driver.getTitle();
	    }
	 
	 	LoginPage loginPage;
	    HomePage homePage;
	    DashboardPage dashboardPage;

	    
	    @BeforeMethod
	    public void setUp() {
	        initialization();
	        loginPage = new LoginPage();
	    } 

	    @Test(priority = 1)
	    public void logoutTest() {
	    	
	    	dashboardPage = new DashboardPage();
	    	homePage = new HomePage();
	    	//LogoutBtn.click();
	    	Logout.click();
	      }
	    
	   
	


}
