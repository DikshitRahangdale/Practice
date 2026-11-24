package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.nio.channels.SelectableChannel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void testing() {

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");

		WebElement dropdownsElement = driver.findElement(By.cssSelector("select.form-control"));
		Select select = new Select(dropdownsElement);

		select.selectByValue("stud");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signInBtn"))).click();
		;

		// driver.findElement(By.id("signInBtn")).click();

		//wait.until(ExpectedConditions.alertIsPresent()).accept();

		// checkout button
		WebElement btElement = driver.findElement(By.cssSelector(".nav-link.btn.btn-primary"));
		wait.until(ExpectedConditions.visibilityOf(btElement)).click();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

	}

	@AfterClass
	public void afterClass() {
	}

}
