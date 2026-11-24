package Chromeoptions;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessMetho {
	@Test
	public void method() {

		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true); this version is not supported this methods

		options.addArguments("--headless=new", "--incognito");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.apple.com/in/");
		driver.close();

	}
}
