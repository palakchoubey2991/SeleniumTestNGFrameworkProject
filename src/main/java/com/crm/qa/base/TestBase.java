package com.crm.qa.base;

import com.crm.qa.utils.TestUil;
import com.crm.qa.utils.WebEventListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
  public static WebDriver driver;
  public static WebDriver webDriver;
   public static Properties prop;
   public static EventFiringDecorator<WebDriver> e_driver;
   public static WebEventListener webEventListener;

    public TestBase()
    {
        try{
            prop=new Properties();
            FileInputStream ip=new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\FrameWorkFromScrachPOM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
            prop.load(ip);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public static void initilazation()
    {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            webDriver=new ChromeDriver();
        }


        webEventListener=new WebEventListener();
        e_driver= new EventFiringDecorator<>(webEventListener);
        driver=e_driver.decorate(webDriver);


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));

    }


}
