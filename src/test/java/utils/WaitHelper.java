package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public class WaitHelper {
	
	private static final Logger logger = LoggerHelper.getLogger(WaitHelper.class);
	public static void waitForElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Element visible:" + element);
		}
		catch (Exception e)
		{														
			logger.error("Element not visible within timeout:" +element, e);
			throw e;
		}		
	}
	
	// optional: oveeloaded method with default timeout	
	public static void waitForElementVisible(WebDriver driver, WebElement element)
	{
		
		waitForElementVisible(driver, element, 10);
	}
			
}
