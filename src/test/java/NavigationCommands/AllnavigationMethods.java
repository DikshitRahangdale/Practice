package NavigationCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AllnavigationMethods {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void navigationalmethods() {
		// refresh Page
		driver.navigate().refresh();

		// Back method
		driver.findElement(By.xpath("//*[text()='Terms and Conditions']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		driver.navigate().back();

		// Forward Methods

		driver.navigate().forward();
		String pageurlString = driver.getCurrentUrl();

		System.out.println("Current Open Page URl: " + pageurlString);

		// navigate.to method

		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		String pageurlString2 = driver.getCurrentUrl();

		System.out.println("Current Open Page URl: " + pageurlString2);
	}

	@BeforeTest
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.manage().window();
		wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		driver.get("https://app.deposyt.com/index.php?m=account");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
