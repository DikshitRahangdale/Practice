package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ClickonElement extends DriverSetup {
	@Test
	public void clickonelement() {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement button = driver.findElement(By.xpath("//button[@name='start']"));

		js.executeScript("arguments[0].click();", button);

	}
}
