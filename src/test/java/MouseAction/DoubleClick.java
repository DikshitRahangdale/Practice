package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class DoubleClick extends DriverSetup {
	@Test
	public void doubleClick() {
		driver.get("https://testautomationpractice.blogspot.com/");

		String field1String = driver.findElement(By.id("field1")).getAttribute("value");
		String field2 = driver.findElement(By.id("field2")).getAttribute("value");
		
		System.out.println(field1String);
		System.out.println(field2);

		Actions mouse = new Actions(driver);
		WebElement doubleclick=driver.findElement(By.xpath("//*[@id='field2']/following-sibling::button"));
		
		mouse.doubleClick(doubleclick).perform();
		
		String field3 = driver.findElement(By.id("field2")).getAttribute("value");
		System.out.println(field3);
		
		

	}
}
