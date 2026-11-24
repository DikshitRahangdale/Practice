package Javascriptexecutor;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AllJavascriptMethods {
	WebDriver driver;
	JavascriptExecutor js;

	@Test
	public void allmethods() {

		// click on Elements
		WebElement button = driver.findElement(By.xpath("//button[@name='start' or @name='stop']"));
		js.executeScript("arguments[0].click();", button);

		// Enter Text in input
		WebElement name = driver.findElement(By.cssSelector("#name"));
		js.executeScript("arguments[0].value='Testing';", name);
		System.out.println("Enter Text : " + name.getAttribute("value"));

		// Scroll down page till pixel
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,600)");

		// Scroll till Elements
		WebElement titles = driver.findElement(By.xpath("//*[text()='Pagination Web Table']"));
		js.executeScript("arguments[0].scrollIntoView(true);", titles);

		// Scroll till bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		// Scroll till Top
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
		js.executeScript("arguments[0].scrollIntoView(true);", titles);

		// get Page Titles
		String pagetitles = js.executeScript("return document.title;").toString();
		System.out.println("Page Titles: " + pagetitles);

		// get Window loaction
		Long yoffset = (long) js.executeScript("return window.pageYOffset;");
		Long xoffset = (long) js.executeScript("return window.pageXOffset;");
		System.out.println(yoffset + "\n" + xoffset);

		js.executeScript("arguments[0].scrollIntoView(true);", name);

		js.executeScript("arguments[0].click(true);", button);

		js.executeScript("arguments[0].value='Testin r';", name);
		
		js.executeScript("window.scrollBy(0,100);");
		
		js.executeScript("window.scrollTo(0,document.body.innerHeight);");

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
