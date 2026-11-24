package BrokeLinks;

import org.testng.annotations.Test;
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

public class BrokenLink2 {
	WebDriver driver;

	@Test
	public void f() {
		int urlnotPresent = 0;
		int broken = 0;
		int notBroken = 0;

		List<WebElement> alllinksElements = driver.findElements(By.tagName("a"));
		System.out.println("Total Links:=>" + alllinksElements.size());

		for (WebElement links : alllinksElements) {
			String link = links.getAttribute("href");

			if (link == null || link.isEmpty()) {
				System.out.println("URl is Not Present");
				urlnotPresent++;
				continue;

			}

			try {
				URL url = new URL(link);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.connect();

				if (conn.getResponseCode() >= 400) {
					System.out.println("Link is Broken:->" + link);
					broken++;
				} else {
					System.out.println("Link is Not Broken:->" + link);
					notBroken++;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		System.out.println("Total Link Not Present:=>" + urlnotPresent);
		System.out.println("Total Broken Links:=>" + broken);
		System.out.println("Total Not Broken Links:=>" + notBroken);
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
