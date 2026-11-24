package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.Dimension;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class XpathPractice {
	WebDriver driver;

	@Test
	public void f() {
		// 1)
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tarsier60796@aminating.com");

		// 2)

		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Nadsoft@1234");

		// 3)

		driver.findElement(By.xpath("//input[@id='remember-me'][@name='autologin_d']")).click();

		// 4)

		driver.findElement(By.xpath("//input[@id='remember-me' and @name='autologin_d']")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//*[@type='buttons' and @data-tab-page='bookings']")).click();

		driver.findElement(By.xpath("//*[@class='fa-solid' or @id='arrow']")).click();

		driver.findElement(By.xpath("//*[text()='All Users']")).click();

		driver.findElement(By.xpath("//*[contains(@class, 'sales_person_filter_deafult_option')]")).click();

		driver.findElement(By.xpath("//*[starts-with(@class, 'custom-date form-control')]")).click();
		Actions mouse = new Actions(driver);

		WebElement courses = driver.findElement(By.xpath(
				"//div[contains(@class, 'sidebar-category-menu seles_accordion')]//a[contains(@title, 'Courses')]"));

		mouse.moveToElement(courses);
		courses.click();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
		Dimension dimension = new Dimension(1920, 1080);
		 driver.manage().window().setSize(dimension);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
