package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BrokensLinks {
	WebDriver driver;
	Actions mouse;
	WebDriverWait wait;

	@Test(enabled = false)
	public void handleBrokenLinks() throws URISyntaxException {

		List<WebElement> allAtags = driver.findElements(By.tagName("a"));
		int totalEmptyLinks = 0;
		int totalBrokenLinks = 0;
		int totalValidLinks = 0;

		for (WebElement anchor : allAtags) {
			String urlString = anchor.getAttribute("href");

			if (urlString == null || urlString.isEmpty()) {
				System.out.println("URl is Empty or Null-->" + anchor.getText());
				totalEmptyLinks++;
				continue;
			}

			URI uri = new URI(urlString);

			try {
				URL url = uri.toURL();
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.connect();

				if (urlConnection.getResponseCode() >= 400) {
					System.out.println("Broken Links-->" + anchor.getText() + "-->" + urlString);
					totalBrokenLinks++;
				} else {
					System.out.println("Not Broken Links-->" + anchor.getText() + "-->" + urlString);
					mouse.keyDown(Keys.CONTROL).click(anchor).keyUp(Keys.CONTROL).perform();
					totalValidLinks++;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		System.out.println("Total Links-->" + allAtags.size());
		System.out.println("Total Blank Links-->" + totalEmptyLinks);
		System.out.println("Total Broken Links-->" + totalBrokenLinks);
		System.out.println("Total Valid Links-->" + totalValidLinks);

		Set<String> alltabs = driver.getWindowHandles();
		System.out.println("Total Open Tabs or Windows-->" + alltabs.size());
		wait.until(ExpectedConditions.numberOfWindowsToBe(18));

	}

	@Test(priority = 1)
	public void watingMethods() {
		driver.navigate().to("https://www.hyrtutorials.com/p/waits-demo.html");

		driver.findElement(By.id("btn1")).click();
		// WebElement input1 =
		// driver.findElement(By.xpath("//*[@id='btn1']/following-sibling::h3/input"));
		//WebElement input1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btn1']/following-sibling::h3/input")));
		WebElement input1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btn1']/following-sibling::h3/input")));
	
		input1.sendKeys("Test");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mouse = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
