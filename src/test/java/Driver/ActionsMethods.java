package Driver;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ActionsMethods {
	WebDriver driver;
	WebDriverWait wait;
	Actions mouse;
	JavascriptExecutor js;

	@FindBy(xpath = "//*[normalize-space()='Point Me']")
	WebElement pointMeButton;
	@FindBy(xpath = "//button[normalize-space()='Copy Text']")
	WebElement doubleClick;

	@FindBy(css = "#field2")
	WebElement inputField2;

	@FindBy(css = "#field1")
	WebElement inputField1;

	@Test
	public void actionsMethods() throws IOException {
		mouse.moveToElement(pointMeButton).click().perform();
		mouse.click(pointMeButton).perform();
		String inputfieldText2 = inputField2.getAttribute("value");
		String inputfieldText1 = inputField1.getAttribute("value");
		Assert.assertEquals(inputfieldText2, "", "Input Field not null");
		mouse.doubleClick(doubleClick).perform();

		String inputfieldText3 = inputField2.getAttribute("value");
		Assert.assertEquals(inputfieldText3, inputfieldText1, "Both Input Field Words is not matched");

		js.executeScript("arguments[0].click();", pointMeButton);
		js.executeScript("arguments[0].value='Dikshit';", inputfieldText2);
		js.executeScript("arguments[0].scrollIntoView(true);", pointMeButton);
           
	    TakesScreenshot ts=(TakesScreenshot)driver;
	    File src=ts.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"/reports/test.png"));
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		mouse = new Actions(driver);
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
