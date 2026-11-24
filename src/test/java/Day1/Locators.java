package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Locators {
	WebDriver driver;
	Actions actions;

	@Test
	public void test() {
		// ID
		driver.findElement(By.id("name")).sendKeys("Diskhit");

		// name
		WebElement animalsElement = driver.findElement(By.name("animals"));
		actions.moveToElement(animalsElement).perform();

		// classsName
		driver.findElement(By.className("start")).click();

		List<WebElement> alllinksList = driver.findElements(By.tagName("a"));
		System.out.println("Total Links Present: " + alllinksList.size());

		// CssSeelctor
		driver.findElement(By.cssSelector("input#name")).sendKeys("Dikshit R");
		driver.findElement(By.cssSelector("#email")).sendKeys("testing@gmail.com");

		driver.findElement(By.cssSelector("input.form-control[id='phone']")).sendKeys("987898989");

		String s = "Testing test tere";

		driver.findElement(By.cssSelector("textarea[id='textarea']")).sendKeys(s);
		String s1 = driver.findElement(By.cssSelector("[id='textarea']")).getAttribute("value");
		Assert.assertEquals(s1, s,"Text Area content not match");
		System.out.println(s1);
		
		Integer []arr= {3,34,56,6,6,6,6};
		List<Integer> list=Arrays.asList(arr);
		
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		actions = new Actions(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
