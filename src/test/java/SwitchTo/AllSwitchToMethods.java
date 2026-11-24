package SwitchTo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AllSwitchToMethods {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "alertBtn")
	WebElement simplealert;

	@FindBy(id = "confirmBtn")
	WebElement cnfrmAlert;

	@FindBy(id = "promptBtn")
	WebElement promptAlert;

	@FindBy(id = "country")
	WebElement countryDropdown;
    @Ignore
	@Test
	public void handleAlerts() {
		simplealert.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		cnfrmAlert.click();
		alert = driver.switchTo().alert();
		alert.dismiss();

		promptAlert.click();
		// alert = driver.switchTo().alert();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Testing");
		System.out.println(alert.getText());
		alert.accept();
		driver.switchTo().newWindow(WindowType.WINDOW);

	}

	@Test
	public void handleDropdown() {
		Select country = new Select(countryDropdown);
		country.selectByIndex(0);
		System.out.println(country.getFirstSelectedOption().getText());
		country.deselectByIndex(0);
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
