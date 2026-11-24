package deposyt_crm;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

public class DeposytLogin {
	WebDriver driver;
	public DeposytLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	public void logins() {
    
    driver.manage().window().maximize();
	driver.get("https://app.deposyt.com/index.php?m=account");
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tarsier60796@aminating.com");
	driver.findElement(By.xpath("//*[@id='password']")).sendKeys("R4!zN1#tV6%");
	driver.findElement(By.xpath("//*[@id='remember-me' and @name='autologin_d']")).click();
	driver.findElement(By.xpath("//*[@type='submit']")).click();

}
	public void release() {
	    
	    driver.manage().window().maximize();
		driver.get("https://app.release.deposyt.com/index.php?m=account");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("viden92534@feralrex.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Nadsoft@1231");
		driver.findElement(By.xpath("//*[@id='remember-me' and @name='autologin_d']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}
	
}
