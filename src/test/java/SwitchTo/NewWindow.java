package SwitchTo;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class NewWindow extends DriverSetup {
	@Test
	public void newwindow() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();

		driver.switchTo().newWindow(WindowType.TAB);

		driver.switchTo().newWindow(WindowType.WINDOW);

	}
}
