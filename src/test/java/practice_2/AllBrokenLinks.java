package practice_2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.util.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class AllBrokenLinks {
	WebDriver driver;
	SoftAssert softAssert;

	@Test
	public void handleBrokenLinks() throws URISyntaxException, IOException {

		List<WebElement> allLinksElement = driver.findElements(By.tagName("a"));
		System.out.println("Total Links:->" + allLinksElement.size());
		int totalvalidLink = 0;
		int totalinvalidLink = 0;
		int totalEmptyLinks = 0;

		for (WebElement links : allLinksElement) {
			String link = links.getAttribute("href");

			if (link == null || link.isEmpty()) {
				totalEmptyLinks++;
				continue;
			}

			URI uri = new URI(link);
			URL url = uri.toURL();

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();

			if (connection.getResponseCode() >= 400) {
				totalvalidLink++;
				System.out.println("Valid Link-->" + url.toString());

			} else {
				totalinvalidLink++;
				System.out.println("Invalid Link-->" + url.toString());
			}

		}
		System.out.println("Total Valid Links:->" + totalvalidLink);
		System.out.println("Total InValid Links:->" + totalinvalidLink);
		System.out.println("Total Empty Links:->" + totalEmptyLinks);
	}

	@Test(priority = 1)
	public void handleShadowDom() {
		softAssert = new SoftAssert();
		softAssert.assertEquals(true, false, "Test case failed");
		WebElement shadowhead = driver.findElement(By.cssSelector("#shadow_host"));
		SearchContext shadow = shadowhead.getShadowRoot();
		shadow.findElement(By.cssSelector("input[type='text']")).sendKeys("Tersting");

	}

	@BeforeClass
	public void beforeClass() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new", "--incognito", "--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
		softAssert.assertAll();
	}

}
