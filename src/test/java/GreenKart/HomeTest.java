package GreenKart;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends BaseClass {

	public HomePage home;

	@BeforeClass
	public void homePage() {
		home = new HomePage(DriverManager.getDriver());
		//test
	}

	@Test
	public void validateLogo() {
		String backColor = home.logoElement.getCssValue("color");
		System.out.println(backColor + "Text:-" + home.logoElement.getText());

	}

	@Test(priority = 1)
	public void testSearchField() {
		String productsName = "Brocolli";
		home.enterTextOnSearch(productsName);
		home.clickOnSearchIcon();
		List<String> products = home.getProducts();
		soft.assertEquals(products.size(), 1);
		String str = products.get(0);
		String actualProductName = products.get(0).split("-")[0].trim();
		soft.assertEquals(actualProductName, productsName, "Product name or search is not working");
	}
}
