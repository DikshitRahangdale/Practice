package MouseAction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SliderandKeyButton {

	WebDriver driver;
	Actions mouse;

	@Test
	public void f() {

		// handle Slidder

		WebElement leftslider = driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
		WebElement rightslider = driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));

		System.out.println("Left slider Location: " + leftslider.getLocation());
		System.out.println("Right slider Location: " + rightslider.getLocation());

		mouse.dragAndDropBy(leftslider, 100, 0).perform();
		mouse.dragAndDropBy(rightslider, -100, 0).perform();

		System.out.println("Left slider Location after slides: " + leftslider.getLocation());
		System.out.println("Right slider Location  after slides: " + rightslider.getLocation());

		// Keyboard keys

		WebElement nameinput = driver.findElement(By.cssSelector("#name"));
		nameinput.sendKeys("Testing");
		mouse.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		WebElement emailinput = driver.findElement(By.cssSelector("#email"));
		emailinput.click();
		mouse.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		System.out.println(emailinput.getAttribute("value"));

		// Control + link
		WebElement home = driver.findElement(By.xpath("//*[@id='PageList2']/child::div//li/a[text()='Home']"));

		mouse.keyDown(Keys.CONTROL).click(home).keyUp(Keys.CONTROL).perform();

		Set<String> allwindowSet = driver.getWindowHandles();
		System.out.println("Total Open tabs: " + allwindowSet.size());
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		mouse = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
