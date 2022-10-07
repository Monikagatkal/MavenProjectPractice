package com.selenium.annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
		WebDriver driver;
		//@BeforeMethod
		@BeforeClass
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\drivers_New\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
		}
		@Test
		public void getTitleTest()
		{
			String title = driver.getTitle();
			System.out.println(title);
		}
		@Test
		public void getLogoTest() {
			boolean b = driver.findElement(By.id("logo")).isDisplayed();
			System.out.println("Logo is Present: "+b);
		}
		@Test
		public void linkTest()
		{
			boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
			System.out.println("Link is present: "+b);
		}
		
		public void tearDown()
		{
			driver.quit();
		}
}
