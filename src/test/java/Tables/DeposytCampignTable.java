package Tables;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import deposyt_crm.DeposytLogin;

public class DeposytCampignTable extends DriverSetup {
	@Test
	public void campaingtable() {

		DeposytLogin login = new DeposytLogin(driver);
		login.release();
		wait.until(ExpectedConditions.urlContains("https://app.release.deposyt.com"));

		driver.navigate().to("https://app.release.deposyt.com/index.php?m=campaigns"); // OPen Campaing Module

		// Get all tble data

		while (true) {
			List<WebElement> pagenumbers = driver
					.findElements(By.xpath("//nav[@id='navbar-Campaigns']/child::div[position()=2]/child::*"));

			for (int i = 1; i <= pagenumbers.size(); i++) {
				List<WebElement> campaingntable = driver.findElements(By.xpath("//*[@id='admintable0']/tbody/tr/td"));

				for (WebElement rows : campaingntable) {
					System.out.println(rows.getText());
				}

				if (pagenumbers.get(i).isDisplayed()) {
					pagenumbers.get(i).click();
				} else {
					break;
				}

			}
		}

	}
}
