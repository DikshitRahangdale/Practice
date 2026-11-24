package Locators;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class CssSelectors {
	WebDriver driver;

	@Test(priority = 1)
	public void cssselectors() {

		// 1) Tag with ID
		driver.findElement(By.cssSelector("input#name")).sendKeys("Testing Test");
		// without Tag
		driver.findElement(By.cssSelector("#email")).sendKeys("testing@gmail.com");

		// 2) Tag class and Attributes
		driver.findElement(By.cssSelector("input.form-control[placeholder='Enter Phone']")).sendKeys("89758943589435");
		// without Tag
		driver.findElement(By.cssSelector(".form-control[id='textarea']"))
				.sendKeys("fdidshfisdh afhisuaf huisdhfguidshfius hig ia ghp");

		driver.findElement(By.cssSelector("label.form-check-label[for='male']")).click();

		// 3) Tag with Attributes
		driver.findElement(By.cssSelector("label[for='thursday']")).click();
		// only attributes
		WebElement countrydropdowns = driver.findElement(By.cssSelector("[id='country']"));

		Select country = new Select(countrydropdowns);
		country.selectByValue("india");

		// start with

		driver.findElement(By.cssSelector("button[name ^='st']"));

		// contains
		driver.findElement(By.cssSelector("button[name *='st']"));

		// end with

		WebElement coloursedropdown = driver.findElement(By.cssSelector("select[id $='lors']"));

		Select colours = new Select(countrydropdowns);
		// colours.selectByValue("green");

	}

	@Test(priority = 2)
	public void xpath() {
		// 1)
		WebElement animaldropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select animals = new Select(animaldropdown);
		animals.selectByVisibleText("Cat");

		WebElement datepicker1 = driver.findElement(By.xpath("//*[@id='datepicker']"));
		datepicker1.sendKeys("01/05/2026");

		driver.findElement(By.xpath("//*[@id='txtDate'][@name='SelectedDate']")).click();

		List<WebElement> datTabl = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));

		for (WebElement dates : datTabl) {
			if (dates.getText().equals("4")) {
				dates.click();
				break;
			}
		}

		driver.findElement(By.xpath("//*[@class='wikipedia-search-input'][@id='Wikipedia1_wikipedia-search-input']"))
				.sendKeys("India");

		// and ,or Operators

		driver.findElement(By.xpath("//*[@id='alertBtn'and text()='Simple Alert']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.xpath("//*[@name='start' or @name='stop']")).click();

		// text() methods

		driver.findElement(By.xpath("//*[text()='Confirmation Alert']")).click();
		alert.accept();

		// contains methods

		driver.findElement(By.xpath("//*[contains(text(),'Prompt Alert')]")).click();
		Alert alert2 = driver.switchTo().alert();
		alert.accept();

		// starts-witch methods

		driver.findElement(By.xpath("//*[starts-with(@name,'st')]")).click();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
