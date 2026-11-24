package Locators;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByClassname {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Scanner sc = new Scanner(System.in);

		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> classes = driver.findElements(By.className("form-control"));

		for (int i = 0; i < 3; i++) {
			classes.get(i).sendKeys(sc.next());
		}

		driver.close();

	}
}
