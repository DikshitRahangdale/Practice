package DatePicker;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class HandleDate {
	WebDriver driver;
	@FindBy(css = "#start-date")
	WebElement datePicker;

	@FindBy(xpath = "//*[@id=\"start-date\"]/following-sibling::span")
	WebElement separator;
	
	Actions mouse;

	@Test
	public void handleDate() {
		datePicker.click();

		Point location = separator.getLocation();
		System.out.println(location.getX() + " " + location.getY());
		
		mouse.moveByOffset(location.getX(), location.getY()).perform();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		mouse=new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}
