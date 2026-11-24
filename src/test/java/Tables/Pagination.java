package Tables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Pagination {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void pageinationTable() {

		boolean flag = true;

		int pagecount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();

		for (int p = 1; p <= pagecount; p++) {
			List<WebElement> allrows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

			for (WebElement row : allrows) {
				System.out.println(row.getText());
			}

			WebElement pagecountElement = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='pagination']/li[" + p + "]")));

			if (pagecountElement.isDisplayed() == true)
				pagecountElement.click();
			else {
				break;
			}

		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
