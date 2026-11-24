package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnotations2 {
	@Test(priority=1)
	  public void testmethod() {
		  System.out.println("Second class First Test Methods");
	  }
	  @Test(priority=2)
	  public void testmethod2() {
		  System.out.println("Second class Second Test Methods");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Second class Before Method");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Second class After Methods");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Second class Before Class");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Second class After Class");
	  }


	

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Second class Before Suite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Second class After Suite");
	  }
}
