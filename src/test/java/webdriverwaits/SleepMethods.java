package webdriverwaits;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SleepMethods {
	WebDriver driver;

	@Test
	public void methods() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("movab39962@lxbeta.com");
		driver.findElement(By.id("password")).sendKeys("Nadsoft@1234");

		driver.findElement(By.xpath(
				"//*[@id='remember-me']/parent::div/parent::div/following-sibling::div[position()=1]/child::button"))
				.click();

		// click on profile image

		driver.findElement(By.id("topuserprofile")).click();

		// clicking on Logout btn

		// Thread.sleep(3000);

		driver.findElement(By.cssSelector(".logout-btn.flex")).click();

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
		driver.close();
	}

}
