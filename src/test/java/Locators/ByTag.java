package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByTag {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> inputtags = driver.findElements(By.tagName("input"));
		System.out.println("Total Input field in this Page: " + inputtags.size());

		List<WebElement> totalLinksElements = driver.findElements(By.tagName("a"));
		System.out.println("Total Links in this Page: " + totalLinksElements.size());

		driver.close();
	}

}
