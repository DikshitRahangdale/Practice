package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Practice_2 {
	WebDriver driver;
	Actions mouse;
	WebDriverWait wait;

	@Test(priority = 1)
	public void login() {

		driver.findElement(By.cssSelector("input#email")).sendKeys("sushantcricket85@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Shelake@0808");

		WebElement checkbox = driver.findElement(By.cssSelector("#remember-me"));
		System.out.println(checkbox.isDisplayed());
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());

		checkbox.click();

		System.out.println(checkbox.isSelected());

		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	@Test(priority = 2)

	public void courses() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//a[@class='flex flex-auto hover:text-white']//span[@class='menu-title' and normalize-space()='Courses']")
		));
		element.click();

	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
		mouse = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	
	public void afterTest() {
		//driver.close();
	}

}
