package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class InputValue extends DriverSetup {
	@Test
	public void f() {
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement inputElement = driver.findElement(By.id("name"));

		js.executeScript("arguments[0].value='Test';", inputElement);

		System.out.println(inputElement.getAttribute("value"));
	}
}
