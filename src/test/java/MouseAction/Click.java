package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Click extends DriverSetup {
	@Test
	public void mouseClick() {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement buttonElement = driver.findElement(By.xpath("//button[@name='start' or @name='stop']"));

		Actions mouse = new Actions(driver);
		mouse.click(buttonElement).perform();

	}
}
