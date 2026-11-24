package MouseAction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ActionsClass {
	WebDriver driver;
	Actions mouse;

	@Test
	public void actionmethod() throws InterruptedException {

		// Mouse Hover
		WebElement pointmeButton = driver.findElement(By.xpath("//button[text()='Point Me']"));
		mouse.moveToElement(pointmeButton).perform();
		WebElement dropdownOptions = driver
				.findElement(By.xpath("//button[text()='Point Me']/parent::div/descendant::a[position()='2']"));
		mouse.moveToElement(dropdownOptions).click().perform();

		// Double Click
		String field1text = driver.findElement(By.cssSelector("#field1")).getAttribute("value");

		WebElement copybutton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		mouse.doubleClick(copybutton).perform();
		String field2text = driver.findElement(By.cssSelector("#field2")).getAttribute("value");

		if (field1text.equals(field2text))
			System.out.println("Text Sucesfully Copied");
		else {
			System.out.println("Text not Copied");
		}

		// Drag & Drop

		WebElement draggable = driver.findElement(By.cssSelector(".ui-draggable-handle"));
		WebElement dropable = driver.findElement(By.cssSelector(".ui-droppable"));

		mouse.dragAndDrop(draggable, dropable).perform();

		System.out.println("After Drag and Drop colour: " + dropable.getAttribute("background-color"));

		// click and Hold
		WebElement slidericon = driver.findElement(By.xpath("//*[@id='slider-range']/child::span[1]"));
		mouse.clickAndHold(slidericon).perform();
		System.out.println("color: " + dropable.getAttribute("color"));

		Thread.sleep(2000);
		mouse.release(slidericon).perform();

		// Drag and Drop slider

		mouse.dragAndDropBy(slidericon, 100, 0).perform();

		WebElement heading = driver.findElement(By.cssSelector("#header-inner div h1"));
		Point headinglocation = heading.getLocation();
		int xlocation = headinglocation.getX();
		int ylocation = headinglocation.getY();

		mouse.moveToLocation(xlocation, ylocation).perform();
		
		

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		mouse = new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/#");
	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

}
