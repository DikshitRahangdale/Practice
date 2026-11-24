package crossBrowsers;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDriven {
	
	
  @Parameters({"username" , "password"})
  @Test
  public void f(String username,String password) {
	  System.out.println(username+" "+password);
  }
}
