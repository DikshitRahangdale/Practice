package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	public WebDriver driver;

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(css = "button.deposytssologinbtn")
	WebElement loginBtn;

	public LoginPageFactory(WebDriver driverr) {
		this.driver = driverr;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username) {
		this.username.sendKeys(username);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}
}
