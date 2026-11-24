package TestNG;

import org.testng.annotations.Test;

public class Groups3 {
	@Test(groups = "Smoke")
	public void tst1() {
		System.out.println("3 Smoke Testing");
	}

	@Test(groups = "Sanity")
	public void test2() {
		System.out.println("3 Sanity Testing");
	}

	@Test(groups = "Regression")
	public void test3() {
		System.out.println("3 Regression Testing");

	}
}
