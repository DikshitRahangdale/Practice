package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class HddenDropdowns extends DriverSetup {
	@Test
	public void hidden() {
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()=\"Login\"]")).click();

		driver.findElement(By.xpath("//span[text()='Directory']/ancestor::li")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")))
		    .click();

		//driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")).click();

		List<WebElement> usElements = driver
				.findElements(By.xpath("//*[contains(@class, 'oxd-select-dropdown')]/div/span"));

		for (WebElement user : usElements) {
			System.out.print(user.getText());
		}
	}
}
