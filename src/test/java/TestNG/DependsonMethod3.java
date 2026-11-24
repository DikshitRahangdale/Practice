package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DependsonMethod3 {
	WebDriver driver;

	@Test(groups = "test3")
	public void test1() {
		System.out.println("Test1");
		// driver.get("ww.google.com");
	}

	@Test(dependsOnMethods = "test1")
	public void test2() {
		System.out.println("Test2");
	}

	@Test(dependsOnMethods = "test2")
	public void test3() {
		System.out.println("Test3");
	}

	@Test(dependsOnGroups = "test3")
	public void test4() {
		System.out.println("Test4");
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.release.deposyt.com/index.php?m=account");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
