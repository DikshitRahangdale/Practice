package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;

public class DragandDrop extends DriverSetups {
	@Test
	public void dragdrop() {
		driver.get("https://testautomationpractice.blogspot.com/");

		Actions mouse = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		String target_colour=target.getCssValue("background");
		System.out.println("Before Colour: "+target_colour);

		mouse.dragAndDrop(source, target).perform();
		
		WebElement target2 = driver.findElement(By.id("droppable"));
		String target2_colour=target2.getCssValue("backgroundr");
		System.out.println("Before Colour: "+target2_colour);

	}
}
