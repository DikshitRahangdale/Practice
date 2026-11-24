package Dropdowns;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;
import LeetCodeTest.LeetCodeLogin;

public class MultiSelectDropdown extends DriverSetups {
	@Test
	public void multiselect() {
		LeetCodeLogin log = new LeetCodeLogin(driver);
		log.login();

		WebElement selectElement = driver.findElement(By.xpath("//*[@href='/dropdowns' and text()=' Drop-Down ']"));
		js.executeScript("arguments[0].click()", selectElement);

		WebElement superhero = driver.findElement(By.id("superheros"));
		Select select = new Select(superhero);

		Boolean multiselecct = select.isMultiple();
		System.out.println("Is Dropdown Multiselected : " + multiselecct);

		List<WebElement> allOptions = select.getOptions();

		System.out.println("Total Options: " + allOptions.size());
		for (WebElement all : allOptions) {
			System.out.println(all.getText());
		}

		select.selectByVisibleText("Black Panther");
		select.selectByVisibleText("Captain Marvel");

		List<WebElement> selectoptions = select.getAllSelectedOptions();

		for (WebElement options : selectoptions) {
			System.out.println(options.getText());
		}

		select.deselectByVisibleText("Black Panther");
		System.out.println(select.getFirstSelectedOption().getText());

		select.deselectAll();
	}
}
