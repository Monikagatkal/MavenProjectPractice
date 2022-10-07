package com.selenium.annotations;

import org.testng.annotations.Test;

public class DependsOnMethodsTestNG {
	@Test
	public void loginPage()
	{
		System.out.println("LoginPage...");
		//int a =2/0;
		
	}
	@Test(dependsOnMethods = "loginPage")
	public void searchPage()
	{
		System.out.println("SearchPage...");
		int a =2/0;
	}
	@Test(dependsOnMethods = "searchPage")
	public void homePage()
	{
		System.out.println("HomePage...");
	}
	
}
