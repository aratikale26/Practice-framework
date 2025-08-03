package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class LoginPage {

	WebDriver driver;
	
	//constructor to initialize driver
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(name ="username")
	private WebElement usernameField;
	
	@FindBy(name ="password")
	private WebElement passwordField;
	
	@FindBy(name ="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath ="//p[contains(@class, 'oxd-alert-content-text')]")
	private WebElement errorMsg;
			
	@FindBy(xpath ="//h6[contains(text(), 'Dashboard')]")
	private WebElement dashboardHeading;	
	
	//Reusable login method
	public void login(String username, String password)
	{
		WaitHelper.waitForElementVisible(driver, usernameField, 20);
		usernameField.clear();
		usernameField.sendKeys(username);
		WaitHelper.waitForElementVisible(driver, passwordField, 20);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginBtn.click();
	}
			
	public WebElement getDashboardHeading()
	{
		return dashboardHeading;
		
	}
	public String getDashboardHeadingText() {
		return getDashboardHeading().getText();
	}
	
	public String getInvalidCredentialMessage()
	{
		return
				errorMsg.getText();
	}
	
}

