package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollintoView extends DriverSetup {
	@Test
	public void scrollview() {
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement element = driver.findElement(By.xpath("//*[text()='Point Me']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
