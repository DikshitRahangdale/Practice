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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TableOne {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void staticwebtable() {

		int totalrows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		int totalcoloumns = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();

		System.out.println("Total Rows: " + totalrows + "\n" + "Total Coloumns: " + totalcoloumns);

		List<WebElement> alldata = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
          System.out.println("Table Data: ");
		for (WebElement data : alldata) {
			System.out.println(data.getText());

		}
		
		System.out.println("Only Amit Data: ");

		// print only Amit data
		for (WebElement dt : alldata) {
			if (dt.getText().contains("Amit")) {
				System.out.println(dt.getText());
				break;
			}
		}
		
		System.out.println("Table Header: ");
		
		//Print only Header
		List<WebElement> headers=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		for (WebElement head : headers) {
			System.out.print(head.getText());

		}
		
		
		System.out.println("\nTables Rows: ");
		//Print only rows not Header section
         
		for(int i=2;i<=totalrows;i++)	{
			
			for(int j=1;j<=totalcoloumns;j++)
			{
				String allrowsdata=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(allrowsdata);
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
