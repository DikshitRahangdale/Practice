package SwitchTo;

import java.util.Set;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;
import LeetCodeTest.LeetCodeLogin;

public class SwitchToNewWindow extends DriverSetups {

	@Test(priority = 1)
	public void newWindow() {
		LeetCodeLogin leet = new LeetCodeLogin(driver);
		leet.login();

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.selenium.dev/");

		Set<String> windowCout = driver.getWindowHandles();
		System.out.println("Total Open Window:" + windowCout.size());

	}

	@Test(priority = 2)
	public void newTab() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.pexels.com/");
		Set<String> tabCout = driver.getWindowHandles();
		System.out.println("Total OpenTabs:" + tabCout.size());
	}

}
