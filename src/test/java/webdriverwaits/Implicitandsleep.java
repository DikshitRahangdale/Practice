package webdriverwaits;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Implicitandsleep {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//button[@class='start' or @class='stop']")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://testautomationpractice.blogspot.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
