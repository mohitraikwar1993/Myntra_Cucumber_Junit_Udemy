package StepDefinations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{

	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method executed");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("After Method executed");
	}
}
