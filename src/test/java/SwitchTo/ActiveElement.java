package SwitchTo;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ActiveElement extends DriverSetup {
	@Test
	public void activeelement() {

		driver.get("https://www.google.com/");

		WebElement active = driver.switchTo().activeElement();

		System.out.println("Active Elemnts: " + active.getTagName());
	}
}
