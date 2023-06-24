package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen {
	
	static ExtentReports extent; 
	public static ExtentReports extentReportGenerator()
	{
		String file = System.getProperty("user.dir")+"//reports//LivingsLiquidReport.html";
	
//	in this method we will just define the look and feel of the report
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(file);
		
		reporter.config().setTheme(Theme.STANDARD);
		
		reporter.config().setReportName("Revision Report");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Browser used", "Chrome");
		extent.setSystemInfo("Executed by", "Automation batch");
		extent.setSystemInfo("env", "SIT");
		
		return extent;
		
		
		
	
	}

}
