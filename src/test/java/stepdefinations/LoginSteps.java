package stepdefinations;
import java.net.http.WebSocket;
import org.apache.xalan.xsltc.compiler.util.ErrorMsg;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverFactory;
import utils.LoggerHelper;
import utils.WaitHelper;

public class LoginSteps {

	LoginPage loginPage;
	
	@Given("user is on login page")
	public void user_is_on_login_page()
	{		
		loginPage = new LoginPage(DriverFactory.getDriver());
		
		//Open the OrangeHRM login page
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}	
	@When("User enters valid credentials {string} and {string}")
	public void user_enters_credentials(String username, String password)
	{
		Logger logger = LoggerHelper.getLogger(LoginSteps.class);
		logger.info("Entering credentials:" + username + "/" + password);
		loginPage = new LoginPage(DriverFactory.getDriver());
	    loginPage.login(username, password);		
	}
	
	@Then("User should see {string}")
	
	public void user_should_see_expected_result(String expectedResult)
	{
		if(expectedResult.toLowerCase().contains("dashboard"))
		{						
			String actualText = loginPage.getDashboardHeadingText();
			Assert.assertTrue(actualText.toLowerCase().contains("dashboard"), "Expected dashboard page");
						
		} else
		{
			String errorMsg = loginPage.getInvalidCredentialMessage();
			
			Assert.assertEquals(expectedResult, errorMsg);
		}
	}
	
	@Then("User waits for the dashboard to be visible")
	public void waitForDashboardHeading() 
	{
		WebElement dashboardElement = loginPage.getDashboardHeading(); //assume this return webelement
		WaitHelper.waitForElementVisible(DriverFactory.getDriver(), dashboardElement);
		
	}
	
}
