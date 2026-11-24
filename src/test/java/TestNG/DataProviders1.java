package TestNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DataProviders1 {
	WebDriver driver;

	@Test(dataProvider = "LogData", dataProviderClass = DataProviderClass.class)
	public void flogin(String userna, String passwo) {
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		username.clear();
		password.clear();

		username.sendKeys(userna);
		password.sendKeys(passwo);
		driver.findElement(By.cssSelector("button.deposytssologinbtn")).click();

	}

	@DataProvider(name = "LoginData")
	public Object[][] creadentials() {
		Object[][] dataObjects = { { "admintest", "Pass@1234" }, { "admintesdst", "Pass@123sd4" },
				{ "admintesasdst", "Pass@12dd34" }, { "admintesdast", "Passsd@1234" },
				{ "yogeshmpandit17@gmail.com", "Nadsoft@1234" }, { "admindsdtest", "Pass@12sd34" },
				{ "adminte33st", "Pass@123df4" }

		};
		return dataObjects;
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.release.deposyt.com/index.php?m=account");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
