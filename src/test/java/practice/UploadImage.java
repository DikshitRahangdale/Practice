package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class UploadImage extends DriverSetup {
	@Test
	public void uploadimage() throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/");

		String file1 = "C:\\Users\\ADMIN\\Pictures\\Er.Dikshit\\IMP Screenshot\\SmartSelect_20220728-185704_Google.jpg";
		String file2 = "C:\\Users\\ADMIN\\Pictures\\Er.Dikshit\\IMP Screenshot\\SmartSelect_20220710-095441_WhatsApp.jpg";

		// Single File
		driver.findElement(By.id("singleFileInput")).sendKeys(file1);

		// Multifiles
		driver.findElement(By.id("multipleFilesInput")).sendKeys(file1 + "\n" + file2);
		
		Thread.sleep(3000);
	}
}
