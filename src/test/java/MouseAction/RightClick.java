package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class RightClick extends DriverSetup {
	@Test
	public void rightclick() {
		driver.get("https://demoqa.com/buttons");

		Actions mouse = new Actions(driver);
		try {
			boolean message = driver.findElement(By.id("rightClickMessage")).isDisplayed();
			System.out.print(message);
		} catch (Exception e) {
			System.out.println("Message not display");
		}

		WebElement right_click = driver.findElement(By.id("rightClickBtn"));

		mouse.contextClick(right_click).perform();

		boolean after_message = driver.findElement(By.id("rightClickMessage")).isDisplayed();
		System.out.print(after_message);
	}
}
