package extentlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

import testclass.BaseTest;
import utility.ScreenShots;

public class TestNGListeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test case started: "+result.getName());
		
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed: "+result.getName());
	}


	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: "+result.getName());
		
		ScreenShots scr = new ScreenShots();
		
		try {
			scr.captureScreenshot(driver, result.getName());
		} catch (IOException e) {
			System.out.println("Exception arrived while taking screenshot");
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: "+result.getName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Test tag started : "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test tag finished : "+context.getName());
		
	}
	
	
	
	
	

}
