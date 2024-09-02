package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement conatctPageLabel;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id="surname")
    WebElement lastName;

    @FindBy(name="client_lookup")
    WebElement companyName;

    @FindBy(xpath = "//input[@type='submit' and @value='Save' ]")
    WebElement saveBtn;

    public boolean veifytheContactLable()
    {
       return conatctPageLabel.isDisplayed();
    }

    //this approch won't be suiatble for this kind of loactors beacuse 'ch jaanu' may change in futur so create a
    //method , it will be more dynamic
//    @FindBy(xpath = "//a[contains(text(),'ch jaanu')]//parent::td/preceding-sibling::td")
//    WebElement Chckboxname;

    public void clickonCheckBox(String name)
    {
        driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td/preceding-sibling::td"));
    }

    public ContactsPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void createNewConatact(String title,String ftName,String ltName,String compName)
    {
        Select dropdown=new Select(driver.findElement(By.name("title")));
        dropdown.selectByValue(title);
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        companyName.sendKeys(compName);
        saveBtn.click();
    }


}
