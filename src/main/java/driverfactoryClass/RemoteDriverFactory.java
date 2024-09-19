package driverfactoryClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory 
{
	static WebDriver driver;
	
	public WebDriver initBrowser(String browsername) throws MalformedURLException
	{
		String host="localhost";
		Capabilities capabilities;
		
		if(browsername.equals("Chrome"))
		{
			  capabilities = new ChromeOptions();
		}
		else
		{
			capabilities=new FirefoxOptions();
		}
		
		if(System.getProperty("HUB_HOST")!= null)
		{
			host = System.getProperty("HUB_HOST");
		}
		
		driver=new RemoteWebDriver(new URL("http://"+host+":4444/wd/hub"),capabilities);
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	

}
