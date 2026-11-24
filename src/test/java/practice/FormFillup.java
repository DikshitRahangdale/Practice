package practice;

import java.nio.channels.SelectableChannel;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class FormFillup extends DriverSetup {
	@Test
	public void fillforms() {
		driver.get("https://testautomationpractice.blogspot.com/");

		// 1) INput Field
		driver.findElement(By.cssSelector("#name")).sendKeys("Test");
		driver.findElement(By.id("email")).sendKeys("text@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Enter Phone' and @id='phone']")).sendKeys("996633665544");
		driver.findElement(By.xpath("//*[@id='textarea' and @class='form-control']"))
				.sendKeys("Pune,Mumbai,Maharastra");

		// 2) checkbox

		WebElement male = driver.findElement(By.cssSelector("#male"));
		System.out.println("rADIO bUTTON Selected: " + male.isSelected());

		if (!male.isSelected()) {
			male.click();
		} else {
			System.out.print("Male Checkbox alerady Selected");
		}

		// 3) Checkbox

		List<WebElement> days = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@class,'form-check')]"));

		for (WebElement day : days) {
			if (!day.isSelected()) {
				day.click();
			}
		}

		// 4) Dropdowns

		WebElement country_Dropdowns = driver.findElement(By.cssSelector("#country"));
		Select countries = new Select(country_Dropdowns);
		List<WebElement> allcountry = countries.getOptions();

		System.out.println("All Options: ");

		for (WebElement country : allcountry) {
			System.out.println(country.getText());
		}

		countries.selectByValue("india");

		System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());

		// 5) calendar

		String date = "17";
		String month = "November";
		String year = "2002";

		driver.findElement(By.id("datepicker")).click();

		while (true) {
			String actual_year = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText();
			String actual_month = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText();

			if (actual_month.equals(month) && actual_year.equals(year)) {
				break;
			} else {
				driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-w")).click();
			}

		}

		// Date

		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td"));

		for (WebElement day : dates) {
			String da = day.getText();
			if (da.equals(date)) {
				day.click();
			}
		}

		String selected_Date = driver.findElement(By.id("datepicker")).getAttribute("value");
		System.out.println("Selected Date: " + selected_Date);
	}

}
