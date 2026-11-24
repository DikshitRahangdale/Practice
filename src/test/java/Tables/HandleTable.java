package Tables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HandleTable {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "table[name='BookTable'] tr")
	List<WebElement> tables;

	@FindBy(css = "//table[@name='BookTable']//tr[2]/td[3]")
	List<WebElement> thirdcolumns;

	@FindBy(xpath = "//table[@id='productTable']//tr")
	List<WebElement> pageCount;

	@Test
	public void validaterows() {
		String sentence = "Master In Java Amod JAVA 2000";
		Boolean flag = false;

		for (WebElement row : tables) {
			String rowText = row.getText();
			System.out.println(rowText);
			if (rowText.contains(sentence)) {
				flag = true;
				break;
			}

		}
		Assert.assertEquals(flag, true, "Test Case Failed");
		List<String> subjects = new ArrayList<>();

		for (int i = 2; i <= tables.size(); i++) {
			String subject = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[3]")).getText();
			subjects.add(subject);
		}

		for (String sub : subjects) {
			System.out.println(sub);
		}
	}

	@Test
	public void paginationTable() {

		List<WebElement> counts = driver.findElements(By.xpath("//*[@id='pagination']/li"));
		for (WebElement count : counts) {
			if (count.isDisplayed())
				count.click();
			else
				break;
			for (int i = 1; i <= pageCount.size()-1; i++) {
				WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]/td[4]/input"));
					Boolean status=	checkbox.isEnabled();
				if (!status) {
					System.out.print(i + " is not clickable");
					continue;
				}
				checkbox.click();

			}
		

		}

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}

}
