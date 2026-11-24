package ShadowDOM;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "data", indices = { 0, 1, 2 })
	public Object[][] dataprovidr() {
		Object[][] obj = new Object[][] { { "user1", "User1P" }, { "user2", "User1P" }, { "user3", "User1P" },
				{ "user4", "User1P" } };
		return obj;
	}
}
