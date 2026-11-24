package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class DragandDropBy extends DriverSetup {
	@Test
	public void draganddropby() {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement targetWebElement = driver.findElement(By.id("droppable"));
		WebElement sourcElement = driver.findElement(By.id("draggable"));

		Point point = targetWebElement.getLocation();
		int x = point.getX();
		int y = point.getY();

		Actions mouseActions = new Actions(driver);
		mouseActions.dragAndDropBy(sourcElement, x, y);
	}
}
