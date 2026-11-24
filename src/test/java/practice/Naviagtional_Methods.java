package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Naviagtional_Methods {
	WebDriver driver;

	@Test
	public void navigate() {
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("https://www.deposyt.com/terms/");

	}

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tarsier60796@aminating.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("R4!zN1#tV6%");
		driver.findElement(By.xpath("//*[@id='remember-me' and @name='autologin_d']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
