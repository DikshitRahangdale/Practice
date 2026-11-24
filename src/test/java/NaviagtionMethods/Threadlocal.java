package NaviagtionMethods;

import org.openqa.selenium.WebDriver;

public class Threadlocal {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver(WebDriver driver) {
		Threadlocal.driver.set(driver);
	}

	public static WebDriver getDriver() {
		return Threadlocal.driver.get();
	}

	public static void removeDriver() {
		Threadlocal.driver.remove();
	}
}
