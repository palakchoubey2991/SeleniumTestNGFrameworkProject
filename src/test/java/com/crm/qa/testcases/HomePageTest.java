package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    public LoginPage loginPage;
    public HomePage homePage;
    TestUil testUil;
    public ContactsPage contactsPage;
    public HomePageTest()
    {
        super();
    }
    //test cases should be sepearated and independent
    //before each test case launch the browser and login
    //@Test method
    //after each test case close the browser
    @BeforeMethod
    public void setUp()
    {
        initilazation();
        testUil=new TestUil();
        loginPage=new LoginPage();
        contactsPage=new ContactsPage();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void verifyHomePageTittleTest()
    {
        String title=homePage.verifyHomePageTittle();
        System.out.println(title);
        Assert.assertEquals(title,"CRMPRO","the tittles are not matching");
    }

    @Test(priority = 2)
    public void verifyUserNameTest()
    {
        testUil.switchToFrame();
        boolean check=homePage.verifyCorrectUserLogin();
        Assert.assertTrue(check);
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest()
    {
        testUil.switchToFrame();
        contactsPage= homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }




}
