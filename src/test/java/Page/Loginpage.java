package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.testng.*;

public class Loginpage 
{

	@FindBy(xpath="//input[@autocomplete='new-password']")
	private WebElement mobno;
	
	@FindBy(xpath="//div[.='CONTINUE']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='errorContainer']")
	private WebElement errorMsg;
	
	public Loginpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void enterMobNo(String no)
	{
		mobno.sendKeys(no);
	}
	
	public void clickContinue()
	{
		continueBtn.click();
	}
	
	public void verifyContinueBtn(WebDriver driver)
	{
		WebDriverWait w= new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(continueBtn));
				
	}
	
	public void verifyErrorMsg()
	{
		try 
		{
			if(errorMsg.isDisplayed())
			{
				System.out.println("Error Message is displayed");
			}
		} 
		catch (Exception e) 
		{	
			Assert.assertTrue(errorMsg.isDisplayed());
		}
	}
	
	
	
}

