package com.joeflood.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.joeflood.qa.base.TestBase;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(name = "title")
    WebElement nameTitle;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "surname")
    WebElement lastName;

    @FindBy(name = "client_lookup")
    WebElement company;

    @FindBy(xpath = "//input[@typr='submit' and @value='Save']")
    WebElement saveBtn;


    //    Initializing the page objects
    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }

    public void selectContacts(String name) {
        driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']" +
                "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    public void createNewContact(String title, String ftName, String ltName, String cName) {
        Select select = new Select(nameTitle);
        select.selectByVisibleText(title);

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        company.sendKeys(cName);
        saveBtn.click();
    }
}
