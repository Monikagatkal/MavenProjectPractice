package extentReports;




import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport {
	public ExtentReports extent;
	ExtentHtmlReporter htmlreport;
	public ExtentTest test;
	public ChromeDriver driver;
	@BeforeSuite
	public void startReport() {
		htmlreport = new ExtentHtmlReporter("C:\\Users\\Monika\\eclipse-workspace\\MavenProjectPractice\\reports\\abc.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		htmlreport.config().setDocumentTitle("Title of the Report Comes here ");
		// Name of the report
		htmlreport.config().setReportName("Name of the Report Comes here ");
		// Dark Theme
		htmlreport.config().setTheme(Theme.STANDARD);

	}
	
	@Test
	public void demoReportPass() {
		test=extent.createTest("demoReportPass");
		Assert.assertTrue(true);
		//Assert.assertEquals("Moni", "Monika");
		test.log(Status.PASS, "Assert Pass as condition is True");

	}
	@Test
	public void demoReportFail() {
		test=extent.createTest("demoReportFail");
		Assert.assertTrue(false);
		test.log(Status.FAIL, "Assert Fail as condition is True");
	}

	@Test
	public void firstTestCase() {
		test=extent.createTest("firstTestCase");
		System.out.println("im in first test case from ClassTwo Class");
	}

	@Test
	public void secondTestCase() {
		test=extent.createTest("secondTestCase");
		System.out.println("im in second test case from ClassTwo Class");
		Assert.fail("Failing this Test");
	}

	@Test
	public void thirdTestCase() {
		test=extent.createTest("thirdTestCase");
		System.out.println("im in third test case from ClassTwo Class");
	}

	@Test
	public void fourthTestCase() {
		test=extent.createTest("fourthTestCase");
		System.out.println("im in fourth test case from ClassTwo Class");
	}

	@Test
	public void fifthTestCase() {
		test=extent.createTest("fifthTestCase");

		System.out.println("im in fifth test case from ClassTwo Class");
	}
	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
}
