package BrokeLinks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class BrokenLink1 {
	WebDriver driver;

	@Test
	public void f() {
		int totallinks = 0;
		int linknotpresent = 0;
		int broken = 0;
		int notBroken = 0;

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + allLinks.size());

		for (WebElement link : allLinks) {
			String singlink = link.getAttribute("href");
			if (singlink == null || singlink.isEmpty()) {
				System.out.println("Link is Not Present");
				linknotpresent++;
				continue;
			}

			try {

				URL url = new URL(singlink);
				HttpURLConnection httpsurl = (HttpURLConnection) url.openConnection();
				httpsurl.connect();

				if (httpsurl.getResponseCode() >= 400) {
					System.out.println("BrokenLink1 Links: " + singlink);
					broken++;
				} else {
					System.out.println("Not Broken Link: " + singlink);
					notBroken++;
				}
			} catch (Exception e) {

			}

		}
		System.out.println("Links Not Present: " + linknotpresent);
		System.out.println("Broken Links: " + broken);
		System.out.println("Not broken Links: " + notBroken);
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window.maximized");
		driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
