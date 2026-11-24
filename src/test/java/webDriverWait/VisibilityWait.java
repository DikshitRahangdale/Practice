package webDriverWait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class VisibilityWait {
	WebDriverWait wait;
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.id("start")).click();

	//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("start")));

		WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
		System.out.println(text.getText());
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
