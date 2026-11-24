package practice1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class WebDriverFrames {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[text()='Iframe with in an Iframe']")
	WebElement nestedFramesElement;

	@FindBy(xpath = "//*[text()='Nested iFrames']")
	WebElement firstFraElement;

	@Test
	public void framesHandles() {
		nestedFramesElement.click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		//System.out.println(firstFraElement.isDisplayed());

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");
		PageFactory.initElements(driver, this);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
