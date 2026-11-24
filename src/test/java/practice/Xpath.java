package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Xpath {
	WebDriver driver;

	@Test
	public void Login() {
		String actual = driver.getTitle();
		String expectedString = "Dashboard :: deposyt.com";
		// Assert.assertEquals(actual, expectedString);

		WebElement countElement = driver
				.findElement(By.xpath("//*[@id='filteredleads' and contains(@class, 'text-23')]"));
		System.out.println("Total Count= " + countElement.getText());
		countElement.click();

		WebElement totalcountElement = driver.findElement(By.xpath("//*[text()='Total: ']/span"));
		// Assert.assertEquals(countElement.getText(),
		// totalcountElement.getText(),"Count not Match");

		totalcountElement.click();

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pavanpatilpp1512@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Patil@123456789");
		driver.findElement(By.xpath("//*[@id='remember-me'][@name='autologin_d']")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[text()='Role: Admin']")).click();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
