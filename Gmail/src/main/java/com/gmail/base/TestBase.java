package com.gmail.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.gmail.util.TestUtil;

public class TestBase {

	public static WebDriver driver; // Global Variables
	public static Properties prop; // Global Variables

	public TestBase() throws Exception // Constructor Defined
	{

		
	}

	public static void initalization() // method declaration
	{
		try {
			File file = new File(System.getProperty("user.dir")+"/src/main/java/com/gmail/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			} catch (IOException e) {
	
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser"); // Read the property

		if (browserName.equals("chrome")) // For Chrome Browser
		{

			System.setProperty("webdriver.chrome.driver", "D:/Project/Project/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) // For Firefox Browser
		{

			System.setProperty("webdriver.gecko.driver", "D:/Project/Project/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		

		driver.get(prop.getProperty("url"));

	}
	
	@BeforeSuite
	public void setUp() 
	{
		initalization();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();

	}

}
