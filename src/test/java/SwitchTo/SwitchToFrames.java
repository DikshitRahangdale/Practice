package SwitchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class SwitchToFrames extends DriverSetup {
	@Test
	public void frame() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();

		WebElement frameOptionElement = driver.findElement(By.cssSelector(".card-footer-item[href='/frame']"));
		js.executeScript("arguments[0].click()", frameOptionElement);

		driver.switchTo().frame("firstFr");
		WebElement firstname = driver
				.findElement(By.cssSelector("input.input.ng-untouched.ng-pristine.ng-invalid[name='fname']"));
		firstname.sendKeys("Test");
		driver.findElement(By.cssSelector("input.input.ng-untouched.ng-pristine.ng-invalid[name='lname']"))
				.sendKeys("Testing");
 
		driver.switchTo().frame(1);
		driver.findElement(By.cssSelector("input.input[name='email']"));

		driver.switchTo().parentFrame();
		firstname.clear();

	}
}
