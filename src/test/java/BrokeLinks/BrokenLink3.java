package BrokeLinks;

import org.testng.annotations.Test;

import ch.qos.logback.core.status.StatusUtil;

import org.testng.annotations.BeforeTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class BrokenLink3 {
	WebDriver driver;

	@Test
	public void broeknlink() {
		int linknotPresent = 0;
		int broken = 0;
		int notBroken = 0;

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + allLinks.size());

		for (WebElement links : allLinks) {
			String link = links.getAttribute("href");

			if (link == null || link.isEmpty()) {
				System.out.println("Link is Not Present:->" + link);
				linknotPresent++;
				continue;
			}

			try {

				URL url = new URL(link);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.connect();

				if (connection.getResponseCode() >= 400) {
					System.out.println("Broken Link:->" + link);
					broken++;
				} else {
					System.out.println("Not Broken Link:->" + link);
					notBroken++;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		System.out.println("Link is Not present:->" + linknotPresent);
		System.out.println("Broken Link:->" + broken);
		System.out.println("Not Broken Link:->" + notBroken);

	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://practice-automation.com/broken-links/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
