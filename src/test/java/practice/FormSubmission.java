package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Driver.DriverSetup;

public class FormSubmission extends DriverSetup {
	@Test
	public void inputfield() {
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.id("name")).sendKeys("Automation Testing");
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		WebElement mobile = driver.findElement(By.id("phone"));
		js.executeScript("arguments[0].value='8899878787';", mobile);

		driver.findElement(By.id("textarea")).sendKeys("Mumbai,Pune,Nagpur");
	}
}
