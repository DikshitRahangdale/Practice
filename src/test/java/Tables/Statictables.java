package Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class Statictables extends DriverSetup {
	@Test
	public void simpletables() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();

		WebElement tableoption = driver.findElement(By.cssSelector(".card-footer-item[href='/advancedtable']"));

		js.executeScript("arguments[0].click();", tableoption);

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='advancedtable']/tbody/tr"));

		System.out.println("Table Header: ");

		List<WebElement> header = driver.findElements(By.xpath("//*[@id='advancedtable']/thead/tr"));

		for (WebElement head : header) {
			System.out.println(head.getText());
		}

		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

	}
}
