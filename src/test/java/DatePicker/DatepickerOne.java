package DatePicker;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DatepickerOne {
	WebDriver driver;

	@Test
	public void f() {

		String expectedMonth = "November";
		String expectedYear = "2028";
		String expectedDate = "17";

		driver.findElement(By.id("datepicker")).click();

		while (true) {
			String actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			String actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

			if (actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear)) {
				break;
			}

			driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click(); // Next Arrow
		}

		// dates

		List<WebElement> alldates = driver.findElements(By.cssSelector(".ui-datepicker-calendar tbody tr td"));

		for (WebElement dates : alldates) {
			if (dates.getText().equals(expectedDate)) {
				dates.click();
			}
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
