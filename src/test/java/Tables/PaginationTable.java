package Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;
import LeetCodeTest.LeetCodeLogin;

public class PaginationTable extends DriverSetup {
	@Test
	public void pagination() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();
		WebElement tableoption = driver.findElement(By.cssSelector(".card-footer-item[href='/advancedtable']"));

		js.executeScript("arguments[0].click();", tableoption);

		boolean next = true; 

		while (next) {
			List<WebElement> table = driver.findElements(By.xpath("//*[@id='advancedtable']/tbody/tr"));
			for (WebElement allrow : table) {
				 System.out.println(allrow.getText());

				// Print Specific row
//				if (allrow.getText().contains("Roehampton University of Surrey")) {
//					System.out.println(allrow.getText());
//				}
			}

			WebElement nextbutton = driver.findElement(By.cssSelector("button.dt-paging-button.next"));
			String nextdissabl = nextbutton.getAttribute("class");

			if (!nextdissabl.contains("disabled")) {
				js.executeScript("arguments[0].click();", nextbutton);

			} else {
				next = false;
			}
		}

	}
}
