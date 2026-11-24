package practice1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ShadowRoot {
	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 2)
	public void testShadowRoot() {
		WebElement hostElement = driver.findElement(By.cssSelector("#shadow_host"));
		SearchContext rootContext = hostElement.getShadowRoot();

		rootContext.findElement(By.cssSelector("input[type='text']")).sendKeys("Test");
		driver.switchTo().newWindow(WindowType.TAB);

	}

	@Test(priority = 1)
	public void checkboxes() {
		driver.findElement(By.id("sunday")).click();
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("sunday"), true));

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
