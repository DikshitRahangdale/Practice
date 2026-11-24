package practice1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SwitchToActiveElement {
	WebDriver driver;

	@Test
	public void f() {

		WebElement activeElement = driver.switchTo().activeElement();
		System.out.println(activeElement.getTagName());

		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(driver.getWindowHandles().size());
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
