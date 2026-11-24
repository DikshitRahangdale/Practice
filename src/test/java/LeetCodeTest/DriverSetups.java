package LeetCodeTest;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DriverSetups {
	public WebDriver driver;
	public JavascriptExecutor js;
	public Alert alert;
	public WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
