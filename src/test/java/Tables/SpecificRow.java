package Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class SpecificRow extends DriverSetup {
	@Test
	public void specificdata() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();
		WebElement tableoption = driver.findElement(By.cssSelector(".card-footer-item[href='/advancedtable']"));

		js.executeScript("arguments[0].click();", tableoption);
           
		String data = driver.findElement(By.xpath("//*[@id='advancedtable']/tbody/tr[5]/td[4]")).getText();
		

		List<WebElement> table = driver.findElements(By.xpath("//*[@id='advancedtable']/tbody/tr"));

		for (WebElement tab : table) {
			if (tab.getText().contains(data)) {
				System.out.print(tab.getText());
			}
		}
	}
}

