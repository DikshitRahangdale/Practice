package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SwitchToMethods {

	WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.id("alertBtn")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement confAlert = driver.findElement(By.id("confirmBtn"));
		confAlert.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		confAlert.click();
		alert2 = driver.switchTo().alert();
		alert2.accept();

		WebElement alert3 = driver.findElement(By.id("promptBtn"));
		alert3.click();
		Alert alert4 = driver.switchTo().alert();
		alert4.sendKeys("Testing Automationss");
		alert4.accept();

		alert3.click();
		alert4 = driver.switchTo().alert();
		System.out.println(alert4.getText());
		alert4.dismiss();

	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
