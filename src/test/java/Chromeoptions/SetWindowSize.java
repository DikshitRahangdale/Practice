package Chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SetWindowSize {
	@Test
	public void windowsize() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=100,1080");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.apple.com/in/");

	}
}
