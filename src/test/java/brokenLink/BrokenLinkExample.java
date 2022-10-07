package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkExample {
	WebDriver driver;
	String url = "";
	public HttpURLConnection huc;
	public int respCode=200;
	String link = "https://www.seleniumeasy.com/";
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\drivers_New\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/");
		System.out.println("Chrome browser launch");
	}

	@Test
	public void findLink()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();
		int count=0;
		while(it.hasNext()){

			url = it.next().getAttribute("href");

			System.out.println(url);
			count++;

		}
		System.out.println(count);
		/*
		if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			
		}

		if(!url.startsWith(link)){
			System.out.println("URL belongs to another domain, skipping it.");
		}

		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			if(respCode >= 400){
				System.out.println(url+" is a broken link");
			}
			else{
				System.out.println(url+" is a valid link");
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}