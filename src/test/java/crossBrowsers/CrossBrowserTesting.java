package crossBrowsers;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class CrossBrowserTesting {
	WebDriver driver;

	@Parameters("Browser")
	@Test
	public void f(String Browser) {
		System.out.println("Browser Name:-" + Browser);
	}

	@Parameters("Browser")
	@BeforeClass
	public void beforeClass(String Browser) {

		switch (Browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;

		case "Edge":
			driver = new EdgeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Browser Does not Match");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
