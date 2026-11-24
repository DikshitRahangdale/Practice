package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HandleFraes {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "content")
	WebElement textElement;

	@Test
	public void testingFrames() {
		 driver.switchTo().frame(0);
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
		 //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

		System.out.println(textElement.getText());

		driver.switchTo().defaultContent();
		
		//Finding total links present on page
		
		int count =driver.findElements(By.tagName("a")).size();
		System.out.println(count);
		
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
		
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		PageFactory.initElements(driver, this);
		driver.get("https://the-internet.herokuapp.com/nested_frames");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
