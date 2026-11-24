package TestNG;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name="LogData")
  public Object[][] dataprovide() {
	  return new Object[][] {{"sdsadasd","sdaasdasd"},
		  {"sdasdasd","sdasdasd"},{"sadsadas","asdffdf"},
		  {"sdsadasd","sdasd"},{"yogeshmpandit17@gmail.com","Nadsoft@1234"}
	  
  };
}
}
