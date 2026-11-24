package SwitchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;
import LeetCodeTest.LeetCodeLogin;

public class SwitchToShadowroot extends DriverSetups {
	@Test
	public void shadowroot() {
		LeetCodeLogin logi = new LeetCodeLogin(driver);
		logi.login();

		WebElement domElement = driver.findElement(By.cssSelector(".card-footer-item[href='/shadow']"));
		js.executeScript("arguments[0].click();", domElement);
		WebElement host = driver.findElement(By.id("open-shadow"));
		SearchContext shadow = host.getShadowRoot();

		WebElement firstName = shadow.findElement(By.cssSelector("#fname"));
		firstName.sendKeys("Dikshit");


		
	}
}
