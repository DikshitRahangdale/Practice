package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.testng.annotations.AfterTest;

public class ParallelTest2 extends ParallelTestingBrowsers {
	@Test
	public void test() {
		getDriver().get("https://app.release.deposyt.com/index.php?m=account");
		System.out.print("Testing");
		

	}

	@BeforeTest
	@Parameters("browsers")
	public void beforeTest(String browsers) {
		intilizeBrowsers(browsers);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterTest
	public void afterTest() {
		getDriver().close();
	}

}
