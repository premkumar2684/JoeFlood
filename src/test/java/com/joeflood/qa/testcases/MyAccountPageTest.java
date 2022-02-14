package com.joeflood.qa.testcases;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.pages.MyAccountPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.joeflood.qa.pages.DashboardPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyAccountPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    MyAccountPage myAccountPage;
    public ExtentReports extent;
    public ExtentTest extentTest;
    
    public MyAccountPageTest() {
        super();
    }
    
    @BeforeTest
    public void setExtent() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/extentScreenshotReport.html", true);
        extent.addSystemInfo("user name", "Prem");
        extent.addSystemInfo("Environment", "QA");
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    } 

    @Test(enabled=false,priority = 0)
    public void verifyAccountsPageTitleTest() {
    	myAccountPage = new MyAccountPage();
    	loginPage = new LoginPage();
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	extentTest = extent.startTest("verifyAccountsPageTitleTest");
        String AccountsPageTitle = myAccountPage.verifyAccountsPageTitleTest();
        Assert.assertEquals(AccountsPageTitle, "Accounts | Joe flood", "Home page title is not matched");
    }

    @Test(priority = 1)
    public void changePassword() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	extentTest = extent.startTest("changePassword");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	myAccountPage.changePassword(prop.getProperty("password"),prop.getProperty("newpassword"));
    	String AccountsPageTitle = myAccountPage.verifyAccountsPageTitleTest();
        Assert.assertEquals(AccountsPageTitle, "Accounts | Joe flood", "Home page title is not matched");
    }
    
    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
    	takesScreenshotFailedTestCases(result,extentTest,extent);    	
        }
    
   
    @AfterTest
    public void endReport() {
        extent.flush();
        extent.close();
    }
}
