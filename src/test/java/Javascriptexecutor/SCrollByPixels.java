package Javascriptexecutor;

import org.testng.annotations.Test;

import Driver.DriverSetup;

public class SCrollByPixels extends DriverSetup {
	@Test
	public void scrollbypixel() throws InterruptedException {

		driver.get("https://testautomationpractice.blogspot.com/");

		js.executeScript("window.scrollBy(0,500)");
		long yoffset = (long) js.executeScript("return window.scrollY;");
		System.out.println(yoffset);

		js.executeScript("window.scrollBy(0,-500)");

		long yoff = (long) js.executeScript("return window.scrollY;");
		System.out.println(yoff);
	}
}
