package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GroupsMultipleTestMethods {
	
  @Test(groups="Smoke",priority=-1,dependsOnMethods = {"b","c"})
  public void f() {
	  System.out.println("Smoke Testing  -1");
  }
  @Test(groups="Smoke",priority=-2)
  public void b() {
	  System.out.println("Smoke Testing -2");
  }
  @Test(groups="Sanity",priority=0,dependsOnGroups = "Smoke")
  public void c() {
	  System.out.println("Sanity Testing 0");
  }
  @Test(groups={"Sanity","Smoke"},priority=1)
  public void d() {
	  System.out.println("Smoke & Sanity Testing 1");
  }
   @Test(groups="Regression",priority=2)
  public void e() {
	   System.out.println("Regression Testing 2");
  }
  @Test(groups="Regression",priority=3)
  public void t() {
	  System.out.println("Regression Testing 3");
  }
 
}
