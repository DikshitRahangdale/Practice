package practice;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.get("https://app.deposyt.com/index.php?m=courses");
		
		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println("Total  Link: "+link.size());
		int count=0;
		
		
//		boolean setting=driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/img")).isDisplayed();
//		System.out.println(setting);
		
		for(WebElement lnk:link)
		{
		
			String links=lnk.getAttribute("href");
			
			if(links==null || link.isEmpty())
			{
				System.out.println("Link is Not Present");
				continue;
			}
			
			try {
				URL urllin=new URL(links);
				HttpURLConnection connection=(HttpURLConnection) urllin.openConnection();
				connection.connect();
				
				if(connection.getResponseCode()>=400)
				{
					System.out.println("Broken Link===>"+links);
					count++;
				}
				else {
					System.out.println("Not Broken Link==>"+links);
				}
				
				
			} catch (Exception e) {
				
				
			}
			
		}
		System.out.println("Hello It is Broken Link Pro");
		
		
		System.out.println("Total Broken Links: "+count);
		
		
	}

}
