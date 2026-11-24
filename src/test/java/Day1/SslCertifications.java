package Day1;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class SslCertifications {
	WebDriver driver;
	ChromeOptions options;
	TakesScreenshot screenshot;

	@Test
	public void test() throws IOException {
		System.out.println(driver.getCurrentUrl());
		screenshot=(TakesScreenshot)driver;
		File screen=screenshot.getScreenshotAs(OutputType.FILE);
		File scrFile=new File(System.getProperty("user.dir")+"//target/screen.png");
		FileUtils.copyFile(screen,scrFile);
		//URL dUrl=new URL();
		
		
		
	}

	@BeforeClass
	public void beforeClass() {
		options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
