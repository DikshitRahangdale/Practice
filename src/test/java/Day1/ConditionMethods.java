package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ConditionMethods {
	WebDriver driver;

	@Test
	public void conditionalMethods() {
		WebElement nameField = driver.findElement(By.id("name"));
		WebElement headingElement = driver.findElement(By.xpath("//*[@id='header-inner']/descendant::h1"));
		WebElement maleradiobutton = driver.findElement(By.cssSelector("#male"));
		System.out.println("INput Field Enables: " + nameField.isEnabled());
		System.out.println("INput Field Display: " + nameField.isDisplayed());
		System.out.println("Main Heading display: " + headingElement.isDisplayed());
		System.out.println("Male radio Button selected: " + maleradiobutton.isSelected());

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
