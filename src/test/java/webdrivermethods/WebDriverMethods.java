package webdrivermethods;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class WebDriverMethods {
	WebDriver driver;

	@Test(priority = 1)
	public void getTitles() {
		String expectedTitle = "Automation Testing Practice";

		String actualTitle = driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle, "Page Title is Not matching");
	}
     @Test(priority=2)
	public void getcurrentURL() {
		String expectedURL = "https://testautomationpractice.blogspot.com/";

		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(expectedURL, actualURL, "Page URL is Not matching");
	}

     @Test(priority=3)
	public void getpageSources() {
		String pagesourceString = driver.getPageSource();
		System.out.println("Page Source: " + pagesourceString);
	}

     @Test(priority = 4)
	public void getcurrentwindowhandle() {
		driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-input")).sendKeys("Indian Missile");
		driver.findElement(
				By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']/parent::span/following-sibling::span/input"))
				.click();

		String currentWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//*[@id='wikipedia-search-result-link'][position()=1]")).click();

		Set<String> allopenwindowID = driver.getWindowHandles();
		System.out.print("Total OPen Tab: " + allopenwindowID.size());

		for (String windowID : allopenwindowID) {
			if (currentWindow.equals(windowID)) {
				driver.switchTo().window(windowID);
				break;
			}

		}

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
