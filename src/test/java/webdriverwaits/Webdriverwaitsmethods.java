package webdriverwaits;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Webdriverwaitsmethods {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void webdrivermethods() {
		driver.findElement(By.id("email")).sendKeys("movab39962@lxbeta.com");
		driver.findElement(By.id("password")).sendKeys("Nadsoft@1234");

		driver.findElement(By.xpath(
				"//*[@id='remember-me']/parent::div/parent::div/following-sibling::div[position()=1]/child::button"))
				.click();

		// click on profile image

		driver.findElement(By.id("topuserprofile")).click();

		// this code give NosuchElementException

//		 WebElement logoutbtnElement =
//		 driver.findElement(By.cssSelector(".logout-btn.flex"));

		// Wait methods
//		WebElement logoutbtnElement = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logout-btn.flex")));
//		logoutbtnElement.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".logout-btn.flex"))).click();

		// clicking on Terma & Condition Link

		driver.findElement(By.xpath("//*[text()='Terms and Conditions']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
