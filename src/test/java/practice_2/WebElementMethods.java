package practice_2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementMethods {
	WebDriver driver;
	Actions mouse;

	@Test
	public void webElement() {
		WebElement button = driver.findElement(By.xpath("//*[@name='start' or @name='stop']"));
		Point locationBtn = button.getLocation();
		int x = locationBtn.getX();
		int y = locationBtn.getY();
		System.out.println("X & Y Location of Button:-->" + x + " ," + y);
		mouse.moveByOffset(x, y).perform();

		Dimension buttonSize = button.getSize();
		int width = buttonSize.getWidth();
		int height = buttonSize.getHeight();
		System.out.println("Button Width & Height:--->" + width + " , " + height);
		System.out.println(button.getCssValue("color"));
		
		Rectangle rect=button.getRect();
		int xLocation=rect.getX();
		int yLocation=rect.getY();
		int widthRect=rect.getWidth();
		int heightRect=rect.getHeight();
		System.out.println("Rectangle X & Y Location:-->" + xLocation + " ,"+yLocation);
		System.out.println("Rectangle Width & Height:-->" + widthRect + " ,"+heightRect);

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		mouse = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
