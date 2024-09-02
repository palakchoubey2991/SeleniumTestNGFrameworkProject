package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUil testUil;
    ContactsPage contactsPage;
    ContactPageTest contactPageTest;
    String sheetName="contacts";
    public ContactPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setUp()
    {
        initilazation();
        loginPage=new LoginPage();
        homePage =new HomePage();
        testUil=new TestUil();
        contactsPage=new ContactsPage();
        contactPageTest=new ContactPageTest();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUil.switchToFrame();
        contactsPage=homePage.clickOnContactsLink();

    }

    @Test(priority = 1)
    public void verifyContactPageLabelTest()
    {

        Assert.assertTrue(contactsPage.veifytheContactLable(),"contact label is missing");
    }

    @Test(priority = 2)
    public void selectContactsTest()
    {

        contactsPage.clickonCheckBox("ch jaanu");
    }
    @Test(priority = 3,dataProvider = "getTestData")
    public void craeteNewContactTest(String title,String fName,String LName,String Company)
    {
        homePage.clickonNewContacts();
        //contactsPage.createNewConatact("Mr.","Chetan","SHrivastava","Pega Softwares");
        contactsPage.createNewConatact(title,fName,LName,Company);
    }

    @DataProvider
    public Object[][] getTestData()
    {
       Object[][] data=TestUil.getTestData(sheetName);
       return data;
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
