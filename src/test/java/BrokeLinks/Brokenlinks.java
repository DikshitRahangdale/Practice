package BrokeLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Brokenlinks extends DriverSetup {
	@Test
	public void links() throws IOException {
		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> allinks = driver.findElements(By.tagName("a"));
		int link=0;
		int broken=0;
		int linknotpresent=0;

		for (WebElement links : allinks) {
			String hreflinks = links.getAttribute("href");

			if (hreflinks == null || hreflinks.isEmpty()) {
				System.out.println("Link is Not Presnt");
				linknotpresent++;
				continue;

			}
			try {
				URL url = new URL(hreflinks);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.connect();

				if (connection.getResponseCode() >= 400) {
					System.out.println("Broken Link--> " + hreflinks);
					broken++;
				} else {
					System.out.println("Link Not Broken--> " + hreflinks);
					link++;
				}
			} catch (Exception e) {

			}
		}
		System.out.println("Valid Links: "+link);
		System.out.println("Broken Links: "+broken);
		System.out.println("Link not Present : "+linknotpresent);
		
	}
}
