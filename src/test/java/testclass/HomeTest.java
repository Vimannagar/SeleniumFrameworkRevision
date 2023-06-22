package testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest
{
	
	@Test(priority = 1)
	public void validateTitle()
	{		
		String title = homepage.getTitleOfPage();
		
		String expected = "Mumbai";
		
		boolean ispresent = title.contains(expected);	

		Assert.assertEquals(ispresent, true);
		
		
	}
	
	@Test(priority = 2)
	public void navToSingleMalt()
	{
		homepage.clickOnSpirit();
		homepage.navToProductPage();
	}

}
