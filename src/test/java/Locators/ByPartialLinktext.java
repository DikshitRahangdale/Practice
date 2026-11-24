package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByPartialLinktext {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.partialLinkText("Udemy")).click();

		System.out.println(driver.getCurrentUrl());
		driver.close();

	}
}
