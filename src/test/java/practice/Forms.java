package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Forms {
	WebDriver driver;
	Actions mouse;
	WebDriverWait wait;
	String formname = "TestNGTestNG";
	SoftAssert soft;

	@Test(priority = 1)
	public void f() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sushantcricket85@gmail.com");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shelake@0808");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		WebElement formsElement = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//a[@title='Forms' and @class='flex flex-auto hover:text-white ']")));

		mouse.moveToElement(formsElement).perform();
		formsElement.click();

		driver.findElement(By.xpath("//div[@class='flex gap-2 formlist-responsive-btn']/a[1]")).click();

		driver.findElement(By.xpath("//input[@id='form_title']")).sendKeys(formname);

		driver.findElement(By.xpath("//button[@id='formcreation-submit']")).click();
	}

	@Test(priority = 2, dependsOnMethods = "f")
	public void customization() {
		WebElement dragElement = driver.findElement(By.cssSelector(
				".formbuilder-icon-contactinfogroupinfo.handlepopupwidgetsectionli.input-control.input-control-18.ui-sortable-handle"));

		WebElement dropElement = driver.findElement(By.xpath("//li[@class='builder-start-content disabled-field']"));

		// mouse.dragAndDrop(dragElement, dropElement).perform();

		mouse.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();

		WebElement btnElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='fb-save-form']")));
		btnElement.click();
		driver.findElement(By.xpath(
				"//a[@class='rounded-lg bg-lightgray editor-close-icon inline-flex justify-center items-center ml-2']"))
				.click();

	}

	@Test(priority = 3, dependsOnMethods = "customization")

	public void search() {
		driver.findElement(By.xpath(
				"//input[@name='search' and @class='block w-full h-full pl-11 pr-3 py-2 rounded-xl global-filter dp-search-field']"))
				.sendKeys(formname);
		mouse.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

		// List<WebElement> formNames =
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@id,'admintable')]/tbody/tr/td[2]/div/a")));

		List<WebElement> formName = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@id,'admintable')]/tbody/tr/td[2]/div/a")));

		for (WebElement frm : formName) {
			String formString = frm.getText();
			soft.assertEquals(formString, formname, "Form Name Not Matched");

		}
		
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//table[contains(@id,'admintable')]//input[@type='checkbox']"));
		System.out.println("Number of CheckBox: "+checkbox.size());
		
		for(WebElement box:checkbox)
		{
			System.out.println(box.isDisplayed());
			System.out.println(box.isEnabled());
			System.out.println(box.isSelected());
		}
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.deposyt.com/index.php?m=addformtemplates");
		mouse = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		soft = new SoftAssert();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
