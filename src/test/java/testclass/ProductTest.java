package testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
	
	
	@Test(priority = 3)
	public void validateFilter()
	{
	int count = productpage.applyFilters();
	
	Assert.assertEquals(count, 1);
	}
	
	@Test(priority = 4)
	public void resetFilterValidation() {
		
		int cardcount = productpage.resetFilters();
		
		boolean isgreater = cardcount>1;
		
		Assert.assertEquals(isgreater, true);
			
	}
	
	@Test(priority = 5)
	public void sortingFilter() throws InterruptedException
	{
		productpage.sortingByValue("Price High to Low");
		
		Thread.sleep(2000);
				
		productpage.sortingByValue("Name Z - A");
	}

	@Test(priority = 6)
	public void navToProduct()
	{
		productpage.applyFilters();
		
		productpage.clickOnProduct();
	}
	
	
}
