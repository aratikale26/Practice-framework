package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;
	public static WebDriver initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;				
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
					throw new RuntimeException("webdriver is not initialized, please call initializedDriver() in @Before hook.");
		}				
		return driver;				
	}
	
	public static void quitDriver()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
