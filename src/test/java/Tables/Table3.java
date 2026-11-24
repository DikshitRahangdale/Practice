package Tables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Table3 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@Test
	public void f() {
 
		while (true) {
			List<WebElement> tablerows = driver.findElements(By.cssSelector("#advancedtable tbody tr "));

			for (WebElement rows : tablerows) {
				System.out.println(rows.getText());
			}
			System.out.println();

			WebElement nextbutton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next']")));
			js.executeScript("arguments[0].scrollIntoView(true);", nextbutton);
			
			String nextbuttonstatus=nextbutton.getAttribute("class");

			if (nextbuttonstatus.contains("disabled ")) {
				break;
			}
			
			js.executeScript("arguments[0].click();", nextbutton);

			//nextbutton.click();

		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		driver.get("https://letcode.in/advancedtable");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
