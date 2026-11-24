package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HardAssertions {

	@Test
	public void assertions() {
		Assert.assertEquals("Dikshit", "Dikshit", "It  does  not Match");
		Assert.assertTrue(1 == 1, "Its Correct");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Test", "Test");
		System.out.println("Soft Assertions");
		soft.assertAll();
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
