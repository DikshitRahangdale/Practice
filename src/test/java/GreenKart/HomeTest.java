package GreenKart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends BaseClass {

	public HomePage home;

	@BeforeClass
	public void homePage() {
		home = new HomePage(DriverManager.getDriver());
		;
	}

	@Test
	public void validateLogo() {
		String backColor = home.logoElement.getCssValue("color");
		System.out.println(backColor);
	}
}
