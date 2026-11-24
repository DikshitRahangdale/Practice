package SwitchTo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AlertsMethods {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void alertstest() {

		// Simpale Alert

		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Alert simplealert = driver.switchTo().alert();
		simplealert.accept();

		// Confirmation Alert

		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		Alert confAlert = driver.switchTo().alert();
		confAlert.dismiss();

		// Prompt Alert
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		Alert propmptAlert = wait.until(ExpectedConditions.alertIsPresent());
		propmptAlert.sendKeys("Testing");
		propmptAlert.accept();

		 boolean flag= wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#demo"),
				"Hello Testing! How are you today?"));
		 
		 if(flag==true)
			 System.out.println("Propmpt Alert Test Case Pass");
		 
		 else 
			 System.out.println("Propmpt Alert Test Case Fail");
		 
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
