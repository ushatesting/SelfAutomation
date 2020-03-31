package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;



public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		
		try {
			 prop = new Properties();
			FileInputStream ip =new FileInputStream("D:\\Java Training\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			} catch(FileNotFoundException e) {
			e.printStackTrace();
			} catch(IOException e) {
			e.printStackTrace();
			}
		
	}
	
	
	
	public static void Initialization() {
		String BrowserName =prop.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\browserdrivers\\chromedriver_win32 (2)\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\browserdrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		String Appurl=prop.getProperty("url");
		driver.get(Appurl);;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_wait, TimeUnit.SECONDS);
		
		
	
		
	}




	
	
}
	
  
	

