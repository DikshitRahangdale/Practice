package Javascriptexecutor;

import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollBypixel extends DriverSetup {
  @Test
  public void f() {
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  js.executeScript("window.scrollBy(0, 500)");
	  
	  
  }
}
