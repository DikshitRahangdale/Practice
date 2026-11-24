package LeetCodeTest;

import org.openqa.selenium.WebDriver;

public class LeetCodeLogin {
	WebDriver driver;

	public LeetCodeLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void login() {
		driver.get("https://letcode.in/test");
	}

}
