package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SpiceJet {
	WebDriver driver;

	@Test
	public void test() {

		driver.findElement(By.xpath("//div[text()='From']")).click();

		java.util.List<WebElement> allairposrts = driver.findElements(By.xpath(
				"//div[text()='Cities']/parent::div/following-sibling::div/child::div/descendant::div[position()=2]"));

		System.out.println("Total Airports: " + allairposrts.size());

		for (WebElement airports : allairposrts) {
			String cities = airports.getText();
			System.out.println(cities);

//			if (cities.contains("Agra")) {
//				airports.click();
			// break;
		}

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
