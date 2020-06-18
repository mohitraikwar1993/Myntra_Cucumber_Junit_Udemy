package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage 
{
	@FindBy(xpath="//span[.='Profile']")
	private WebElement profile;
	
	@FindBy(xpath="//a[.='login / Signup']")
	private WebElement login;
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void moveToProfile(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(profile);
		a.perform();
		//System.out.println(profile);
		//profile.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	
}
