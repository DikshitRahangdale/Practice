package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScreenshotArea extends DriverSetup{
  @Test
	public void specificare() throws IOException {
	  driver.get("https://app.deposyt.com/index.php?m=account");
	  WebElement are=driver.findElement(By.xpath("//form[@id='loginForm']/parent::*"));
	  
	  File src=are.getScreenshotAs(OutputType.FILE);
	  File location=new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\specificare.jpg");
	  FileUtils.copyFile(src, location);
  }
}
