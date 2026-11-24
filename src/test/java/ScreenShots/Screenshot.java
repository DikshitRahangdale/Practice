package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Screenshot extends DriverSetup {
	@Test
	public void screenshot() throws IOException {
		driver.get("https://www.google.com/");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\screenshot2.jpg"));
	}
}
