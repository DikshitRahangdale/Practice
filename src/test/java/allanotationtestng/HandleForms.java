package allanotationtestng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HandleForms {
	WebDriver driver;
	JavascriptExecutor js;
	SoftAssert soft;
	WebDriverWait wait;
//Testing  test
	@FindBy(id = "name")
	WebElement nameInput;

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "phone")
	WebElement phoneInput;

	@FindBy(id = "textarea")
	WebElement textArea;

	@FindBy(id = "male")
	WebElement maleGender;

	@FindBy(id = "wednesday")
	WebElement day;

	@Test
	public void fillupForms() {
		nameInput.sendKeys("Diks Test");
		emailInput.sendKeys("diks@gmail.com");
		phoneInput.sendKeys("9754985444895");
		textArea.sendKeys("Test shdfdksf hsdkfsdk f dsf sdkf dsk");
		if (!maleGender.isSelected())
			maleGender.click();
		if (!day.isSelected())
			day.click();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		soft = new SoftAssert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		PageFactory.initElements(driver, this);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
