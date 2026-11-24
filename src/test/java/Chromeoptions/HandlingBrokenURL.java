package Chromeoptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HandlingBrokenURL {
	WebDriver driver;
	WebDriverWait wait;
	ChromeOptions options;

	@Test
	public void broeknLinks() throws URISyntaxException, IOException {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement links : allLinks) {
			String link = links.getAttribute("href");
			if (link == null || link.isEmpty()) {
				continue;
			}

			URI uri = new URI(link);
			URL url = uri.toURL();
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.connect();

			if (connect.getResponseCode() >= 400) {
				System.out.println("Broken LInks-->:" + link);
				break;
			} else
				System.out.println("workings LInks-->:" + link);

		}

	}

	@Test(dataProvider = "testData")
	public void test(String name) {
		driver.findElement(By.id("name")).sendKeys(name);
	}

	@BeforeClass
	public void beforeClass() {
		options = new ChromeOptions();
		options.addArguments("--headless", "--incognito");
		driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@DataProvider(name = "testData")
	public Object[] testData() {
		return new Object[] {  "Tets" , "test", "Tets"  };
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
