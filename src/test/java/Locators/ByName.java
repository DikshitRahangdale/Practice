package Locators;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByName {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		Scanner sc = new Scanner(System.in);

		List<WebElement> gendars = driver.findElements(By.name("gender"));
		System.out.println("Enter Your Gendar:- Male or Female");
		String gend = sc.next();

		if (gend.equalsIgnoreCase("Male")) {
			gendars.get(0).click();
		} else if (gend.equalsIgnoreCase("Female")) {
			gendars.get(1).click();
		} else {
			System.out.println("Enter Correct Option");
		}

		driver.close();

	}

}
