package Utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReports {
  @Test
  public void A() {
	  System.out.println("Pass Test Case");
  }
  @Test
  public void B() {
	  Assert.assertEquals(false, true);
  }
  @Test(dependsOnMethods="B")
  public void C() {
	  System.out.println("Dependent Methods");
  }
  
}
