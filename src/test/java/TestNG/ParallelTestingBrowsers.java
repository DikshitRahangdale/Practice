package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParallelTestingBrowsers {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public void intilizeBrowsers(String brosers) {

		switch (brosers) {
		case "Chrome":
			driver.set(new ChromeDriver());
			break;
		case "Edge": 
			driver.set(new EdgeDriver());
			break;

		case "FireFox":
			driver.set(new FirefoxDriver());
			break;
		default:
			System.out.println("Provde Correct Browser");
			return;

		}

	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
