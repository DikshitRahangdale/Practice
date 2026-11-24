package TestNG;

import org.testng.annotations.Test;

public class FirstDay {
	@Test
	public void first() {
		System.out.println("First Method");
	}

	@Test(priority=1)
	public void second() {
		System.out.println("Second Method");
	}

	@Test(priority=3)
	public void third() {
		System.out.println("Third Method");
	}

	@Test
	public void fourth() {
		System.out.println("Fourth Method");
	}
}
