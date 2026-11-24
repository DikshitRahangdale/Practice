package webdrivermethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ConditionalMethods extends WebDriverMethods {
	@Test(priority = 5)
	public void condiotnal() {

		// isDisplay

		boolean button = driver.findElement(By.xpath("//*[@name='start' or @name='stop']")).isDisplayed();

		System.out.println("Button is Display : " + button);

		boolean textareaEnaable = driver.findElement(By.cssSelector("#textarea")).isEnabled();

		System.out.println("User Able to Enter text : " + textareaEnaable);

		boolean selected = driver.findElement(By.cssSelector("#male")).isSelected();

		System.out.println("Radio Button is Selected: " + selected);
	}
}
