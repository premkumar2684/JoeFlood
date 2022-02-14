package com.joeflood.qa.testcases;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.pages.MyAccountPage;
import com.joeflood.qa.pages.SubmissionPage;
import com.joeflood.qa.pages.UsersPage;
import com.joeflood.qa.pages.DashboardPage;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmissionPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    MyAccountPage myAccountPage;
    UsersPage usersPage;
    SubmissionPage submissionPage;
    TestUtil testUtil;
    String sheetName = "SubmissionFormData";
    public ExtentReports extent;
    public ExtentTest extentTest;

    public SubmissionPageTest() {
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
    
    @DataProvider
    public Object[][] getTestData() {
    	testUtil = new TestUtil();
        Object data[][] = testUtil.getTestdata(sheetName);
        return data;
    }

    @Test(enabled=false)
    public void UsersPageTitleTest() {
    	loginPage = new LoginPage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("UsersPageTitleTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
        String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "Home page title is not matched");
    }
    
   
    @Test(priority=1,dataProvider = "getTestData")
    public void CreateSubmissionTest(String location, String submissionNotes, String insuredFirstName, String OccupancyType,String OccupancyClassification,String ConstructionType,String FoundationType,String structureCoverageRCV,String structureCoverageAmount,String structureCoverageDeductibleAmount,String contentsCoverageRCV,String contentsCoverageAmount,String contentsCoverageDeductibleAmount) throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	submissionPage = new SubmissionPage();
    	extentTest = extent.startTest("CreateSubmissionTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	submissionPage.CreateSubmissionMethod(location,submissionNotes,insuredFirstName,OccupancyType,OccupancyClassification,ConstructionType,FoundationType,structureCoverageRCV,structureCoverageAmount,structureCoverageDeductibleAmount,contentsCoverageRCV,contentsCoverageAmount,contentsCoverageDeductibleAmount);
    	/*String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "Home page title is not matched"); */
    	
    	
    }
    
    @Test(enabled=false,priority=5)
    public void DeleteSubmissionFormTest() {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	submissionPage = new SubmissionPage();
    	extentTest = extent.startTest("DeleteSubmissionFormTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	String expectedText = submissionPage.DeleteSubmissionFormMethod();
    	Assert.assertEquals(expectedText, "Submission Deleted Successfully", "Submission Form deletion is not Sucessfull");
    	
    	
    }
    
    @Test(enabled=false,priority=4)
    public void EditSubmissionFormTest() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	submissionPage = new SubmissionPage();
    	extentTest = extent.startTest("EditSubmissionFormTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	submissionPage.editSubmissionFormMethod();
    	//String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        //Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "Home page title is not matched");
    	    	
    	
    }
    
    @Test(priority=2,dependsOnMethods="CreateSubmissionTest")
    public void GetQuoteTest() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	submissionPage = new SubmissionPage();
    	extentTest = extent.startTest("GetQuoteTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	//submissionPage.CreateSubmissionMethod();
    	submissionPage.GetQuoteMethod();
    	
    	String quotesPlans = submissionPage.ViewQuoteMethod();
    	// Testing if regex is present or not
            System.out.println(quotesPlans.matches("(.*)[0-5](.*)"));
    	//Assert.assertEquals(true, quotesPlans.contains("selenium"),"custom message");
    	/*String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "Home page title is not matched"); */
    	
    	
    }
    
    @Test(priority=3,dependsOnMethods="GetQuoteTest")
    public void QuoteDownloadTest() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	submissionPage = new SubmissionPage();
    	extentTest = extent.startTest("QuoteDownloadTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	//submissionPage.CreateSubmissionMethod();
    	submissionPage.QuoteDownloadMethod();
    	
    	
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
