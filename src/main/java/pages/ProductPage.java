package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	@FindBy(xpath = "//*[@id='term-5']")
	private WebElement size;
	
	@FindBy(xpath = "//*[@id='term-362']")
	private WebElement types;
	
	@FindBy(xpath = "//*[text()='APPLY']")
	private WebElement applybutton;
	
	@FindBy(xpath = "//*[@class='card wbr-product-card h-100 rounded-20']")
	List<WebElement> productcard;
	
	
	@FindBy(xpath = "//*[text()='AMRUT INDIAN SINGLE MALT WHISKY EXCLUSIVE EDITION123']/parent::a")
	private WebElement product;
	
	@FindBy(xpath = "//*[text()='RESET']")
	private WebElement resetbutton;
	
	
	@FindBy(xpath = "//*[@id='ddlProductSortyBy']")
	private WebElement sortingdropdown;
	
	WebDriverWait wait;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}
	
	public int applyFilters()
	{

		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 
		 js.executeScript("arguments[0].click();", size);
		wait.until(ExpectedConditions.elementToBeClickable(types));
		js.executeScript("arguments[0].click();", types);
		wait.until(ExpectedConditions.elementToBeClickable(applybutton));
		js.executeScript("arguments[0].click();", applybutton);
		
		int count = productcard.size();
		
		return count;
		
		
	}
	
	public int resetFilters()
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", resetbutton);
		int count = productcard.size();
		
		return count;
	}
	
	
	public void clickOnProduct()
	{
		wait.until(ExpectedConditions.elementToBeClickable(product));
		product.click();
	}
	
	public void sortingByValue(String value)
	{
		Select sel = new Select(sortingdropdown);
		
		sel.selectByVisibleText(value);
	}
	
	
	
}
