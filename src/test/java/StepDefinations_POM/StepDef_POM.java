package StepDefinations_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Page.LandingPage;
import Page.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_POM 
{
	WebDriver driver;
	static String exp_title="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
	LandingPage lp;
	Loginpage loginpg;
	WebDriverWait w;
	
	public StepDef_POM() 
	{
		driver=Hooks.driver;
	}
	
	
	@Given("validate the browser")
	public void validate_the_browser() {
	
	}
	
	@Given("user is on landing page")
	public void user_is_on_landing_page() 
	{
		String act_title=driver.getTitle();
		Assert.assertEquals(act_title, exp_title);
		System.out.println("title matches");
	}

	@When("browser is triggered")
	public void browser_is_triggered() {
	    System.out.println("Browser is triggered");
	}
	
	@When("user click on profile")
	public void user_click_on_profile()
	{
		lp=new LandingPage(driver);
		lp.moveToProfile(driver);
	}
	
	@When("user click on login link")
	public void user_click_on_login_link() 
	{
		lp.clickLogin();
	}
	
	@When("user enters mob no {string}")
	public void user_enters_mob_no(String mobno) 
	{
	   loginpg=new Loginpage(driver);
	   loginpg.enterMobNo(mobno);
	   loginpg.clickContinue();
	}
	
	
	@Then("check if browser is started")
	public void check_if_browser_is_started() {
	
	}
	
	@Then("error message for invalid mobile no is displayed")
	public void error_message_for_invalid_mobile_no_is_displayed() 
	{
		loginpg=new Loginpage(driver);
		loginpg.verifyErrorMsg();
		loginpg.clickContinue();		
	}
	
	
	@Then("user is on login page")
	public void user_is_on_login_page() 
	{
		loginpg=new Loginpage(driver);
		loginpg.verifyContinueBtn(driver);
	}

}
