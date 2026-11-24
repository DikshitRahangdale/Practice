package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class practice {
	WebDriver driver;

	@Test
	public void f() {
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vishwa.ink757@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Nadsoft@12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@AfterTest
	public void afterTest() {
	}

}
