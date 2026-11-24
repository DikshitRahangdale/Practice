package MouseAction;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriverWait wait;
	WebDriver driver;
	Actions mouse;

	@FindBy(xpath = "//button[@name='start' or @name='stop']")
	WebElement strtBtn;

	@FindBy(xpath = "//button[@class='dropbtn' and text()='Point Me']")
	WebElement pointMeBtn;

	@FindBy(xpath = "//*[@id='field2']/following-sibling::button")
	WebElement copyTextBtn;

	@FindBy(id = "alertBtn")
	WebElement alertBtn;

	@FindBy(id = "draggable")
	WebElement draggabl;

	@FindBy(id = "droppable")
	WebElement droppabl;

	@FindBy(xpath = "//*[@id='slider-range']/child::span[1]")
	WebElement slider;

	@FindBy(id = "name")
	WebElement nameinput;

	@FindBy(xpath = "//*[@id='Wikipedia1']/child::h2")
	WebElement wikiHeading;

	@Test
	public void allMoseActionsMethods() throws InterruptedException {
		mouse.moveToElement(strtBtn).click().perform();
		mouse.moveToElement(pointMeBtn).perform();
		mouse.doubleClick(copyTextBtn).perform();
		mouse.contextClick(strtBtn).perform();
		mouse.clickAndHold(strtBtn).build().perform();
		Thread.sleep(2000);
		mouse.release().perform();

	mouse.dragAndDrop(draggabl, droppabl).perform();
	mouse.dragAndDropBy(slider, 50, 0).perform();
	mouse.moveByOffset(2, 2).perform();
	mouse.sendKeys(nameinput, "Automation Testing").perform();
//		mouse.moveToElement(wikiHeading).doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
//				.moveToElement(nameinput).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		mouse
	    .moveToElement(wikiHeading)
	    .doubleClick()
	    .sendKeys(Keys.chord(Keys.CONTROL, "c"))
	    .click(nameinput)
	    .sendKeys(Keys.chord(Keys.CONTROL, "v"))
	    .perform();
		System.out.println(wikiHeading.getText());

		Assert.assertEquals(nameinput.getAttribute("value"), wikiHeading.getText(),
				"Copy Pase id not working properly");

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		mouse = new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
