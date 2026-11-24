package SwitchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;
import LeetCodeTest.LeetCodeLogin;

public class SwitchToAlerts extends DriverSetups {
	@Test(priority = 1)
	public void simpleAlerts() throws InterruptedException {
		LeetCodeLogin leet = new LeetCodeLogin(driver);
		leet.login();

		WebElement alertElement = driver.findElement(By.cssSelector(".card-footer-item[href='/alert']"));

		js.executeScript("arguments[0].click()", alertElement);

		WebElement simpleAlert = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='accept' and text()='Simple Alert']")));
		simpleAlert.click();
		alert = driver.switchTo().alert();
		alert.accept();
		simpleAlert.click();
		alert.accept();

	}

	@Test(priority = 2)
	public void confirmationsAlert() {

		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.click();
		alert = driver.switchTo().alert();
		alert.accept();
		confirm.click();
		driver.switchTo().alert().dismiss();
		confirm.click();
		alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		System.out.println("Alert Message: " + alertMessage);
	}

	@Test(priority = 3)
	public void promptAlert() {
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		alert = driver.switchTo().alert();
		alert.accept();
		prompt.click();
		driver.switchTo().alert().dismiss();
		prompt.click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Hello Test");
		alert.accept();

	}

	@Test(priority = 4)

	public void modernAlert() {

		WebElement modernalertElement = driver.findElement(By.id("modern"));
		//wait.until(ExpectedConditions.elementToBeClickable(modernalertElement));
		// modernalertElement.click();
		js.executeScript("arguments[0].click();", modernalertElement);
		driver.findElement(By.xpath("//*[@aria-label='close' and @class='modal-close is-large']")).click();
	}
}
