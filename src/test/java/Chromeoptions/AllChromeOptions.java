package Chromeoptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.annotations.AfterTest;

public class AllChromeOptions {
	WebDriver driver;
	ChromeOptions options;
	TakesScreenshot ts;

	@Test
	public void allmethods() throws IOException, InterruptedException {

		driver.findElement(By.xpath("//*[@name='start' or @name='stop']")).click();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		File file2 = new File(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\src\\test\\java\\Chromeoptions\\screenshotfirst.jpg");
		FileUtils.copyFile(srcFile, file2);

	}

	@BeforeTest
	public void beforeTest() {
		options = new ChromeOptions();
		// options.addArguments("--incognito");
//		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		options.addArguments("--window-size=1000,800", "--incognito");
		driver = new ChromeDriver(options);

		// driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ts = (TakesScreenshot) driver;
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
