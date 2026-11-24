package Locators;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByXpathMethods {

	public static void main(String... args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");

		// 1 ) Text Methods

		driver.findElement(By.xpath("//button[text()='START']")).click();

		driver.findElement(By.xpath("//label[text()='Sunday']")).click();

		// 2) and & or Operator

		driver.findElement(By.xpath("//input[@id='name' and @placeholder='Enter Name']")).sendKeys("Testing");

		driver.findElement(By.xpath("//button[@name='start' or @name='stop']")).click();

		// 3)contains methods

		driver.findElement(By.xpath("//*[contains(@placeholder, 'Enter Na')]")).clear();

		driver.findElement(By.xpath("//*[contains(@placeholder, 'Enter EM')]")).sendKeys("Test");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(), 'START') or contains(text(), 'STOP')]")).click();

		// 4) starts-with() method

		driver.findElement(By.xpath("//button[starts-with(@id, 'alert')]")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.xpath("//button[starts-with(@id, 'confirm')]")).click();
		alert.dismiss();

		// 5) Normilize space

		driver.findElement(By.xpath("//button[normalize-space()='Prompt Alert']")).click();
		alert.accept();
		driver.close();

	}
}
