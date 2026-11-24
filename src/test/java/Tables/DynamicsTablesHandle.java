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
import org.testng.annotations.AfterTest;

public class DynamicsTablesHandle {
	WebDriver driver;

	@Test
	public void dynamicTables() {

		List<WebElement> rowsElements = driver.findElements(By.xpath("//table[@id='taskTable']//tr"));
		int rowcount = rowsElements.size();
		List<WebElement> columnElements = driver.findElements(By.xpath("//table[@id='taskTable']//tr/th"));
		int columnCount = columnElements.size();

		for (int i = 1; i <= rowcount-1 ; i++) {
			for (int j = 1; j <= columnCount ; j++) {
				String tableData = driver.findElement(By.xpath("//table[@id='taskTable']//tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.print(tableData + " ");
			}
			System.out.println();
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
