package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ClickandHold extends DriverSetup {
	@Test
	public void clickhold() {
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement hold = driver.findElement(By.xpath("//*[text()='Point Me']"));

		Actions mouseActions = new Actions(driver);

		mouseActions.clickAndHold(hold).perform();

		mouseActions.release().perform();
	}
}
