package webdrivermethods;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.VoidDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

public class WindowHandles {
	WebDriver driver;

	@Test
	public void openmultiplewindos() {

		String parentwindowID = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[text()='Terms and Conditions']")).click();

		Set<String> allopenwindowID = driver.getWindowHandles();

		for (String ids : allopenwindowID) {
			driver.switchTo().window(ids);
			
			if (parentwindowID.equals(ids)) {
				System.out.println("Parent Window URL: " + driver.getCurrentUrl());
				driver.close();
			}
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
