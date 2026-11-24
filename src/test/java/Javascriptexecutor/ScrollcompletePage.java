package Javascriptexecutor;

import org.testng.annotations.Test;

import Driver.DriverSetup;

public class ScrollcompletePage extends DriverSetup {
  @Test
  public void f() {
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
  }
}
