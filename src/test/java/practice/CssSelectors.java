package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.Dimension;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class CssSelectors {
	WebDriver driver;

	@Test
	public void selectors() {

		// 1)ID
		// Tag and id
		driver.findElement(By.cssSelector("input#email")).sendKeys("tarsier60796@aminating.com");

		// ID
		driver.findElement(By.cssSelector("#email")).clear();

		// 2)CLASS
		// Tag and Class
		driver.findElement(By.cssSelector("i.eyeball")).click();

		// Class
		driver.findElement(By.cssSelector(".eyeball")).click();

		System.out.println(driver.findElement(By.cssSelector(".eyeball")).isSelected());

		// 3) Tag and Attribute
		String labelString = driver.findElement(By.cssSelector("label[for='email']")).getText();
		System.out.println("Label: " + labelString);

		// 4)Attribute

		String passlabel = driver.findElement(By.cssSelector("[for='password']")).getText();
		System.out.println("Label: " + passlabel);

		// 5) Tag Class & Attribute

		driver.findElement(By.cssSelector("input.h-4[name='autologin_d']")).click();

		// 6) class & Attribute

		driver.findElement(By.cssSelector(".h-4[name='autologin_d']")).click();
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Dimension size = driver.manage().window().getSize();
		System.out.println("Screeen Size: " + size);
		driver.get("https://app.deposyt.com/index.php?m=account");

	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

}
