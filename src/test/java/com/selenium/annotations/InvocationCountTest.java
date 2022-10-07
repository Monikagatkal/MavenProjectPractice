package com.selenium.annotations;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount = 10)
	public void addition() {
		int a =10;
		int b = 20;
		int c = a+b;
		int i=0;
		
		System.out.println("Addition is : "+c);
	}
}
