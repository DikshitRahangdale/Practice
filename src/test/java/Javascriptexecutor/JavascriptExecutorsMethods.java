package Javascriptexecutor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class JavascriptExecutorsMethods {
	WebDriver driver;
	JavascriptExecutor js;

	@FindBy(xpath = "//*[@name='start' or @name='stop']")
	WebElement startStopBtn;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(css = "#multipleFilesInput")
	WebElement fileUpload;

	@Test
	public void javaScriptMethods() throws InterruptedException {
		js.executeScript("arguments[0].click();", startStopBtn);
		js.executeScript("arguments[0].click();", startStopBtn);
		js.executeScript("arguments[0].value='Testing'", name);

		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView(true);", startStopBtn);
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
		String pageTile = js.executeScript("return document.title;").toString();
		System.out.println(pageTile);
//		String pageURl = js.executeScript("return document.url;").toString();
//		System.out.println(pageURl);
		fileUpload.sendKeys(System.getProperty("user.dir") + "\\reports\\image.png");
		Thread.sleep(5000);
		js.executeScript("history.go(0)");

	}

	@Test(priority = -1)
	public void takescreenshot() throws IOException {
		//TakesScreenshot ts = (TakesScreenshot) driver;
		File src = startStopBtn.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\\\reports\\\\image1.png");
		FileUtils.copyFile(src, destination);

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
