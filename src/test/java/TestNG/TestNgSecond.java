package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestNgSecond {
	WebDriver driver;
  @Test
  public void f() {
	  System.out.println("Second Class");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://pixabay.com/users/pexels-2286921/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
