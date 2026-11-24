package Dropdowns;

import java.nio.channels.SelectableChannel;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;
import LeetCodeTest.LeetCodeLogin;

public class SimpleDropdown extends DriverSetups {
	@Test
	public void selectDropdown() {
		LeetCodeLogin log = new LeetCodeLogin(driver);
		log.login();

		WebElement selectElement = driver.findElement(By.xpath("//*[@href='/dropdowns' and text()=' Drop-Down ']"));
		js.executeScript("arguments[0].click()", selectElement);

	 	WebElement fruitsdropdown = driver.findElement((By.id("fruits")));
		fruitsdropdown.click();

		Select fruits = new Select(fruitsdropdown);

		// 1) getOptions() method
		List<WebElement> allfruits = fruits.getOptions();

		for (WebElement frts : allfruits) {
			System.out.println(frts.getText());
		}

		// 2) selectByindex()

		fruits.selectByIndex(1);
		// 3) getFirstSelectedOptions()

		String selectFruit = fruits.getFirstSelectedOption().getText();
		System.out.println("selected Fruits:" + selectFruit);

		// 4) selectBYvalue

		fruits.selectByValue("0");
		String selectedvalue = fruits.getFirstSelectedOption().getText();
		System.out.println("selected Fruits:" + selectedvalue);

		// 5) select BY visible text
		fruits.selectByVisibleText("Mango");
		String frtString = fruits.getFirstSelectedOption().getText();
		System.out.println(frtString);

		// 6) is multiselected
		Boolean multiselect = fruits.isMultiple();
		System.out.println("is Multiselected: " + multiselect);

		// 7) deselect by visible text

		//fruits.deselectByVisibleText("Mango");

		// 8) deselect by Value
		fruits.selectByValue("0");
		fruits.selectByValue("0");
		

	}
}
