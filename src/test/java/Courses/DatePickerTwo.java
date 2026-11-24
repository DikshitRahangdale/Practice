package Courses;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DatePickerTwo {
	WebDriver driver;

	@Test
	public void f() {
		
	

		String expectedMonth = "Nov";
		String expectedYear = "2028";
		String expectedDate = "17";

		driver.findElement(By.cssSelector("input#txtDate[name='SelectedDate']")).click();

		
			
			// select Month

			WebElement monthdropdown = driver.findElement(By.cssSelector(".ui-datepicker-month"));
			Select month = new Select(monthdropdown);
			month.selectByVisibleText(expectedMonth);

			// Select year
			WebElement yeardropdown = driver.findElement(By.cssSelector(".ui-datepicker-year"));
			Select year = new Select(yeardropdown);
			year.selectByVisibleText(expectedYear);

           
		// Select Dates
		List<WebElement> alldates = driver.findElements(By.cssSelector(".ui-datepicker-calendar tbody tr td"));

		for (WebElement date : alldates) {
			if (date.getText().equals(expectedDate)) {
				date.click();
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
