package Tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class DynamicTable extends DriverSetup {
	@Test
	public void dynamic() {
		driver.get("https://practice.expandtesting.com/dynamic-table");
		List<WebElement> allrows = driver
				.findElements(By.xpath("//*[contains(@class,'table table-striped')]/tbody/tr"));

		for (WebElement rows : allrows) {
			System.out.println(rows.getText());
		}
	}
}
