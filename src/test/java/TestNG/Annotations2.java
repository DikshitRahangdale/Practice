package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Annotations2 {
	@Test
	public void secondclassMethod() {
		System.out.println("THis is Second Class Method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Second Class BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is Second Class AfterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Second Class BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is Second Class Afterclass");
	}

	@BeforeTest
	public void secondclasBeforetest() {
		System.out.println("This is Second class Beforetest");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("This is Second class  AfterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is second class BeforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This is second Class AfterSuite");
	}

}
