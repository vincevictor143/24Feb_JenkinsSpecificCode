package appfeaturesStef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactoryClass.DriverFactory;
import driverfactoryClass.RemoteDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class AppHooks 
{
	WebDriver driver;
	RemoteDriverFactory rdf;
//	DriverFactory df;
	@Before
	public void initiateBrowser() throws IOException
	{
		ConfigReader cr=new ConfigReader();
        String browsername = cr.readConfig("browser");
//		Properties prop=new Properties(); 
//      String path =System.getProperty("user.dir")+"//src//test//resources//Config//config.properties";
//		String path =System.getProperty("user.dir")+"//target//docker-resources//config.properties";
//       FileInputStream fis=new FileInputStream(path);
//		prop.load(fis);
//		String browsername = prop.getProperty("browser");
        
    String maven_browsername = System.getProperty("clibrowser");
	
    if(maven_browsername!=null)
	{
			browsername=maven_browsername;
    }
		
	//	df=new DriverFactory();
		
		rdf = new RemoteDriverFactory();
		driver=rdf.initBrowser(browsername);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("D:\\Pinspire\\ATT_15 June_Morning\\"+scenario.getName()+".png"));
		}
	}

}
