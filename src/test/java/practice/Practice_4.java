package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

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

public class Practice_4 {
	WebDriver driver;
	Actions mouse;

	@Test(priority = 1)
	public void f() {
		driver.findElement(By.xpath("//div[@class='mt-1']/child::input")).sendKeys("sushantcricket85@gmail.com");
		driver.findElement(By.xpath("//*[@class='relative w-full flex mt-1']/child::input")).sendKeys("Shelake@0808");
		driver.findElement(By.xpath("//*[@class='relative w-full flex mt-1']/child::a")).click();
		driver.findElement(By.xpath("//*[@class='flex items-center']/child::input")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority = 2)
	public void course() throws InterruptedException {
//		Thread.sleep(5000);
//		WebElement coursElement = driver.findElement(By.cssSelector(
//				"div[class='hidden sidebar-bg-color md:flex md:flex-shrink-0 sidebar custom-sidebar desktopmenunavbar expand-nav sidebar-hovered'] div:nth-child(5) div:nth-child(2) div:nth-child(1) div:nth-child(1) a:nth-child(1)"));
//		mouse.moveToElement(coursElement).perform();
//		Thread.sleep(5000);
//		coursElement.click();
		WebElement coursElement = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Courses'])[2]")));

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
	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

}
