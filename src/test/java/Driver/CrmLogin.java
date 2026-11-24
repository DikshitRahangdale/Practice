package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CrmLogin {
	WebDriver driver;
	
	public CrmLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login()
	{
		driver.get("https://app.deposyt.com/index.php?m=account");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("cirejo5004@cexch.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Nadsoft@1234");
		driver.findElement(By.xpath("//*[@id='remember-me' and @name='autologin_d']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

}
