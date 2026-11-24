package SwitchTo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class SwitchToAlerts2 extends DriverSetup {
	Alert alert;

	@Test(priority = 1)
	public void Simplealerts() {
		LeetCodeLogin leet = new LeetCodeLogin(driver);
		leet.login();

		WebElement alertOptions = driver.findElement(By.cssSelector(".card-footer-item[href='/alert']"));
		js.executeScript("arguments[0].click();", alertOptions);

		driver.findElement(By.cssSelector("#accept")).click();

		alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.cssSelector("#accept")).click();
		alert = driver.switchTo().alert();
		System.out.println("Alert Text : " + alert.getText());
		alert.accept();

	}

	@Test(priority = 2)
	public void confirmationAlert() {
		WebElement confirm = driver.findElement(By.cssSelector("#confirm"));
		confirm.click();
		alert = driver.switchTo().alert();
		alert.accept();

		confirm.click();
		alert = driver.switchTo().alert();
		alert.dismiss();

	}

	@Test(priority = 3)
	public void promptAlert() {
		WebElement prompt = driver.findElement(By.cssSelector("#prompt"));
		prompt.click();
		alert = driver.switchTo().alert();
		alert.accept();

		prompt.click();
		alert = driver.switchTo().alert();
		alert.dismiss();

		prompt.click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Dikshit");
		alert.accept();

		prompt.click();
		alert = driver.switchTo().alert();
		System.out.println("Prompt Alert: " + alert.getText());
		alert.accept();

	}

}
