package brokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrokenLinkWithReportScreenshot {
	WebDriver driver;
	ExtentHtmlReporter htmlRepoter;
	ExtentTest test;
	ExtentReports extentReport;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\drivers_New\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");

		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	
	@BeforeTest
	public void setReport() {
		htmlRepoter = new ExtentHtmlReporter("C:\\Users\\Monika\\eclipse-workspace\\MavenProjectPractice\\reports\\BrokenLink.html");
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

	@Test
	public void checkLink() throws Exception {
	test = extentReport.createTest("Link Verify");
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	for(int i=0;i<links.size();i++)
	{
		WebElement ele = links.get(i);
		String url = ele.getAttribute("href");

		URL link = new URL(url);

		HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();

		httpConn.connect();
		int resCode = httpConn.getResponseCode();

		if(resCode >= 400)
		{
			System.out.println(url + " --is Broken Link");
			
		}
		else
		{
			System.out.println(url + " --is Valid Link");
		}
	}
	}


}

