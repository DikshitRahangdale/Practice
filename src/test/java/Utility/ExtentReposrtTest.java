package Utility;

import org.testng.annotations.Test;

public class ExtentReposrtTest {
	@Test(priority=1)
	public void testingwithPass() {
		System.out.println("Pass Test cases");
	}

	@Test(priority=2)
	public void testingPass() {
		System.out.println("Pass Test Case");
	}

	@Test(priority=3)
	public void testingFail() {
		boolean flag = true;
		if (!flag)
			System.out.println("Failed test cases");
	}

	@Test(dependsOnMethods = "testingFail")
	public void skippTestCase() {
	}

	@Test(dependsOnMethods = "skippTestCase")
	public void dependsMethod() {
	}

	@Test(priority = 4)
	public void failtestcases() {
		if (2 % 2 != 0)
			System.out.println("Failed test cases");
	}

}
