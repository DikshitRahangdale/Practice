package SwitchTo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class SwitchToWindow extends DriverSetup {
	@Test
	public void windowhandle() {
		LeetCodeLogin logi = new LeetCodeLogin(driver);
		logi.login();

		WebElement tabs = driver.findElement(By.cssSelector(".card-footer-item[href='/window']"));
		js.executeScript("arguments[0].click();", tabs);

		driver.findElement(By.cssSelector("#home")).click();

		driver.findElement(By.cssSelector("#multi")).click();

		Set<String> allWindow = driver.getWindowHandles();
		String parentwindow = "";

		for (String windows : allWindow) {
			driver.switchTo().window(windows);
			String title = driver.getTitle();

			if (title.contains("Windows")) {
				parentwindow = windows;
			} else {
				driver.close();
			}

		}
		driver.switchTo().window(parentwindow);
	}
}
