package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		
		try{
			
		prop= new Properties();
		
		FileInputStream fi= new FileInputStream("/Users/hridhaan/eclipse-workspace/FreeCRMTest/src"
				+ "/main/java/com/crm/qa/config/config.properties");
		
		prop.load(fi);
		}
		catch(FileNotFoundException e)
		{e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();}
		
	}
	
public static void initialization()
{
	String browserName= prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "BrowserUtils/chromedriver2");
		 driver=new ChromeDriver();
	}
	else if (browserName.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "BrowserUtils/geckodriver");
		 driver=new FirefoxDriver();
		
	}
	else if(browserName.equals("Safari"))
	{
		 driver =new SafariDriver();
	}
	
	e_driver=new EventFiringWebDriver(driver);
	//Now Create object of EventListnerHandler to register EventFiringWebDriver
	eventListener=new WebEventListener();
	e_driver.register(eventListener);
	driver=e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}

}
