package com.joeflood.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.joeflood.qa.base.TestBase;

public class HomePage extends TestBase {

    @FindBy(xpath = "//h5[contains(text(),'Prem Kumar')]")
    @CacheLookup //It will create cache memory and save the element there then picks it up element from there when we call it multiple times instead of going to Html DOM every time. If html DOM is refreshed Cache will get corrupted and throw Stale Element exception
            WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement taskLink;

    //Initialize the page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DashboardPage clickOnDealsLink() {
        dealsLink.click();
        return new DashboardPage();
    }

    public TasksPage clickOnTasksLink() {
        taskLink.click();
        return new TasksPage();
    }

    public void clickOnNewContactLink() {
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }
}
