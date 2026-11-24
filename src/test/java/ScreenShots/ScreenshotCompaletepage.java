package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScreenshotCompaletepage extends DriverSetup {
  @Test
  public void completepage() throws IOException {
	  driver.get("https://www.pexels.com/");
	  TakesScreenshot tS=(TakesScreenshot)driver;
	  File src=tS.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\screenshot1.png"));
  }
}
