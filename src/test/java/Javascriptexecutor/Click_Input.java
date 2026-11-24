package Javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Click_Input extends DriverSetup {
	@Test
	public void clickElement() {
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement buttonElement = driver.findElement(By.xpath("//*[@name='start'  or @name='stop']"));
		js.executeScript("arguments[0].click();", buttonElement);

		WebElement nmae = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].value='Hello';", nmae);
		System.out.println(nmae.getAttribute("value"));

		WebElement emailElement = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].value='hello@gmail.com';", emailElement);

		WebElement phonElement = driver.findElement(By.id("phone"));
		js.executeScript("arguments[0].value='876678787878';", phonElement);

		js.executeScript("arguments[0].click();", buttonElement);
	}
}
