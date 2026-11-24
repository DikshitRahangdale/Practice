package practice1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Scanner;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class CssSelecors {
	WebDriver driver;

	@FindBy(css = "input#name")
	WebElement name;

	@FindBy(css = "#name")
	WebElement name2;

	@FindBy(css = "input.form-control")
	List<WebElement> input3;

	@FindBy(css = ".form-control")
	List<WebElement> input4;

	@Test
	public void test1() {

		name.sendKeys("Dikshit");
		System.out.println(name.getAttribute("value"));
		name2.clear();
		System.out.println(name.getAttribute("value"));

		Scanner scanner = new Scanner(System.in);

		for (WebElement inp : input3) {
			inp.sendKeys(scanner.next());
		}

		for (WebElement inp : input4) {
			inp.click();
		}
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
