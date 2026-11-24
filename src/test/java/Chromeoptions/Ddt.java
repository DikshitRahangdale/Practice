package Chromeoptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class Ddt {
	WebDriver driver;

	@Test(dataProvider = "forms")
	public void testData(String name) {
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(name);

	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@DataProvider(name = "forms")
	public Object[] tstdata() {
		return new Object[] { "Test1", "Test2", "Test3", "Test4", "Test1" };
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
