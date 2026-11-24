package CheckboxRadio;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ChecckboxElements extends DriverSetup {
	@Test
	public void checkbox() {
		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> allcheckbox = driver
				.findElements(By.xpath("//*[contains(@class,'form-check-inline')]//input[@type='checkbox']"));
		List<WebElement> labels = driver.findElements(
				By.xpath("//*[contains(@class,'form-check-inline')]//input[@type='checkbox']/following-sibling::*"));

		for (int i = 0; i < allcheckbox.size(); i++) {
			String day = labels.get(i).getText();

			System.out.println(day + " : " + allcheckbox.get(i).isSelected());

			if (day.contains("day")) {
				allcheckbox.get(i).click();

			}
		}

		System.out.println("After Selection: ");

		for (int i = 0; i < allcheckbox.size(); i++) {
			String day = labels.get(i).getText();

			System.out.println(day + " : " + allcheckbox.get(i).isSelected());
		}

	}

}
