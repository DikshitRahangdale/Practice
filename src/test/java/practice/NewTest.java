package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver driver;

	@Test
	public void allGetMethods() {

		String titleString = driver.getTitle();
		System.out.println("Title of the Page: " + titleString);

		String urlString = driver.getCurrentUrl();
		System.out.println("URL of the Page: " + urlString);

		String pagesourceString = driver.getPageSource();
		// System.out.println("Pagesource: " + pagesourceString);

		String windowID = driver.getWindowHandle();
		System.out.println("Window ID: " + windowID);

		driver.findElement(By.xpath("//*[text()='Terms and Conditions']")).click();

		String newWindowTitle = driver.getTitle();
		System.out.println("New Window Title: " + newWindowTitle);

		// driver.switchTo().window(windowID);

		String previouswWindowTitle = driver.getTitle();
		System.out.println("Old Window Title: " + previouswWindowTitle);

		Set<String> ids = driver.getWindowHandles();

		for (String id : ids) {
			if (driver.getCurrentUrl().contains("terms")) {
				driver.close();
			}

		}
		driver.switchTo().window(windowID);

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

}
