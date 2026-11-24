package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class SelectDropdown extends DriverSetup {
	@Test(priority=0)
	public void dropdownselect() {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement allcountry = driver.findElement(By.cssSelector("#country"));
		allcountry.click();

		Select country = new Select(allcountry);

		// Get All Country
		List<WebElement> allcountries = country.getOptions();
		System.out.println("Total Countries: " + allcountries.size());

		for (WebElement count : allcountries) {

			System.out.println(count.getText());
		}

		// Verify its multiselected

		System.out.println("Multiselectd Dropdon: " + country.isMultiple());

		// Select By visible Text

		country.selectByVisibleText("India");

		// Get Select Country

		System.out.println("Selected Options: " + country.getFirstSelectedOption().getText());
		
		

	}
	
	@Test(priority=1)
	public void multiselect()
	{
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement multiElement=driver.findElement(By.cssSelector("#colors"));
		
		Select colours=new Select(multiElement);
		
		System.out.println("Multi Selected: "+colours.isMultiple());
		
		List<WebElement> allColours=colours.getOptions();
		
		for(WebElement clors:allColours)
		{
			System.out.println(clors.getText());
		}
		
		colours.selectByValue("white");
		
		System.out.println("Selected Colour: "+ colours.getFirstSelectedOption().getText());
		
		colours.selectByVisibleText("Green");
		
		List<WebElement> selected=colours.getAllSelectedOptions();
		
		
		System.out.println("All Selected Options: ");
		for(WebElement all:selected)
		{
			System.out.println(all.getText());
		}
	}
}
