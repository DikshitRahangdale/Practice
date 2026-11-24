package practice_2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class BrokenLinks {
	WebDriver driver;
	ChromeOptions options;

	@Test
	public void testAllbrokenLinks() throws URISyntaxException, IOException {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement li : allLinks) {
			String url = li.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("Url is Not present");
				continue;
			}

			URI uri = new URI(url);
			URL actualurl = uri.toURL();

			HttpURLConnection connecct = (HttpURLConnection) actualurl.openConnection();
			connecct.connect();

			if (connecct.getResponseCode() >= 400) {
				System.out.println("URL is Broken--->" + url);

			} else {
				System.out.println("URL is valid--->" + url);
			}

		}

	}

	@BeforeClass
	public void beforeClass() {
		options = new ChromeOptions();
		options.addArguments("--headless=new", "--start-maximized", "--incognito");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
