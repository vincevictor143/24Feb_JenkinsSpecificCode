package appfeaturesStef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import appfeature.HomePage;
import driverfactoryClass.DriverFactory;
import driverfactoryClass.RemoteDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePage_StepDefClass
{
	HomePage homepage=new HomePage(RemoteDriverFactory.getDriver());
	
	@Given("User is at amazon portal")
	public void user_is_at_amazon_portal()
	{
		WebDriver driver = RemoteDriverFactory.getDriver();
		driver.get("https://amazon.in");
	}

	@Then("Title should contains the {string}")
	public void title_should_contains_the(String string) 
	{
	
		String title = homepage.getTitle();
		boolean isPresent = title.contains("Shopping");
		Assert.assertTrue(isPresent);
	}

	@Then("User should be able to see cart icon")
	public void user_should_be_able_to_see_cart_icon()
	{
		boolean isDisplay = homepage.verifyCartIcon();
		Assert.assertTrue(isDisplay);
	}

	@When("user should click in Sign in button")
	public void user_should_click_in_sign_in_button() 
	{
		homepage.signButtonClick();
	}

	@When("User should enter the username as {string}")
	public void user_should_enter_the_username_as(String uname)
	{
		homepage.enterUsername(uname);
	}
	
	@When("User should click on continue button of amazon")
	public void user_should_click_on_continue_button_of_amazon()
	{
		homepage.continueButtonClick();
	}

	@When("User should enter the password as {string}")
	public void user_should_enter_the_password_as(String pwd) throws InterruptedException
	{
		homepage.finalSign(pwd);
	}
	
	
	

}
