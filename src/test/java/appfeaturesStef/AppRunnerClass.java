package appfeaturesStef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features={"classpath:appfeatures"}, 
		glue={"appfeaturesStef"},
		plugin={"pretty",
				"html:target/cucumber-report/amazonreports.html",
				"json:target/cucumber-report.json",
				"rerun:target/failedrun.txt"}
)

public class AppRunnerClass extends AbstractTestNGCucumberTests 
{
	
}
