package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;

public class DependonMethod1 {
	WebDriver driver;
	SoftAssert soft;
	ChromeOptions option;

	@Test(priority = 1)
	public void login() {
		WebElement usernamElement = driver.findElement(By.xpath("//*[@placeholder='Username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//*[@placeholder='Password']"));
		WebElement loginButtonElement = driver.findElement(By.xpath("//*[@type=\"submit\" and text()=\" Login \"]"));
		usernamElement.sendKeys("Admin");
		passwordElement.sendKeys("admin123");
		loginButtonElement.click();

	}

	@Test(dependsOnMethods = "login", priority = 2)
	public void homepage() {

		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		soft.assertEquals(driver.getCurrentUrl(), expectedURL, "Login is failed");
		soft.assertAll();

	}

	@BeforeTest
	public void beforeTest() {
		option = new ChromeOptions();
		try {
			driver = new RemoteWebDriver(URI.create("http://192.168.0.209:4444").toURL(), option);
		} catch (Exception e) {
			e.getStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		soft = new SoftAssert();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterTest
	public void afterTest() {

		driver.close();
	}

}
