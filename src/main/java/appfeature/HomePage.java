package appfeature;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	@FindBy(xpath="//*[@class=\"nav-cart-icon nav-sprite\"]")
	private WebElement cartButton;
	
	@FindBy(xpath="//span[text()=\"Hello, sign in\"]")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement userIdTextbox;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement passTextBox;
	
	@FindBy(xpath="//input[@id=\"signInSubmit\"]")
	private WebElement finalSignButton;
	
	// Constructor is used to initialize the webelements
	
	public HomePage(WebDriver driver)
	{
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   
	}
	
	public String getTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyCartIcon()
	{
		boolean isdisplay = cartButton.isDisplayed();
		return isdisplay;
	}
	
	public void signButtonClick()
	{
		Actions action=new Actions(driver);
		action.moveToElement(signInButton).perform();
		signInButton.click();
	}
	
	public void enterUsername(String uname)
	{
		userIdTextbox.sendKeys(uname);
	}
	
	public void finalSign(String pwd) throws InterruptedException
	{

		Thread.sleep(2000);
		passTextBox.sendKeys(pwd);
		finalSignButton.click();
	}
	
	public void continueButtonClick()
	{
		continueButton.click();
	}
	
	
}
