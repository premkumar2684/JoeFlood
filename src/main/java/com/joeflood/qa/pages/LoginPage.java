package com.joeflood.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.joeflood.qa.base.TestBase;

public class LoginPage extends TestBase {

    //Page factory - OR:
    @FindBy(xpath="//input[@placeholder='Enter phone number']")
    WebElement mobilenumber;
  
    @FindBy(name = "password")
    WebElement password;
    
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;
    
    @FindBy(name= "otp")
    WebElement EnterOTP;
    
    @FindBy(xpath="//span[contains(text(),'Verify')]")
    WebElement verify;
    
    @FindBy(xpath="//*[@id=\"root\"]/div/header/div/button[2]/span[1]/div")
    WebElement myaccount;
    
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[@src='/static/media/joe-flood-logo-small-trasparent.15bd514f.png']")
    WebElement jfLogo;
    @FindBy(xpath="//span[contains(@class,'icon icon-xs mdi-chart-bar')]")
    WebElement loginBtnHomePage;
    @FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']")
    WebElement LogoutBtn;
    @FindBy(xpath="//*[contains(text(),'Sign out')]")
	WebElement Logout;


    //    Initializing the page objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    //    Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateJfImage() {
        return jfLogo.isDisplayed();
    }

    public void login(String un, String pwd, String otp) {
    	
    	mobilenumber.sendKeys(un);
        password.sendKeys(pwd);
//        loginBtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
        //loginBtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        EnterOTP.sendKeys(otp);
        verify.click();
       // WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/static/media/joe-flood-logo-small-trasparent.15bd514f.png']")));
        //LogoutBtn.click();
       // Logout.click();
        
        
        
       //return new LoginPage();
    }

}
