package deposyt_crm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Form {
	WebDriver driver;
	Actions mouse;
	WebDriverWait wait;

	@Test(priority = 1)
	public void forM() {

//		WebElement formsElement = driver
//				.findElement(By.xpath("//a[@title='Forms' and @class='flex flex-auto hover:text-white ']"));
//		mouse.moveToElement(formsElement).perform();
//		formsElement.click();
		WebElement formsElement = driver
				.findElement(By.xpath("(//a[@title='Courses'])[2]"));
		mouse.moveToElement(formsElement).perform();
		formsElement.click();

		//driver.findElement(By.xpath("//a[contains(text(), 'New Form')] ")).click();

//		driver.findElement(By.xpath("//input[@id='form_title']")).sendKeys("Selenum Test");
//		driver.findElement(By.xpath("//button[@id='formcreation-submit']")).click();
	}

	@Test(priority = 2, enabled = false)

	public void formEdit() throws InterruptedException {
		WebElement dragElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				".formbuilder-icon-contactinfogroupinfo.handlepopupwidgetsectionli.input-control.input-control-18.ui-sortable-handle")));
		WebElement dropElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@class='builder-start-content disabled-field']")));

		mouse.dragAndDrop(dragElement, dropElement).perform();

		driver.findElement(By.xpath("//button[@id='fb-save-form']")).click();
		driver.findElement(By.xpath("//*[@id=\"spacious-container\"]/div[1]/div[3]/a/i")).click();

	}

	@Test(priority = 3, enabled = false)

	public void searchForm() {
		driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search Forms']"))
				.sendKeys("Selenium Test", Keys.ENTER);
		driver.findElement(By.xpath("(//td[@id='at0-cell-action-0'])[1]")).click();

	}

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=account");
		mouse = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tarsier60796@aminating.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("R4!zN1#tV6%");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

}
