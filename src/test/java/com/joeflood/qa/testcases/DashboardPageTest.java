package com.joeflood.qa.testcases;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.joeflood.qa.pages.DashboardPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    public ExtentReports extent;
    public ExtentTest extentTest;

    public DashboardPageTest() {
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

    @Test(priority = 2)
    public void verifyDashboardPageTitleTest() {
    	dashboardPage = new DashboardPage();
    	extentTest = extent.startTest("verifyDashboardPageTitleTest");
        String DashboardPageTitle = dashboardPage.verifyDashboardPageTitleTest();
        Assert.assertEquals(DashboardPageTitle, "Login | Joe Flo", "Home page title is not matched");
    }

    @Test(enabled=false,priority = 1)
    public void Logout() throws InterruptedException {
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	extentTest = extent.startTest("Logout");
    	dashboardPage.logoutTest();
    	 String homePageTitle = homePage.verifyHomePageTitle();
         Assert.assertEquals(homePageTitle, "Login | Joe Flood", "Home page title is not matched");
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
