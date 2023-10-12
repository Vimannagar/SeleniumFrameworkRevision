package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {
	
	
	public String captureScreenshot(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		
		String path = "F:\\Desktop\\VimanNagar\\May 21\\SeleniumBasicsRevision\\screenshots\\amazon.png";
		
		
		File destinationpath = new File(path);
		

		
		FileHandler.copy(screenshot, destinationpath);
		
		byte[] byteArray = IOUtils.toByteArray(new FileInputStream(path));
		
		return Base64.getEncoder().encodeToString(byteArray);
	}
	
	public static void main(String[] args) throws IOException {
		
//	WebDriver driver = new ChromeDriver();
//	
//	
//	driver.manage().window().maximize();
//	
//	driver.get("https://www.amazon.in/");
//	
//	TakesScreenshot ts = (TakesScreenshot)driver;
//	
//	File screenshot = ts.getScreenshotAs(OutputType.FILE);
//	
////	String path = "F:\\Desktop\\VimanNagar\\May 21\\SeleniumBasicsRevision\\screenshots\\amazon.png";
//	
//	
//	String path = System.getProperty("user.dir")+"\\screenshots\\testimage.png";
//	File destinationpath = new File(path);
//	
//	FileHandler.copy(screenshot, destinationpath);
	
	
	File path1 = new File(".//screenshots//.png");
	
	System.out.println(path1);
		
		
	}
	
	
	
	
	

}
