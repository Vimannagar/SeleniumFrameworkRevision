package testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class HomeTest extends TestNGListeners
{
	
	@Test(priority = 1)
	public void validateTitle()
	{		
		String title = homepage.getTitleOfPage();
		
		test.info("Fetched the title of page");
				
		String expected = "Mumbai";
		
		boolean ispresent = title.contains(expected);	

		Assert.assertEquals(ispresent, true);
		
		test.info("Title of page has been validated");
		
		
	}
	
	@Test(priority = 2)
	public void navToSingleMalt()
	{
		homepage.clickOnSpirit();
		
		test.info("Clicked on single malt");
		
		homepage.navToProductPage();
		
		test.info("Navigated to product page");
	}

}
