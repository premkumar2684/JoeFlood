package com.joeflood.qa.testcases;

import com.joeflood.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.pages.MyAccountPage;
import com.joeflood.qa.pages.DashboardPage;
import com.joeflood.qa.pages.EnrollmentPage;

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

public class EnrollmentPageTest extends TestBase {
	LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    MyAccountPage myAccountPage;
    EnrollmentPage enrollmentPage;
    public ExtentReports extent;
    public ExtentTest extentTest;
    TestUtil testUtil;
    String sheetName = "AgencyEnrollment";

    public EnrollmentPageTest() {
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

    @Test(priority = 0)
    public void verifyEnrollmentPageTitleTest() {
    	enrollmentPage = new EnrollmentPage();
    	extentTest = extent.startTest("verifyEnrollmentPageTitleTest");
    	String AccountsPageTitle = enrollmentPage.verifyEnrollmentPageTitleTest();
        Assert.assertEquals(AccountsPageTitle, "Login | Joe Flood", "Home page title is not matched");
    }

    @Test(priority=1,dataProvider = "getTestData")
    public void agencyEnrollmentMethodTest(String agencyLegalName, String agencyDba, String streetAddres1, String AgencyPhoneNo,String agencyCity,String agencyState,String agencyZipcode,String PrincipalFirstName,String Principalpassword,String PrincipalConfirmPassword,String PrincipalTitle,String agencyStreetAddres1,String PrincipalPhone,String principalEmail,String PrincipalCity,String PrincipalState,String PrincipalZipcode,String AccountingFirstName,String AccountingAddress,String AccountingPhone,String AccountingEmail,String AccountingCity,String AccountingState,String AccountingZipcode) throws AWTException {
    	enrollmentPage = new EnrollmentPage();
    	extentTest = extent.startTest("agencyEnrollmentMethodTest");
    	enrollmentPage.agencyEnrollmentMethod(agencyLegalName,agencyDba,streetAddres1,AgencyPhoneNo,agencyCity,agencyState,agencyZipcode,PrincipalFirstName,Principalpassword,PrincipalConfirmPassword,PrincipalTitle,agencyStreetAddres1,PrincipalPhone,principalEmail,PrincipalCity,PrincipalState,PrincipalZipcode,AccountingFirstName,AccountingAddress,AccountingPhone,AccountingEmail,AccountingCity,AccountingState,AccountingZipcode);
       
    	//String AccountsPageTitle = myAccountPage.verifyAccountsPageTitleTest();
        //Assert.assertEquals(AccountsPageTitle, "Accounts | Joe flood", "Home page title is not matched");
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
