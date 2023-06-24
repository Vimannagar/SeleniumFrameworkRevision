package extentlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testclass.BaseTest;
import utility.ScreenShots;

public class TestNGListeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	
public static	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test case started: "+result.getName());
		
		 test = extent.createTest(result.getName());
		
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed: "+result.getName());
		test.log(Status.PASS, "Test case passed");
	}


	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: "+result.getName());
		
		test.fail(result.getThrowable());
		
		ScreenShots scr = new ScreenShots();
		
		try {
			
			test.addScreenCaptureFromPath(scr.captureScreenshot(driver, result.getName()));
			
		} catch (IOException e) {
			System.out.println("Exception arrived while taking screenshot");
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: "+result.getName());
		
		test.log(Status.SKIP, "Test case got skipped");
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
		
		extent.flush();
		
	}
	
	
	
	
	

}
