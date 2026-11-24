package Tables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Tabletwo {
	WebDriver driver;
  @Test
  public void tabledynamic() {
      
	  //Table Headers
	  
	  List<WebElement> tableheader=driver.findElements(By.xpath("//table[@id='taskTable']/thead/tr/th"));
	  
	 for(WebElement header:tableheader)
	 {
		 System.out.print(header.getText());
	 }
	 
	 //Table Rows
	 
	  
	  List<WebElement> tablerows=driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr/td"));
	  
	 for(WebElement rows:tablerows)
	 {
		 System.out.println(rows.getText());
	 }
	  
	
	  
	  
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
