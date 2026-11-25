package GreenKart;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions mouse;
	public SoftAssert soft;
	public JavascriptExecutor js;

	@BeforeClass
	public void beforeClass() {
		DriverManager.setDriver(new ChromeDriver());
		DriverManager.getDriver().manage().window().maximize();
		wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		mouse = new Actions(DriverManager.getDriver());
		soft = new SoftAssert();
		js = (JavascriptExecutor) DriverManager.getDriver();
		DriverManager.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@AfterClass
	public void afterClass() {
		DriverManager.getDriver().quit();
		soft.assertAll();
		DriverManager.removeDriver();

	}

}
