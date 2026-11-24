package TestNG;

import org.testng.annotations.Test;

public class Groups2 {
	@Test(groups = "Smoke")
	public void tst1() {
		System.out.println("2 Smoke Testing");
	}

	@Test(groups = "Sanity")
	public void test2() {
		System.out.println("2 Sanity Testing");
	}

	@Test(groups = "Regression")
	public void test3() {
		System.out.println("2 Regression Testing");

	}
}
