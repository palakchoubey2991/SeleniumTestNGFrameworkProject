package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class HomePage extends TestBase {
    @FindBy(xpath="//td[contains(text(),'Gagan ')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    @FindBy(xpath = "//a[@title='New Contact']")
    WebElement newConatcts;




    public void clickonNewContacts()
    {
        Actions action=new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newConatcts.click();
    }



    //Initialising the page Objects
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    //Actions
    public String verifyHomePageTittle()
    {
        String tittle=driver.getTitle();
        return tittle;
    }
    public ContactsPage clickOnContactsLink()
    {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink()
    {
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickOnTaskLink()
    {
        tasksLink.click();
        return new TaskPage();
    }
    public boolean verifyCorrectUserLogin()
    {
       return userNameLabel.isDisplayed();
    }
}
