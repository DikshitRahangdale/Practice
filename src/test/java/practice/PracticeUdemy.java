package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PracticeUdemy {
	WebDriver driver;
	WebDriver edgeDriver;
	WebDriver firefixDriver;

	@Test
	public void test() {
		Assert.assertEquals("https://www.pexels.com/", driver.getCurrentUrl(), "URl Does not Match ");

		edgeDriver.navigate().to("https://www.pexels.com/");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		edgeDriver = new EdgeDriver();
		firefixDriver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.pexels.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
