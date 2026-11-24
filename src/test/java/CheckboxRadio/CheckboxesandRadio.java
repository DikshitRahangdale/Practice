package CheckboxRadio;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class CheckboxesandRadio {
	WebDriver driver;
	static int selectedcheckboxes = 0;

	@Test(priority = 1)
	public void checkboxes() {

		List<WebElement> allcheckboxes = driver.findElements(By.xpath("//*[@id='sunday']/ancestor::div[2]//input"));

		// select first 3 checkboxes

		for (int i = 0; i < allcheckboxes.size(); i++) {

			if (i % 2 == 0)
				allcheckboxes.get(i).click();
		}

		for (int i = 0; i < allcheckboxes.size(); i++) {

			if (allcheckboxes.get(i).isSelected() == true)
			{
				allcheckboxes.get(i).click();
			selectedcheckboxes++;
			}
		}

		System.out.println("Total Selected Checkboxes: " + selectedcheckboxes);

	}

	@Test(priority = 2)

	public void radiobutton() {

		List<WebElement> allradio = driver.findElements(By.xpath("//*[@for='gender']/parent::div/child::div/input"));

		allradio.get(0).click();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
