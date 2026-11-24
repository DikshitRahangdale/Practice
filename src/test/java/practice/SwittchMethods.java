package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SwittchMethods {
	WebDriver driver;
	Alert alert;
	WebDriverWait wait;

	@Test(priority = 1)
	public void alertss() {

		WebElement alrtElement = driver.findElement(By.xpath("//*[@class='card-footer-item' and text()=' Dialog ']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alrtElement);
//		wait.until(ExpectedConditions.elementToBeClickable(alrtElement));
		alrtElement.click();

		// 1) Simple Alerts

		driver.findElement(By.xpath("//*[@id='accept' and text()='Simple Alert']")).click();
		alert = driver.switchTo().alert();
		alert.accept();

		// 2)Confirmations Alerts

		WebElement confirm_alerts = driver.findElement(By.xpath("//*[@id='confirm' and text()='Confirm Alert']"));
		confirm_alerts.click();
		alert = driver.switchTo().alert();
		alert.accept();

		confirm_alerts.click();
		alert = driver.switchTo().alert();
		alert.dismiss();

		// 3) Prompt Alerts

		WebElement prompt_alertElement = driver.findElement(By.xpath("//*[@id='prompt' and text()='Prompt Alert']"));
		prompt_alertElement.click();
		alert = driver.switchTo().alert();
		alert.accept();

		prompt_alertElement.click();
		alert = driver.switchTo().alert();
		alert.dismiss();

		prompt_alertElement.click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Dikshit");
		alert.accept();

		String enter_name = driver.findElement(By.xpath("//*[@id='myName']")).getText();
		System.out.println(enter_name);

		prompt_alertElement.click();
		alert = driver.switchTo().alert();
		String alertTextString = alert.getText();
		alert.accept();

		System.out.println("Alert Text: " + alertTextString);
		driver.navigate().back();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/test");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
