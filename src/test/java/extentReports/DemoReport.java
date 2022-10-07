package extentReports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoReport {

	ExtentReports extentReports;
	ExtentHtmlReporter htmlReport;
	ExtentTest test;
	@BeforeSuite
	public void setUP()
	{
		htmlReport = new ExtentHtmlReporter("C:\\Users\\Monika\\eclipse-workspace\\MavenProjectPractice\\reports\\report.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReport);
	}
	@Test
	public void test1() throws Exception {
		
		 test = extentReports.createTest("My first test","Sample data");
		 test.log(Status.INFO, "This stop shows usage of log(status,details)");
		 test.info("This step shows usage of info(details)");
		 //test.fail("details");
		// test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("base64"));
		 test.addScreenCaptureFromPath("screenshot.png");
	}
	@AfterSuite
	public void tearDown() {
		extentReports.flush();
	}
	
}
