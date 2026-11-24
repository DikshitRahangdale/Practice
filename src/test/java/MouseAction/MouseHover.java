package MouseAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class MouseHover extends DriverSetup {
	@Test
	public void mousehover() {
		driver.get("https://testautomationpractice.blogspot.com/");

		Actions mouseActions = new Actions(driver);

		WebElement pointmeButton = driver.findElement(By.xpath("//*[text()='Point Me']"));

		mouseActions.moveToElement(pointmeButton).perform();

		List<WebElement> dropdown_options = driver
				.findElements(By.xpath("//*[text()='Point Me']/following-sibling::div/a"));

		for (WebElement option : dropdown_options) {
			System.out.println(option.getText());
		}

	}
}
