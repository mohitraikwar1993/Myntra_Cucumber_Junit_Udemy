package StepDefinations_POM;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.internal.com.google.common.io.Files;



public class Hooks 
{
	public static WebDriver driver;
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Before
	public void openBrowser()
	{
		ChromeOptions options=new ChromeOptions();	//to disable show notification popup
		options.addArguments("--disable-notifications");	//to disable show notification popup
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		
	}
	
	@After
	public void closeBrowser(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			Date date=new Date();
			String d=date.toString().replaceFirst(":", "_");
			TakesScreenshot sc=(TakesScreenshot)driver;
			File src=sc.getScreenshotAs(OutputType.FILE);
			File des=new File("./screenshots/"+scenario.getName()+"_"+d+".jpg");
			Files.copy(src, des);
		}
		driver.close();
		
	}
}
