package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	@FindBy(xpath = "(//*[normalize-space(text())='SPIRITS'])[2]")
	private WebElement spirit;
	
	@FindBy(xpath = "//*[text()='Single Malt']")
	private WebElement singlemalt;
	
	@FindBy(xpath = "//*[@id='onesignal-slidedown-cancel-button']")
	private WebElement imiss;
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}
	
	
	public void clickOnSpirit() {
		
		wait.until(ExpectedConditions.visibilityOf(imiss));
		imiss.click();
		
		spirit.click();
	}
	
	public void navToProductPage()
	{
		singlemalt.click();
		
		
	}
	
	public String getTitleOfPage()
	{
		String titleofpage = driver.getTitle();
		
		return titleofpage;
	}


}
