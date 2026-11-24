package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.mozilla.javascript.ast.NewExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class XpathLocators {
	WebDriver driver;

	String actuString = "Testing";

	@Test
	public void test() {
		WebElement firstname = driver.findElement(By.xpath("//*[@id='name']/following-sibling::input[@id='email']"));
		firstname.sendKeys(actuString);
		String expString = firstname.getAttribute("value");

		Assert.assertEquals(actuString, expString, "User Name Does not Match");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
