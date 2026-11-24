package Chromeoptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AddExtensions {
	@Test
	public void f() {

		ChromeOptions options = new ChromeOptions();
		File crx = new File(
				"C:\\Users\\ADMIN\\Pictures\\movies\\Lightshot (screenshot tool) - Chrome Web Store 7.0.1.0.crx");

		options.addExtensions(crx);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.apple.com/in/");

	}
}
