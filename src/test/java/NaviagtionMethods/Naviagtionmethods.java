package NaviagtionMethods;

import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Naviagtionmethods extends DriverSetup {
	@Test
	public void naviagtion() {

		// 1)naviagtiio().To();

		driver.navigate().to("https://www.google.com/");

		driver.navigate().to("https://letcode.in/test");

		driver.navigate().refresh();

		driver.navigate().back();

		driver.navigate().forward();

		System.out.println("Page Title: " + driver.getTitle());
	}
}
