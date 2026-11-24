package webDriverWait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AllWaitingMethods {
	WebDriverWait wait;
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(null));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(null));
	 // wait.until(ExpectedConditions.elementToBeClickable(null));
	  wait.until(ExpectedConditions.textToBePresentInElementLocated(null, null));
	  wait.until(ExpectedConditions.alertIsPresent());
	  wait.until(ExpectedConditions.titleContains(null));
	//  wait.until(ExpectedConditions.elementToBeSelected(null));
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(null));
	 // wait.until(ExpectedConditions.elementSelectionStateToBe(null, false));
	  wait.until(ExpectedConditions.urlContains(null));
	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
