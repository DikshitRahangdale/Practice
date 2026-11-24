package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class ParametersAndParallelTesting {
	public WebDriver driver;

	@Test
	public void test() {
		driver.get("https://app.release.deposyt.com/index.php?m=account");
	}

	@Parameters("Browsers")
	@BeforeTest
	public void beforeTest(@Optional("Chrome") String br) {

		switch (br) {
		case "Chrome":
			driver = new ChromeDriver();
			break;

		case "Edge":
			driver = new EdgeDriver();
			break;
		case "FireFox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Enter Correct Option");
			return;

		}
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
