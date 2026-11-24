package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XpathAxis {
	WebDriver driver;

	@Test
	public void xpathaxes() {
		// 1 Child
		driver.findElement(By.xpath("//*[@class='form-group']/child::input[position()=1]")).sendKeys("Testing");

		// last()

		driver.findElement(By.xpath("//*[@class='form-group']/child::input[last()]")).sendKeys("8795467");

		// Parent

		String textString = driver.findElement(By.xpath("//*[@id='name']/parent::*")).getText();
		System.out.println(textString);

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}
}
