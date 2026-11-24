package practice_2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.nio.channels.NonWritableChannelException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AutomationPractice {
	WebDriverWait wait;
	WebDriver driver;

	@FindBy(css = "#name")
	WebElement userName;

	@FindBy(id = "email")
	WebElement userEmail;

	@FindBy(id = "phone")
	WebElement userPhone;

	@FindBy(id = "textarea")
	WebElement userAddress;

	@FindBy(id = "male")
	WebElement maleRadioBtn;

	@FindBy(id = "thursday")
	WebElement days;

	@FindBy(id = "country")
	WebElement countryDropdown;

	@Test
	public void personalData() {
		userName.sendKeys("Testing Raju");
		userEmail.sendKeys("testing@gmail.com");
		userPhone.sendKeys("988998898");
		userAddress.sendKeys("kasba Peth,Pune,Maharashtra India");
		maleRadioBtn.click();

		if (!days.isSelected()) {
			days.click();
		}

		Select country = new Select(countryDropdown);
		country.selectByValue("india");
		System.out.println(country.getFirstSelectedOption().getText());
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
