package com.selenium.parameterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParameterTest {
	WebDriver driver;
	@Test
	@Parameters({"url","emailID"})
	public void setUp(String url, String emailID)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monika\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(url);

		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(emailID);
		driver.findElement(By.id("login-signin")).click();
		
	}
}
