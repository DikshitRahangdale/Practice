package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;

public class WindowHandles {

	WebDriver driver;
	@FindBy(xpath = "//*[text()='Multiple Windows']")
	WebElement multipleWindo;

	@FindBy(xpath = "//div[@id='content']/descendant::a[text()='Click Here']")
	WebElement clickHereBtn;

	@FindBy(css = ".example h3")
	WebElement visbletext;

	@Test
	public void windowhandles() {

		multipleWindo.click();
		String parentWindowId = driver.getWindowHandle();

		clickHereBtn.click();

		Set<String> allWindowId = driver.getWindowHandles();

		for (String windows : allWindowId) {

			if (!windows.equals(parentWindowId)) {
				driver.switchTo().window(windows);
				break;
			}
		}

		if (driver.getCurrentUrl().contains("new"))
			System.out.println("Child Window-->" + visbletext.getText());
		else {
			return;
		}

		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window-->" + visbletext.getText());

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(driver -> visbletext);

		Actions mouseActions = new Actions(driver);
		mouseActions.moveToElement(element).doubleClick(element).perform();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		PageFactory.initElements(driver, this);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
