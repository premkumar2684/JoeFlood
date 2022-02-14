package com.joeflood.qa.testcases;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.pages.MyAccountPage;
import com.joeflood.qa.pages.UsersPage;
import com.joeflood.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners()
public class UserPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    MyAccountPage myAccountPage;
    UsersPage usersPage;
    TestUtil testUtil;
    String sheetName = "JFIUserData";
    public ExtentReports extent;
    public ExtentTest extentTest;


    public UserPageTest() {
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

    @Test(enabled=false,priority=1)
    public void UsersPageTitleTest() {
    	loginPage = new LoginPage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("UsersPageTitleTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
        String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "Home page title is not matched");
    }
    
    @DataProvider
    public Object[][] getTestData() {
    	testUtil = new TestUtil();
        Object data[][] = testUtil.getTestdata(sheetName);
        return data;
    }

    @Test(priority=2,dataProvider = "getTestData")
    public void CreateJFIUserTest(String firstName, String Password, String jfIRole, String jFIStatus,String streetAddres1,String JfiUserPhoneNo,String jFIEmail,String jFICity,String jFIState,String jFIZipcode) throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("CreateJFIUserTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	usersPage.CreateJFIUserMethod(firstName,Password,jfIRole,jFIStatus,streetAddres1,JfiUserPhoneNo,jFIEmail,jFICity,jFIState,jFIZipcode);
    	String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "JFI user Creation is Not Sucessfull");
    	
    	
    }
   
    @Test(priority=4,dependsOnMethods="CreateJFIUserTest")
    public void DeleteJFIUserTest() {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("DeleteJFIUserTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	String expectedText = usersPage.deleteJFIUserMethod();
    	Assert.assertEquals(expectedText, "Deleted Successfully", "JFIUser deletion is not Sucessfull");
    	
    	
    }
    
    @Test(priority=3,dependsOnMethods="CreateJFIUserTest")
    public void EditJFIUserTest() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("EditJFIUserTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	usersPage.editJFIUserMethod();
    	String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "JFIUser Edit is not Completed");
    	    	
    	
    }
    
    @Test(priority=5)
    public void CreateAgencyTest() throws AWTException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("CreateAgencyTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	usersPage.createAgencyMethod();		
    	String UsersPageTitle = usersPage.verifyUsersPageTitleMethod();
        Assert.assertEquals(UsersPageTitle, "Users | Joe flood", "Home page title is not matched");
    	
    	
    	
    }
    
    @Test(priority=6)
    public void EditAgencyTest() throws InterruptedException{
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("EditAgencyTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	usersPage.editAgencyMethod();
    	//Assert.assertEquals(expectedText, "Deleted Successfully", "JFIUser deletion is not Sucessfull");
    	
    	
    }
    
    @Test(priority=7)
    public void DeleteAgencyTest() {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("DeleteAgencyTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	String expectedText = usersPage.deleteAgencyMethod();
    	Assert.assertEquals(expectedText, "Agency Deleted Successfully", "User deletion is not Sucessfull");
    	
    	
    }
    
    @Test(priority=8)
    public void CreateAgentTest() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("CreateAgentTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	usersPage.CreateAgentMethod();
    	String AccountsPageTitle = myAccountPage.verifyAccountsPageTitleTest();
        Assert.assertEquals(AccountsPageTitle, "Users | Joe flood", "Create Agent has Failed");
    	
    	
    }
    
    @Test(priority=9,dependsOnMethods="CreateAgentTest")
    public void EditAgentTest() throws InterruptedException {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("EditAgentTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	usersPage.editAgentMethod();
    	String AccountsPageTitle = myAccountPage.verifyAccountsPageTitleTest();
        Assert.assertEquals(AccountsPageTitle, "Users | Joe flood", "Edit Agent has Failed");
    	
    	
    }
    @Test(priority=10)
    public void DeleteAgentTest() {
    	myAccountPage = new MyAccountPage();
    	dashboardPage = new DashboardPage();
    	loginPage = new LoginPage();
    	homePage = new HomePage();
    	usersPage = new UsersPage();
    	extentTest = extent.startTest("DeleteAgentTest");
    	loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    	String expectedText = usersPage.deleteAgentMethod();
    	Assert.assertEquals(expectedText, "Agent Deleted Successfully", "User deletion is not Sucessfull");
    	
    	
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
