package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginbtn;

    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement Signupbtn;

    @FindBy(xpath = "//img[contains(@alt,'Free CRM Software for customer ')]")
    WebElement CompanyLogo;

    //Initialising the page Objects
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }

    public  boolean validateFreeCRMLogo()
    {
        return CompanyLogo.isDisplayed() ;
    }

    public HomePage login(String un,String pw)
    {
        username.sendKeys(un);
        password.sendKeys(pw);
        loginbtn.click();
        return new HomePage();
    }
}
