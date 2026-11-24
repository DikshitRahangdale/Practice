package pageObjectModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginDeposyt {
	public WebDriver driver;
	String userna = "yogeshmpandit17@gmail.com";
	String passwo = "Nadsoft@1234";

	@Test
	public void login() {
		/*
		 * LoginPage log = new LoginPage(driver); log.enterUserName(userna);
		 * log.enterPassword(passwo); log.clickLoginBtn();
		 */

		LoginPageFactory logn = new LoginPageFactory(driver);
		logn.enterUserName(userna);
		logn.enterPassword(passwo);
		logn.clickLoginBtn();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.release.deposyt.com/index.php?m=account");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
