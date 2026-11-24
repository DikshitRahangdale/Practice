package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;

public class Groups1 {
	WebDriver driver;
	
	@Test(groups = "Smoke")
	public void tst1() {
		System.out.println("Smoke Testing");
	}
     
	@BeforeGroups()
	@Test(groups = "Sanity")
	public void test2() {
		System.out.println("Sanity Testing");
	}

	@Test(groups = "Regression")
	public void test3() {
		System.out.println("Regression Testing");

	}


}
