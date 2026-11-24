package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollintoElement extends DriverSetup {
	@Test
	public void scroll() {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement inputElement = driver.findElement(By.cssSelector("#field2"));

		js.executeScript("arguments[0].scrollIntoView(true);", inputElement);
	}
}
