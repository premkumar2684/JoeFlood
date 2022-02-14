package com.joeflood.qa.testcases;

import com.joeflood.qa.base.TestBase;
import com.joeflood.qa.pages.ContactsPage;
import com.joeflood.qa.pages.HomePage;
import com.joeflood.qa.pages.LoginPage;
import com.joeflood.qa.util.TestUtil;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
   

    public HomePageTest() {
        super();
    }

    //Test cases should be independent -- with each other
    //before each test case -- launch browser
    //@test -- execute test case
    //after each test case -- close browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        //loginPage = new LoginPage();
        
       // homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("otp"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() throws InterruptedException {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Login | Joe Flood", "Home page title is not matched");
    }

   

    

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }

}
