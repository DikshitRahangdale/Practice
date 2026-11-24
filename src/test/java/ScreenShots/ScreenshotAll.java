package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScreenshotAll extends DriverSetup {
	@Test
	public void completePage() throws IOException {

		driver.get("https://testautomationpractice.blogspot.com/");

		TakesScreenshot tS = (TakesScreenshot) driver;
		File srcFile = tS.getScreenshotAs(OutputType.FILE);
		File souFile = new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\screen1.jpg");
		FileUtils.copyFile(srcFile, souFile);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\screen2.jpg"));

		WebElement textarElement = driver.findElement(By.id("textarea"));

		File src2 = textarElement.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src2, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\textarea.jpg"));

	}

}
