package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollPage extends DriverSetup {
	@Test
	public void scrollbypixel() throws InterruptedException {

		driver.get("https://testautomationpractice.blogspot.com/");

		// 1) scroll By pixel
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);

		System.out.println(js.executeScript("return window.scrollY;"));

		WebElement title = driver.findElement(By.xpath("//*[text()='Automation Testing Practice']"));
		Thread.sleep(2000);

		// 2)Scroll till elements
		js.executeScript("arguments[0].scrollIntoView(true);", title);

		// 3) Scroll till Bottom

		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}
}
