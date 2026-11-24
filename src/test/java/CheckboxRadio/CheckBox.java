package CheckboxRadio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import LeetCodeTest.DriverSetups;
import LeetCodeTest.LeetCodeLogin;

public class CheckBox extends DriverSetups {
	@Test
	public void checkbox() {
		LeetCodeLogin login = new LeetCodeLogin(driver);
		login.login();

		WebElement rd = driver.findElement(By.cssSelector("a.card-footer-item[href='/radio']"));
		js.executeScript("arguments[0].click();", rd);

		WebElement firstRadio = driver.findElement(By.cssSelector("input[type='radio'][name='answer'][id='yes']"));
		if (!firstRadio.isSelected()) {
			firstRadio.click();
		}

		// 2) Confirm you can select only one radio button

		WebElement radiono = driver.findElement(By.cssSelector("input[type='radio'][name='one'][id='two'"));
		radiono.click();

		WebElement radiyes = driver.findElement(By.cssSelector("input[type='radio'][name='one'][id='one']"));

		Boolean yes = radiyes.isSelected();
		Boolean no = radiono.isSelected();

		if (no && !yes) {
			System.out.println("Only one Radio Button Selected");
		} else {
			System.out.print("Both Radio Button Selected");
		}

		// 3) Find the Bug

		WebElement yes2 = driver.findElement(By.cssSelector("#nobug"));
		WebElement no2 = driver.findElement(By.cssSelector("#bug"));

		yes2.click();
		no2.click();

		if (yes2.isSelected() && no2.isSelected()) {
			System.out.println("Its Bug Both Radio button is Selected");

		} else {
			System.out.println("Its Not Bug , only one button is selected ");
		}

		// 4) Find which one is selected

		WebElement bar = driver.findElement(By.id("notfoo"));
		WebElement foo = driver.findElement(By.cssSelector("#foo"));

		if (bar.isSelected()) {
			System.out.println("Bar Radio Button is Selected");

		} else {
			System.out.println("FOO Button is selected ");
		}

		// 5)Confirm last field is disabled

		WebElement maybe = driver.findElement(By.cssSelector("#maybe"));

		if (!maybe.isEnabled()) {
			System.out.println("The MayBe Radio Button is Disabled");
		} else {
			System.out.println("mayBe Button is Enabled");
		}

		// 6) Find if the checkbox is selected?

		WebElement checkboxElement = driver.findElement((By.xpath("//label[normalize-space()=\"Remember me\"]/input")));

		if (checkboxElement.isSelected()) {
			System.out.println("CheckBox is Selected ");

		} else {
			System.out.println("Checkbox unselected");
		}

		// 7) Accept the T&C

		WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		checkBox.click();

		if (checkBox.isSelected()) {
			System.out.println("CheckBox is Selected ");

		}

	}
}
