package extentReports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoReportWithTestNG {

	ExtentHtmlReporter htmlReporter; 
	ExtentReports extent;
	ChromeDriver driver;
	
	@BeforeSuite
	public void setUP()
	{
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\Monika\\eclipse-workspace\\MavenProjectPractice\\reports\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void beforeTest()
	{
		//String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\drivers_New\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome browser launch");
	}
	@Test
	public void test1() throws Exception
	{
		
		ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
	
		driver.get("https://www.google.com/");
		test1.pass("Navigated to google.com");
		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");
		test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test1.addScreenCaptureFromPath("screenshot.png");
	}
	@Test
	public void test2() throws Exception
	{
		ExtentTest test2 = extent.createTest("MyFirstTest", "Sample description");
		test2.log(Status.INFO, "This step shows usage of log(status, details)");
		test2.info("This step shows usage of info(details)");
		test2.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test2.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
