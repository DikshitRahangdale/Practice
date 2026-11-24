package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Extentreports {
	public WebDriver driver;

	@Test(priority = 1)
	public void loginApplication() {
		String userna = "yogeshmpandit17@gmail.com";
		String passwo = "Nadsoft@1234";
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		username.clear();
		password.clear();

		username.sendKeys(userna);
		password.sendKeys(passwo);
		driver.findElement(By.cssSelector("button.deposytssologinbtn")).click();

	}

	@Test(priority = 2)
	public void courseOpen() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://app.release.deposyt.com/index.php?m");
	}

	@Test(dependsOnMethods = { "courseOpen" }, priority = 3)
	public void createNewCourse() {
		System.out.println("Creaet New Course Button");
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.release.deposyt.com/index.php?m=account");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
