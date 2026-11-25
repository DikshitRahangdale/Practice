package GreenKart;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver(WebDriver drivers) {
		driver.set(drivers);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void removeDriver() {
		driver.remove();
		
	}

}
