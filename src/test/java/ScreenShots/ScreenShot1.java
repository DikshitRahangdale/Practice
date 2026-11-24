package ScreenShots;

import org.testng.annotations.Test;

import Chromeoptions.AddExtensions;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class ScreenShot1 {
	WebDriver driver;
	TakesScreenshot tS;
	ChromeOptions options;

	@Test
	public void screenshot() throws IOException {
		File srcFile = tS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\src\\test\\java\\ScreenShots\\headlessscreenshot4r.jpg"));
		File files = new File("C:\\Users\\ADMIN\\Pictures\\movies\\SelectorsHub - Chrome Web Store 5.7.3.0.crx");
		//options.addExtensions(files);
		options.addArguments(
			    "--load-extension=C:\\Users\\ADMIN\\Pictures\\movies\\SelectorsHub"
			);
	}

	@BeforeTest
	public void beforeTest() {
		options = new ChromeOptions();
		//options.addArguments("--headless=new");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		tS = (TakesScreenshot) driver;
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
