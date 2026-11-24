package ShadowDOM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ShadowDom1 {
	WebDriver driver;

	@Test
	public void f() {

		WebElement shadoHost = driver.findElement(By.cssSelector("#shadow_host"));
		SearchContext shadowroot = shadoHost.getShadowRoot();
		shadowroot.findElement(By.cssSelector("input[type='text']")).sendKeys("ShadowRoot");

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
