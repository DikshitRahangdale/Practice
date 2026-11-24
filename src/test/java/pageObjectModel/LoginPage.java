package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By username = By.id("email");
	By password = By.id("password");
	By loginBtn = By.cssSelector("button.deposytssologinbtn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String username) {
		driver.findElement(this.username).sendKeys(username);
	}

	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);

	}

	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}

}
