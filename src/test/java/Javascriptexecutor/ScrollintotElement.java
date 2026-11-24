package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollintotElement extends DriverSetup {
	@Test
	public void f() {
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement buttonElement = driver.findElement(By.xpath("//*[@name='start' or @name='stop']"));

		js.executeScript("arguments[0].scrollIntoView(true);", buttonElement);
	}
}
