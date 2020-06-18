package StepDefinations;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CucumberOptions.TestRunner;
import Page.LandingPage;
import Page.Loginpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class) -- this is optional in step defination
public class StepDefination
{
	WebDriver driver;
	static String exp_title="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
	LandingPage lp=new LandingPage(driver);
	Loginpage loginpg=new Loginpage(driver);
	WebDriverWait w;
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Given("validate the browser")
	public void validate_the_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@When("browser is triggered")
	public void browser_is_triggered() {
	    System.out.println("Browser is triggered");
	}
	
	
	@Then("check if browser is started")
	public void check_if_browser_is_started() {
		driver.get("https://www.myntra.com/");
	}
	
	@Given("user is on landing page")
	public void user_is_on_landing_page() 
	{
		String act_title=driver.getTitle();
		Assert.assertEquals(act_title, exp_title);
		System.out.println("title matches");
	}
	
	@When("user click on profile")
	public void user_click_on_profile()
	{
		Actions a=new Actions(driver);
		WebElement profile=driver.findElement(By.xpath("//span[.='Profile']"));
		a.moveToElement(profile);
		a.perform();
	
	}
	
	@When("user click on login link")
	public void user_click_on_login_link() 
	{
		WebElement login=driver.findElement(By.xpath("//a[.='login / Signup']"));
		login.click();
	}
	
	@Then("user is on login page")
	public void user_is_on_login_page() 
	{
		WebElement continueBtn= driver.findElement(By.xpath("//div[.='CONTINUE']"));
		w= new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(continueBtn));
	}

}
