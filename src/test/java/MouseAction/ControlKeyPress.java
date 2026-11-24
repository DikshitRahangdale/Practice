package MouseAction;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ControlKeyPress extends DriverSetup {
	@Test
	public void contropress() throws InterruptedException {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement linkElement = driver.findElement(By.linkText("Home"));

		Actions mouseActions = new Actions(driver);

		mouseActions.keyDown(Keys.CONTROL).click(linkElement).keyUp(Keys.CONTROL).perform(); // Open the link in new tab using Control+click on Link

		Set<String> totalwindows = driver.getWindowHandles();

		System.out.println("Total OPen Window: " + totalwindows.size());
		Thread.sleep(2000);

	}
}
