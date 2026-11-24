package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.CrmLogin;
import Driver.DriverSetup;

public class CustomDropdowns extends DriverSetup {
	@Test
	public void customdropdowns() {

		CrmLogin crm = new CrmLogin(driver);
		crm.login();
		driver.findElement(By.cssSelector("#user-dropdown_main_DD")).click();
		List<WebElement> alluser = driver
				.findElements(By.xpath("//*[@class='sugesstion-check lower_userassign_users']/span/label/div/span"));

		List<WebElement> all = driver
				.findElements(By.xpath("//*[@class='sugesstion-check lower_userassign_users']/span/label/span"));

		System.out.println("All Users: ");

		for (WebElement user : alluser) {
			System.out.println(user.getText());

			if (user.getText().contains("Dikshit")) {
				user.click();
			}
		}

	}
}
