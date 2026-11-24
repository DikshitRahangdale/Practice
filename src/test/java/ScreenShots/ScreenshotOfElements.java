package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScreenshotOfElements extends DriverSetup{
  @Test
	public void specificElement() throws IOException {
	  
	  driver.get("https://app.deposyt.com/index.php?m=account");	  
	  WebElement elemnt=driver.findElement(By.xpath("//*[@for='email']/parent::div"));
	  
	  File src=elemnt.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src, new File("C:\\Users\\ADMIN\\Pictures\\Screenshots\\specificElement.jpg"));
  }
}
