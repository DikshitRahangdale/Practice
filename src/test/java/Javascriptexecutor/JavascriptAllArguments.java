package Javascriptexecutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class JavascriptAllArguments {
	WebDriver driver;
	JavascriptExecutor js;

	@Test
	public void alarguments() {

		// click
		WebElement startButton = driver.findElement(By.xpath("//button[@name='start' or @name='stop']"));
		js.executeScript("arguments[0].click();", startButton);

		// Enter Input value
		WebElement name = driver.findElement(By.cssSelector("#name"));
		js.executeScript("arguments[0].value='Test';", name);

		// scroll Down by Pixel
		js.executeScript("window.scrollBy(0,800);");

		// Scroll down by Elements
		WebElement titles = driver.findElement(By.xpath("//*[text()='Slider']"));
		js.executeScript("arguments[0].scrollIntoView(true);", titles);

		// Scroll down till bottom
		js.executeScript("window.scrollTo(0,document.body.innerHeight);");

		// get Page title
		System.out.println(js.executeScript("return document.title;"));

		System.out.println(js.executeScript("return window.pageYOffset;"));
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--incognito");
		options.addArguments("start-maximized","--incognito","--headless=new");
		options.setAcceptInsecureCerts(true);
		
		driver = new ChromeDriver(options);

		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
