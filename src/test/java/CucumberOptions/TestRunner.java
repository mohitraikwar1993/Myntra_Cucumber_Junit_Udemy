package CucumberOptions;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
					features = "src/test/java/Features/Login_Hook.feature",
					glue = {"StepDefinations_POM"},
//					dryRun = true,
					plugin = {"pretty","html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cukes.xml" },
					tags = "@Smoke",
					monochrome = true,
					strict = true
				)
public class TestRunner
{
	
	 
}
