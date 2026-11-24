package SwitchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class ShadowRoot extends DriverSetup {
	@Test
	public void shadowroot() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();

		WebElement dom = driver.findElement(By.cssSelector(".card-footer-item[href='/shadow']"));
		js.executeScript("arguments[0].click();", dom);
		
		WebElement shadow=driver.findElement(By.cssSelector("#open-shadow"));
		SearchContext host=shadow.getShadowRoot();
		
		host.findElement(By.cssSelector("#fname")).sendKeys("Dikshit");
		

	}
}
