package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SwitchTOFrmaes {
	WebDriverWait wait;
	WebDriver driver;

	@Test
	public void frames() {
		WebElement frame_pagElement = driver
				.findElement(By.xpath("//a[@class='card-footer-item' and text()=' Inner HTML ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", frame_pagElement);

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='fname' and @placeholder='Enter name']"))
				.sendKeys("Dikshit Rahangdale");
		WebElement namElement = driver.findElement(By.xpath("//input[@name='lname' and @placeholder='Enter email']"));
		namElement.sendKeys("Nitesh Rahangdale");

		driver.switchTo().frame(1);

		driver.findElement(By.cssSelector("input[name='email'][placeholder='Enter email']")).sendKeys("ABC@gmail.com");

		driver.switchTo().parentFrame();
		namElement.clear();
		driver.switchTo().defaultContent();
		driver.navigate().back();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/test");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
