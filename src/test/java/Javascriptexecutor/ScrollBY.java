package Javascriptexecutor;

import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollBY extends DriverSetup {
	@Test
	public void scrollby() {
		driver.get("https://testautomationpractice.blogspot.com/");

		js.executeScript("window.scrollBy(0,600)");

		long yoffset = (long) js.executeScript("return window.scrollY;");
		System.out.println(yoffset);
	}
}
