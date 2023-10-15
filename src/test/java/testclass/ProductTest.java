package testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class ProductTest extends TestNGListeners{
	
	
	@Test(priority = 3)
	public void validateFilter()
	{
	int count = productpage.applyFilters();
	
	test.info("get the number of product");
	
	Assert.assertEquals(count, 1);
	
	test.info("validated product count");
	}
	
	@Test(priority = 4)
	public void resetFilterValidation() {
		
		int cardcount = productpage.resetFilters();
		
		test.info("filter reset");
		
		boolean isgreater = cardcount>1;
		
		Assert.assertEquals(isgreater, true);
		
		test.info("successfully validated that filter has been reset");
			
	}
	
	@Test(priority = 5)
	public void sortingFilter() throws InterruptedException
	{
		productpage.sortingByValue("Price High to Low");
		
		test.info("Sorting the product from high to low");
		
		Thread.sleep(2000);
				
		productpage.sortingByValue("Name Z - A");
		
		test.info("Sorting the product from A-Z");
	}

	@Test(priority = 6, enabled = false)
	public void navToProduct()
	{
		productpage.applyFilters();
		
		test.info("Reset the filter");
		
		productpage.clickOnProduct();
		
		test.info("Clicked on the product");
	}
	
	
}
