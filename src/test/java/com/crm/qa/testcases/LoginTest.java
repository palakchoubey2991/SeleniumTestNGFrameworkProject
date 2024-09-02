package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    public LoginTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initilazation();
        loginPage=new LoginPage();
    }
    @Test
    public void loginPageTittleTest()
    {
        String tittle=loginPage.validateLoginPageTitle();
        Assert.assertEquals(tittle,"Free CRM software for customer relationship management, sales, and support.");
    }

    @Test
    public void crmLogoImageTest()
    {
        boolean flag=loginPage.validateFreeCRMLogo();
        Assert.assertTrue(flag);
    }

    @Test
    public void loginTest()
    {
       homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}



