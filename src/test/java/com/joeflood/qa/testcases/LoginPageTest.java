package com.joeflood.qa.testcases;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
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

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    public ExtentReports extent;
    public ExtentTest extentTest;

    public LoginPageTest() {
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

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
    	
    	dashboardPage = new DashboardPage();
    	homePage = new HomePage();
    	extentTest = extent.startTest("loginTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	//String title = dashboardPage.validateDashboardPageTitle();
    	String DashboardPageTitle = homePage.verifyHomePageTitle();
        //System.out.println(DashboardPageTitle);
        Assert.assertEquals(DashboardPageTitle, "Dashboard | Joe flood");
        //Assert.assertEquals(DashboardPageTitle, "Dashboard | Joe flood", "Home page title is not matched");
    }
    
    @Test(enabled=false,priority = 2)
    public void forgotPasswordTest() throws InterruptedException {
    	
    	dashboardPage = new DashboardPage();
    	homePage = new HomePage();
    	extentTest = extent.startTest("forgotPasswordTest");
    	//loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
        //String title = dashboardPage.validateDashboardPageTitle();
    	String DashboardPageTitle = homePage.verifyHomePageTitle();
        //System.out.println(DashboardPageTitle);
        Assert.assertEquals(DashboardPageTitle, "Dashboard | Joe flood");
        //Assert.assertEquals(DashboardPageTitle, "Dashboard | Joe flood", "Home page title is not matched");
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
