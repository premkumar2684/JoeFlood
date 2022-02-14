package com.joeflood.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.joeflood.qa.util.TestUtil;
import com.joeflood.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
   // public ExtentReports extent;
   // public ExtentTest extentTest;


    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src\\main\\java\\com\\joeflood\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Testing\\setups\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Testing\\setups\\geckodriver-v0.30.0-win32\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        //WebDriverFireEvent = to generate selenium action logs in Console using template
/*
       e_driver = new EventFiringWebDriver(driver);
//        Now create object of EventListenerHandler to register it with EventFiringDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
*/
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
    
    public void takesScreenshotFailedTestCases(ITestResult result,ExtentTest extentTest,ExtentReports extent) throws IOException {    	
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); //To add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // To add error/exception in extent report
            String screenShotPath = TestUtil.getScreenshot(driver, result.getName());
//            extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenShotPath)); //To add screenCast or Video in extent report
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenShotPath)); //To add screenshot in extent report

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getName());
        }
        extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report


        driver.quit();
    }
    
    
}
