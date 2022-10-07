package extentWithScreenShots;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyClass {
	
	WebDriver driver;
	ExtentHtmlReporter htmlRepoter;
	ExtentTest test;
	ExtentReports extentReport;
	
	@BeforeTest
	public void setReport() {
		htmlRepoter = new ExtentHtmlReporter("C:\\Users\\Monika\\eclipse-workspace\\MavenProjectPractice\\reports\\ExtentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlRepoter);
		
		extentReport.setSystemInfo("Name", "DatA");
		extentReport.setSystemInfo("envirement", "asaada");
		
	}
	
	@AfterTest
	public void endReport()
	{
		extentReport.flush();
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\drivers_New\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/");
		System.out.println("Chrome browser launch");
	}
	
	@Test(priority = 1)
	public void siteTitleTest()
	{
		test=extentReport.createTest("TitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Learn Selenium with Best Practices and Examples | Selenium Easy123");
	}
/*	@Test(priority = 2)
	public void siteLogoTest()
	{
		test=extentReport.createTest("LogTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Learn Selenium with Best Practices and Examples | Selenium Easy123");
	}*/
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case Failed is "+result.getName());
			test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
			String screenshotPath = MyClass.getScreenshot(driver, result.getName());
			//test.log(Status.FAIL,((MediaEntityBuilder) test.addScreenCaptureFromPath(screenshotPath)).build());
			
			//test.log(Status.FAIL, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
			test.log(Status.FAIL,"", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			
			//test.log(Status.FAIL, (Markup) test.addScreencastFromPath(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passed is "+result.getName());
		}
	driver.quit();
		
	}
	
	public static String getScreenshot(WebDriver driver, String screenshot) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/FailedTestScreenShot/"+screenshot+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
