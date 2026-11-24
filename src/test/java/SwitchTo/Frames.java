package SwitchTo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Frames {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void hamdleframes() {

		driver.switchTo().frame("firstFr");

		driver.findElement(By.xpath("//*[@placeholder='Enter name']")).sendKeys("Test");
		driver.findElement(By.xpath("//*[text()='Last Name']/parent::div/descendant::input"))
				.sendKeys("Testing@gmail.com");

		// switch to Another frames
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Email']/following-sibling::div/input"))).sendKeys("Test@gmail.com");

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
