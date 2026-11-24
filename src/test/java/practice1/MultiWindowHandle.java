package practice1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.color.ICC_Profile;
import java.rmi.server.ExportException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class MultiWindowHandle {
	WebDriver driver;
	WebDriverWait wait;
	Actions mouse;

	@FindBy(id = "Wikipedia1_wikipedia-search-input")
	WebElement wikisearchinput;

	@FindBy(css = ".wikipedia-search-button")
	WebElement searchButtonElement;

	@Test
	public void multiWindow() throws InterruptedException {
		wikisearchinput.sendKeys("India");
		searchButtonElement.click();
	

		String parentwindowID = driver.getWindowHandle();
		Thread.sleep(3000);
		List<WebElement> optionsElements = wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"), 0));

		System.out.println(optionsElements.size());

		for (WebElement searchresult : optionsElements) {

			mouse.keyDown(Keys.CONTROL).click(searchresult).keyUp(Keys.CONTROL).perform();
		}

		wait.until(ExpectedConditions.numberOfWindowsToBe(6));

		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println("Total Open Windows->" + allWindowID.size());

		Iterator<String> allwindow = allWindowID.iterator();
		while (allwindow.hasNext()) {
			String idString = allwindow.next();
			driver.switchTo().window(idString);
			System.out.println(driver.getCurrentUrl());

		}

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		mouse = new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
