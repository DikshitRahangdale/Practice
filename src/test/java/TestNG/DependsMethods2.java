package TestNG;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependsMethods2 {
	WebDriver driver;
	@Test
	public void test1() {
		
		System.out.println("First Method");
		driver.get("ww.google.com");
	}

	@Test(dependsOnMethods = "test1")
	public void test2() {
		System.out.println("second Method");
	}

	@Test(dependsOnMethods = "test2")
	public void test3() {
		System.out.println("Third Method");
	}

	@Test(dependsOnMethods = "test3")
	public void test4() {
		System.out.println("Fourth Method");
	}

	@Test
	public void test5() {
		System.out.println("fifth Method");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		driver=new ChromeDriver();
	}
}
