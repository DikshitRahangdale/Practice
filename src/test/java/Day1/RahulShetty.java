package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.nio.channels.SelectableChannel;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RahulShetty {
	WebDriver driver;

	@FindBy(css = "input.form-control[name='name']")
	WebElement username;

	@FindBy(css = "input.form-control[name='email']")
	WebElement userenmail;

	@FindBy(id = "exampleInputPassword1")
	WebElement password;

	@FindBy(id = "exampleCheck1")
	WebElement checkbox;

	@FindBy(id = "exampleFormControlSelect1")
	WebElement genderdropdown;

	@FindBy(id = "inlineRadio2")
	WebElement employmentStatus;

	@FindBy(name = "bday")
	WebElement birthday;

	@FindBy(css = ".btn-success[value='Submit']")
	WebElement submitBtn;

	@FindBy(css = ".alert.alert-success")
	WebElement sucessMsg;

	@Test
	public void test() throws InterruptedException {

		String gender = "Male";
		String expectedsuccesmsg = "The Form has been submitted successfully";

		username.sendKeys("QA Testing ");
		userenmail.sendKeys("testing@gmail.com");
		password.sendKeys("Pass@123456");
		if (checkbox.isEnabled())
			checkbox.click();
		genderdropdown.click();
		Select genders = new Select(genderdropdown);
		Thread.sleep(1000);
		genders.selectByVisibleText("Male");
		System.out.println( genders.getFirstSelectedOption().getText());
		Assert.assertEquals(gender, genders.getFirstSelectedOption().getText(), "Gender is not Selected");
		if (employmentStatus.isEnabled())
			employmentStatus.click();
		birthday.sendKeys("29-12-2009");
		submitBtn.click();
		String actualsuceesmsg = sucessMsg.getText();
		if (actualsuceesmsg.contains(expectedsuccesmsg))
			System.out.println("Test Case Pass");

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
