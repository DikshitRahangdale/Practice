package ShadowDOM;


import org.testng.annotations.Test;

public class Dataproviders {

	@Test(dataProvider = "data",dataProviderClass=DataProviderClass.class)
	public void dataproviderMethodsww(String dat1, String dat2) {
		System.out.println(dat1 + " " + dat2);

	}


}
