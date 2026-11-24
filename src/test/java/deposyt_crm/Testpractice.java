package deposyt_crm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Testpractice {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void f() {
		WebElement messagesElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//i[contains(@class,'flex-shrink-0 mr-3 nad2')])[2]")));
		messagesElement.click();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://app.deposyt.com/index.php?m=account");
		driver.findElement(By.id("email")).sendKeys("tarsier60796@aminating.com");
		driver.findElement(By.id("password")).sendKeys("Nadsoft@1234");
		driver.findElement(By.cssSelector("button.w-full")).click();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
