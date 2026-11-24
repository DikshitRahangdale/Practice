package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Slider extends DriverSetup {
  @Test
  public void sliderhandle() {
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  WebElement slider1=driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
	  
	  System.out.println("Slider Min Position: "+slider1.getLocation());
	  
	  Actions mouseActions=new Actions(driver);
	  mouseActions.dragAndDropBy(slider1, 50, 0).perform();
	  
	  System.out.println("Slider Min Position after slide: "+slider1.getLocation());
  }
}
