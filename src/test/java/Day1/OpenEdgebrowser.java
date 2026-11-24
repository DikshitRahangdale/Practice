package Day1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class OpenEdgebrowser {
	public static void main(String... args)
	{
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.forbes.com/billionaires/");
		
		String expeectedURL="https://www.forbes.com/billionaires/";
		
		Assert.assertEquals(driver.getCurrentUrl(), expeectedURL,"WebSite URl Not Match");
		driver.close();
	}

}
