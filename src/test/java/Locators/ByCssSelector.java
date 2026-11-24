package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByCssSelector {
	public static void main(String... args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");

		// 1) Tag with ID

		driver.findElement(By.cssSelector("input#name")).sendKeys("testing");
		driver.findElement(By.cssSelector("#email")).sendKeys("testingtest@gmail.com");

		// 2) tag with class name and attributes

		driver.findElement(By.cssSelector("input.form-control[id='phone']")).sendKeys("545655");
		driver.findElement(By.cssSelector(".form-control[id='phone']")).sendKeys("897");

		// 3) Tag with class name

		driver.findElement(By.cssSelector("textarea.form-control"))
				.sendKeys("testing practice for Css Selectors on Dummy website");
		driver.findElement(By.cssSelector(".form-control[id='textarea']")).sendKeys("testing");

		// 4) Tag with attributes

		driver.findElement(By.cssSelector("input[id='male']")).click();
		driver.findElement(By.cssSelector("[id='sunday']")).click();

		// 5) Dynamic Elements

		// 1) start with
		driver.findElement(By.cssSelector("input[id ^='nam']")).clear();

		// 2) Contains

		driver.findElement(By.cssSelector("input[id *='mail']")).clear();

		// 3) End With

		driver.findElement(By.cssSelector("[id $='hone']")).clear();

		// 6) Combining multiple attributes

		driver.findElement(By.cssSelector("textarea[class='form-control'][id='textarea']")).clear();

	}

}
