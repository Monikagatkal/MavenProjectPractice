package com.selenium.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationUsedEx {
	
	@Test
	public void test() {
		System.out.println("test Perform in this Method");
	}
	@Test
	public void test1() {
		System.out.println("test1 Perform in this Method");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("beforeMethod perform in this method");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("beforeClass perform in this method");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClass perform in this method");
	}
	
	@BeforeSuite    
	public void beforeSuite()
	{
		System.out.println("beforeSuite perform in this method");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("-----------------beforeTest--------------------------------------");
	}
	@AfterTest	
	public void afterTest1()
	{
		System.out.println("-----------------afterTest1--------------------------------------");
	}
	/*@AfterGroups
	public void afterGroups()
	{
		System.out.println("@AfterGroups perform in this method");
	}*/
	@BeforeGroups
	public void beforeGroups()
	{
		System.out.println("@@BeforeGroups perform in this method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod perform in this method");
	}

}
