package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllTestNgAnnoatation {
	WebDriver driver;
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="phone")
	WebElement phone;

	@Test(groups="Smoke")
	public void firstName() {
       name.sendKeys("Dikshit");
	}
	
	@Test(groups="Smoke")
	public void lastName() {
       
	}
	@Test(groups="Sanity")
	public void email() {
     email.sendKeys("diskhit@gmail.com");
	}
	@Test(groups="Regression")
	public void mobileNUmber() {
      phone.sendKeys("8787878789789");
	}
	

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
       driver.close();
	}

}
