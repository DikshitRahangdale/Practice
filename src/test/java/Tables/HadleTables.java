package Tables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HadleTables {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void handleTables() throws InterruptedException {

		boolean nextBtnStatus = true;
		WebElement sortingIcon = driver.findElement(By.xpath("//*[contains(@aria-label,'Veg/fruit name')]/span[2]"));
		List<String> actualData = new ArrayList<>();

		while (true) {
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[contains(@class,'table-bordered')]/tbody/tr/td[1]"));

			for (WebElement row : rows) {
				String actualcoloumns = row.getText().trim();
				actualData.add(actualcoloumns);
			}

			WebElement nextBtn = driver.findElement(By.xpath("//*[@aria-label='Next' and @role='button']"));
			String status = nextBtn.getAttribute("aria-disabled").toString();

			if (status.equalsIgnoreCase("true")) {
				System.out.println("Next BUtton is Disabled");
				break;
			}

			nextBtn.click();

		}

		List<String> asecSortedata = new ArrayList<>(actualData);
		Collections.sort(asecSortedata);

		List<String> descSortedata = new ArrayList<>(actualData);
		Collections.sort(descSortedata, Collections.reverseOrder());
		System.out.println(asecSortedata);
		System.out.println(descSortedata);
		

		WebElement firstBtnElement = driver.findElement(By.xpath("//*[@aria-label='First' and @role='button']"));

		wait.until(ExpectedConditions.elementToBeClickable(firstBtnElement)).click();
		// firstBtnElement.click();
		Thread.sleep(5000);

		sortingIcon.click();

		List<String> actualDataAftersort = new ArrayList<>();

		while (true) {
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[contains(@class,'table-bordered')]/tbody/tr/td[1]"));

			for (WebElement row : rows) {
				String actualcoloumns = row.getText().trim();
				actualDataAftersort.add(actualcoloumns);
			}

			WebElement nextBtn = driver.findElement(By.xpath("//*[@aria-label='Next' and @role='button']"));
			String status = nextBtn.getAttribute("aria-disabled").toString();

			if (status.equalsIgnoreCase("true")) {
				System.out.println("Next BUtton is Disabled");
				break;
			}

			nextBtn.click();

		}

		Assert.assertEquals(actualData, descSortedata, "Data is not sorted in desc or Desc sorting not working");
		Assert.assertEquals(actualDataAftersort, asecSortedata,
				"Data is not sorted in Asce or Asce sorting not working");

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
