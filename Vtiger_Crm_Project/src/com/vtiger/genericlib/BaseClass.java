package com.vtiger.genericlib;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    public static WebDriver driver;
    FileUtil flib=new FileUtil();
    
    @BeforeSuite
       public void configBS() {
    	System.out.println("-------------------connect to DB------------------ ");
    }
    @BeforeClass
       public void configBC() throws Throwable {
    	 System.out.println("----------launch browser-----------");
    	 Properties pObj=flib.getPropertyFileObject();
    	 String browserName=pObj.getProperty("browser");
    	 if(browserName.equals("chrome")) {
    	 System.setProperty("Webdriver.chrome.driver", "./resouce/chromedriver.com");
    	 driver=new ChromeDriver();
    }else if(browserName.equals("firefox")) {
    	System.setProperty("Webdriver.firefox.driver", "./resource/firefoxdriver.com");
    	driver=new FirefoxDriver();
    }else if(browserName.equals("Ie")) {
    	System.setProperty("Webdriver.Ie.driver", "./resource/IEDriver.exe");
    	driver=new InternetExplorerDriver();
    }
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    	
    @BeforeMethod	
    public void configBM() throws Throwable {
    	System.out.println("----------------log in to Application--------------");
    	Properties pObj=flib.getPropertyFileObject();
    	driver.get(pObj.getProperty("url"));
    	driver.findElement(By.name("username")).sendKeys(pObj.getProperty("username"));
    	driver.findElement(By.name("password")).sendKeys(pObj.getProperty("password"));
    }
    	
    
    @AfterSuite
       public void configAS() {
    	System.out.println("------------------Disconnect from DB-----------------");
    }
}
