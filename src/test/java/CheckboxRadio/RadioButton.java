package CheckboxRadio;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class RadioButton extends DriverSetup {
	@Test
	public void radio() {
		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> radioElements = driver.findElements(
				By.xpath("//*[contains(@class,'form-check-inline')]//input[@type='radio']/following-sibling::*"));
		
		List<WebElement> radio = driver.findElements(
				By.xpath("//*[contains(@class,'form-check-inline')]//input[@type='radio']"));

		for (WebElement gender : radioElements) {
			System.out.println(gender.isSelected());

			if (gender.getText().contains("Male")) {
				gender.click();

			}
		}
		for (WebElement gender : radioElements) {
			System.out.println(gender.getText() + ":-" + gender.isSelected());
		}

	}
}
