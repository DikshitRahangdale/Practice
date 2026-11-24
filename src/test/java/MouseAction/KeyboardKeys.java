package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class KeyboardKeys extends DriverSetup {
	@Test
	public void keypboardKeys() throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.id("field1")).click();

		Actions mouse = new Actions(driver);
		mouse.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // Select ALL

		mouse.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform(); // Copy Text

		WebElement filed2 = driver.findElement(By.id("field2"));
		filed2.click();

		mouse.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform(); // Paste Copy Text

		Thread.sleep(1000);

		System.out.println(filed2.getAttribute("value"));

		mouse.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // Select ALl text

		mouse.keyDown(Keys.DELETE).keyUp(Keys.DELETE).perform(); // Delte All Enter text
		
		System.out.println("After Delete: "+filed2.getAttribute("value"));

	}
}
