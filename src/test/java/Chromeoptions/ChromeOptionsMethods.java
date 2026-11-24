package Chromeoptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class ChromeOptionsMethods {
	WebDriver driver;
	ChromeOptions options;

	@Test
	public void f() {
		System.out.print("Test" + driver.getCurrentUrl());
	}

	@BeforeClass
	public void beforeClass() {
		options = new ChromeOptions();
		options.addArguments("--headless=new", "--incognito", "--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
