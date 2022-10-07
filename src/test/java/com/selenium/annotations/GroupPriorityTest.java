package com.selenium.annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupPriorityTest {
	WebDriver driver;
	//@BeforeMethod
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	@Test(priority = 1,groups = "title")
	public void getTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority = 5,groups = "logo")
	public void getLogoTest() {
		boolean b = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println("Logo is Present: "+b);
	}
	@Test(priority = 2,groups = "link")
	public void linkTest()
	{
		boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println("Link is present: "+b);
	}
	@Test(priority = 3,groups = "link")
	public void test1() {
		System.out.println("Test1");
	}
	@Test(priority = 6,groups = "title")
	public void test2() {
		System.out.println("Test2");
	}
	@Test(priority = 4,groups = "link")
	public void test3() {
		System.out.println("Test3");
	}
	
	public void tearDown()
	{
		driver.quit();
	}

}
