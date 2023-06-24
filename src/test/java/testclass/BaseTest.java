package testclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;
import pages.ProductPage;
import utility.ConfigReader;

public class BaseTest {
	
	public static WebDriver driver ;
	public HomePage homepage;
	
	public ProductPage productpage;
	@BeforeSuite
	public void initBrowser() throws IOException
	{
		ConfigReader cr = new ConfigReader();
		String browsername = cr.readConfig("browser");
		if(browsername.equals("Chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(browsername.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
			
		driver.manage().window().maximize();
		
		
		
		String url = cr.readConfig("testsiteurl");
		
		driver.get(url);
		
	}
	
	@BeforeClass
	public void createObject()
	{
		 homepage = new HomePage(driver);
		 productpage = new ProductPage(driver);
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
